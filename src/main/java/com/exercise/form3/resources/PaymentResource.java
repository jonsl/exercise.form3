package com.exercise.form3.resources;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
        // Jackson serialization
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(MAPPER.writeValueAsString(payment.getAttributes()));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("JsonProcessingException: " + e.getMessage());
        }
        paymentDAO.insert(payment, sb.toString());

        return payment;
    }

    @PUT
    @Path("/{id}")
    public Payment update(@PathParam("id") String id, @Valid Payment payment) {
        payment = payment.setId(id);
        // Jackson serialization
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(MAPPER.writeValueAsString(payment.getAttributes()));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("JsonProcessingException: " + e.getMessage());
        }
        paymentDAO.update(payment, sb.toString());

        return payment;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        paymentDAO.deleteById(id);
    }
}
