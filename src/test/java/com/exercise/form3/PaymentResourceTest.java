package com.exercise.form3;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;
import com.exercise.form3.resources.PaymentResource;
import io.dropwizard.testing.junit.ResourceTestRule;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

//import org.mockito.Mockito;
//import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Unit tests for {@link com.exercise.form3.resources.PaymentResource}.
 */
public class PaymentResourceTest {

    private static final PaymentDAO dao = mock(PaymentDAO.class);
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new PaymentResource(dao))
            .build();
    private static final String KNOWN_PAYMENT_ID = "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43";
    private static final String UNKNOWN_PAYMENT_ID = "iooi4j5i-5ioi4iojo3-oijoi4j-22k4k";
    private final Payment payment = PaymentTests.getTestPayment();

    @Before
    public void setup() {
        when(dao.fetchById(eq(KNOWN_PAYMENT_ID))).thenReturn(payment);
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
    public void testGetValidPayment() {
        Response response = resources.client()
                .target("/payments/" + KNOWN_PAYMENT_ID)
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.OK.getStatusCode()));

        assertThat(fixture("fixtures/payment.json"), is(response.readEntity(String.class)));

        verify(dao).fetchById(KNOWN_PAYMENT_ID);
    }

    @Test
    public void testGetInvalidPayment() {
        Response response = resources.client()
                .target("/payments/" + UNKNOWN_PAYMENT_ID)
                .request()
                .get();

        assertThat(response.getStatus(), is(Response.Status.NOT_FOUND.getStatusCode()));

        assertThat("", is(response.readEntity(String.class)));

        verify(dao).fetchById(UNKNOWN_PAYMENT_ID);
    }


}