package com.exercise.form3.resources;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import static io.dropwizard.testing.FixtureHelpers.fixture;

@Path("/payments")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PaymentResource {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();

    private PaymentDAO paymentDAO;

    public PaymentResource(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @GET
    @Path("/{id}")
    public Payment fetch(@PathParam("id") String id) {
        return paymentDAO.fetchById(id);
    }

    @POST
    public Payment create(@Valid Payment payment) {

        StringBuilder sb = new StringBuilder();
        try {

            sb.append(MAPPER.writeValueAsString(payment.getAttributes()));

        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("IndexOutOfBoundsException: " + e.getMessage());
        }

        paymentDAO.insert(payment, sb.toString());

        return payment;
    }

//    @PUT
//    @Path("/{id}")
//    public Payment update(@PathParam("id") Integer id, @Valid Payment payment) {
//        Payment updatePayment = payment;
//        updatePayment.
//
//        paymentDAO.update(payment);
//
//        return updatePerson;
//    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") Integer id) {
        paymentDAO.deleteById(id);
    }
}
