package com.exercise.form3;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;
import com.exercise.form3.resources.PaymentResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static junit.framework.TestCase.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link com.exercise.form3.resources.PaymentResource}.
 */
public class PaymentResourceTest {
    private static final PaymentDAO dao = mock(PaymentDAO.class);
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PaymentResource(dao))
            .build();
    private static final String KNOWN_PAYMENT_ID_1 = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
    private static final String KNOWN_PAYMENT_ID_2 = "09a8fe0d-e239-4aff-8098-7923eadd0b98";
    private static final String UNKNOWN_PAYMENT_ID = "iooi4j5i-5ioi-4ioj-o3de-oijoi4j22k4k";

    private static final Payment payment_1 = PaymentTests.getValidPayment_1();
    private static final Payment payment_2 = PaymentTests.getValidPayment_2();
    private static final Payment invalidPayment = PaymentTests.getInvalidPayment();

    @Before
    public void setup() {

        when(dao.fetchById(eq(KNOWN_PAYMENT_ID_1))).thenReturn(payment_1);
        when(dao.insert(payment_1, Payment.PaymentAttribute.getJson(payment_1.getAttributes()))).thenReturn(1);
        when(dao.update(payment_2, Payment.PaymentAttribute.getJson(payment_2.getAttributes()))).thenReturn(1);
        when(dao.deleteById(KNOWN_PAYMENT_ID_1)).thenReturn(1);
        when(dao.fetchOffsetLimit(1, 1)).thenReturn(new ArrayList<Payment>() {{
            add(payment_2);
        }});

        // we have to reset the mock here after each test if
        // using a [static] @ClassRule, or use a [non-static] @Rule
    }

    @After
    public void tearDown() {
        // we have to reset the mock after each test because
        // we are using a [static] @ClassRule
        reset(dao);
    }

    @Test
    public void testValidGetPayment() {
        Response response = resources.client()
                .target("/payments/" + KNOWN_PAYMENT_ID_1)
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        assertThat(response.readEntity(String.class), is(fixture("fixtures/payment_1.json")));

        verify(dao).fetchById(KNOWN_PAYMENT_ID_1);
    }

    @Test
    public void testInvalidGetPayment() {
        Response response = resources.client()
                .target("/payments/" + UNKNOWN_PAYMENT_ID)
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));

        assertThat(response.readEntity(String.class), is(""));

        verify(dao).fetchById(UNKNOWN_PAYMENT_ID);
    }

    @Test
    public void testValidPostPayment() {
        Response response = resources.client()
                .target("/payments")
                .request()
                .post(Entity.entity(Payment.getJson(payment_1), MediaType.APPLICATION_JSON));

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        assertThat(response.readEntity(String.class), is(fixture("fixtures/payment_1.json")));

        verify(dao).insert(payment_1, Payment.PaymentAttribute.getJson(payment_1.getAttributes()));
    }

    @Test
    public void testInvalidPostPayment() {
        Response response = resources.client()
                .target("/payments")
                .request()
                .post(Entity.entity(Payment.getJson(invalidPayment), MediaType.APPLICATION_JSON));

        assertThat(response.getStatus(), is(422));  // Unprocessable Entity

        assertEquals("{\"errors\":[\"attributes may not be null\"]}", response.readEntity(String.class).toString());
    }

    @Test
    public void testValidUpdatePayment() {
        Response response = resources.client()
                .target("/payments/" + KNOWN_PAYMENT_ID_2)
                .request()
                .put(Entity.entity(Payment.getJson(payment_2), MediaType.APPLICATION_JSON));

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        assertThat(response.readEntity(String.class), is(fixture("fixtures/payment_2.json")));

        verify(dao).update(payment_2, Payment.PaymentAttribute.getJson(payment_2.getAttributes()));
    }

    @Test
    public void testInvalidUpdatePayment() {
        Response response = resources.client()
                .target("/payments/" + KNOWN_PAYMENT_ID_1)
                .request()
                .put(Entity.entity(Payment.getJson(payment_1), MediaType.APPLICATION_JSON));

        assertThat(response.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));

        assertThat(response.readEntity(String.class).isEmpty(), is(true));

        verify(dao).update(payment_1, Payment.PaymentAttribute.getJson(payment_1.getAttributes()));
    }

    @Test
    public void testValidDeletePayment() {
        Response response = resources.client()
                .target("/payments/" + KNOWN_PAYMENT_ID_1)
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        assertEquals(fixture("fixtures/payment_1.json"), response.readEntity(String.class));
    }

    @Test
    public void testInvalidDeletePayment() {
        Response response = resources.client()
                .target("/payments/" + KNOWN_PAYMENT_ID_2)
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));

        assertThat(response.readEntity(String.class).isEmpty(), is(true));
    }

    @Test
    public void fetchValidOffsetLimit() {
        Response response = resources.client()
                .target("/payments/?offset=1&limit=1")
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        List<Payment> payments = response.readEntity(new GenericType<List<Payment>>() {});

        assertThat(payments.size(), is(1));

        assertEquals(fixture("fixtures/payment_2.json"), Payment.getJson(payments.get(0)));

        verify(dao).fetchOffsetLimit(1, 1);
    }

    @Test
    public void fetchInvalidOffsetLimit() {
        Response response = resources.client()
                .target("/payments/?offset=2&limit=1")
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));

        List<Payment> payments = response.readEntity(new GenericType<List<Payment>>() {});

        assertNull(payments);

        verify(dao).fetchOffsetLimit(2, 1);
    }
}
