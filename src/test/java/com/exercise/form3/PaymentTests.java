package com.exercise.form3;

import com.exercise.form3.api.Payment;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static io.dropwizard.testing.FixtureHelpers.fixture;
import static org.junit.Assert.assertEquals;

/**
 * payment representation tests: {@link Payment}
 */

public class PaymentTests {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    private static final String NULL_ERROR_MESSAGE = "may not be null";

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    static Payment getValidPayment_1() {
        return new Payment(
                "Payment",
                "4ee3a8d8-ca7b-4290-a52c-dd5b6165ec43",
                0,
                "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb",
                new Payment.PaymentAttribute(
                        "100.21",
                        new Payment.BeneficiaryParty(
                                "W Owens",
                                "31926819",
                                "BBAN",
                                0,
                                "1 The Beneficiary Localtown SE2",
                                "403000",
                                "GBDSC",
                                "Wilfred Jeremiah Owens"),
                        new Payment.ChargesInformation(
                                "SHAR",
                                new ArrayList<>(Arrays.asList(
                                        new Payment.SenderCharges(
                                                "5.00",
                                                "GBP"),
                                        new Payment.SenderCharges(
                                                "10.00",
                                                "USD")
                                )),
                                "1.00",
                                "USD"),
                        "GBP",
                        new Payment.DebtorParty(
                                "EJ Brown Black",
                                "GB29XABC10161234567801",
                                "IBAN",
                                "10 Debtor Crescent Sourcetown NE1",
                                "203301",
                                "GBDSC",
                                "Emelia Jane Brown"),
                        "Wil piano Jan",
                        new Payment.Fx(
                                "FX123",
                                "2.00000",
                                "200.42",
                                "USD"),
                        "1002001",
                        "123456789012345678",
                        "Paying for goods/services",
                        "FPS",
                        "Credit",
                        "2017-01-18",
                        "Payment for Em's piano lessons",
                        "InternetBanking",
                        "ImmediatePayment",
                        new Payment.SponsorParty(
                                "56781234",
                                "123123",
                                "GBDSC")
                )
        );
    }

    static Payment getValidPayment_2() {
        return new Payment(
                "Payment",
                "09a8fe0d-e239-4aff-8098-7923eadd0b98",
                0,
                "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb",
                new Payment.PaymentAttribute(
                        "100.21",
                        new Payment.BeneficiaryParty(
                                "W Owens",
                                "31926819",
                                "BBAN",
                                0,
                                "1 The Beneficiary Localtown SE2",
                                "403000",
                                "GBDSC",
                                "Wilfred Jeremiah Owens"),
                        new Payment.ChargesInformation(
                                "SHAR",
                                new ArrayList<>(Arrays.asList(
                                        new Payment.SenderCharges(
                                                "5.00",
                                                "GBP"),
                                        new Payment.SenderCharges(
                                                "10.00",
                                                "USD")
                                )),
                                "1.00",
                                "USD"),
                        "GBP",
                        new Payment.DebtorParty(
                                "EJ Brown Black",
                                "GB29XABC10161234567801",
                                "IBAN",
                                "10 Debtor Crescent Sourcetown NE1",
                                "203301",
                                "GBDSC",
                                "Emelia Jane Brown"),
                        "Wil piano Jan",
                        new Payment.Fx(
                                "FX123",
                                "2.00000",
                                "200.42",
                                "USD"),
                        "1002001",
                        "123456789012345678",
                        "Paying for goods/services",
                        "FPS",
                        "Credit",
                        "2017-01-18",
                        "Payment for Em's piano lessons",
                        "InternetBanking",
                        "ImmediatePayment",
                        new Payment.SponsorParty(
                                "56781234",
                                "123123",
                                "GBDSC")
                )
        );
    }

    static Payment getInvalidPayment() {
        return new Payment(
                "Payment",
                "09a8fe0d-e239-4aff-8098-7923eadd0b98",
                0,
                "743d5b63-8e6f-432e-a8fa-c5d8d2ee5fcb",
                null);
    }

    @Test
    public void serializesToJson_1() throws Exception {
        final Payment payment = getValidPayment_1();
        assertEquals(fixture("fixtures/payment_1.json"), MAPPER.writeValueAsString(payment));
    }

    @Test
    public void deserializesFromJson_1() throws Exception {
        final Payment payment = getValidPayment_1();
        assertEquals(payment, MAPPER.readValue(fixture("fixtures/payment_1.json"), Payment.class));
    }

    @Test
    public void serializesToJson_2() throws Exception {
        final Payment payment = getValidPayment_2();
        assertEquals(fixture("fixtures/payment_2.json"), MAPPER.writeValueAsString(payment));
    }

    @Test
    public void deserializesFromJson_2() throws Exception {
        final Payment payment = getValidPayment_2();
        assertEquals(payment, MAPPER.readValue(fixture("fixtures/payment_2.json"), Payment.class));
    }

    // Should be replaced with individual class field validator tests
    @Test
    public void validate_not_null() throws Exception {
        Payment payment = new Payment();

        Set<ConstraintViolation<Payment>> constraintViolations = validator.validate(payment);

        assertEquals(4, constraintViolations.size());
        assertEquals(NULL_ERROR_MESSAGE, constraintViolations.iterator().next().getMessage());
    }
}
