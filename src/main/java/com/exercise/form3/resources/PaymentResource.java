package com.exercise.form3.resources;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@Path("/payments")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PaymentResource {

    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    @Context
    protected UriInfo info;
    private PaymentDAO paymentDAO;

    public PaymentResource(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    @GET
    @Path("/{id}")
    public List<Payment> fetch(@PathParam("id") String id) {
        return paymentDAO.fetchById(id);
    }

    @POST
    public int create(@Valid Payment payment) {
        // Jackson serialization
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(MAPPER.writeValueAsString(payment.getAttributes()));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("JsonProcessingException: " + e.getMessage());
        }
        return paymentDAO.insert(payment, sb.toString());
    }

    @PUT
    @Path("/{id}")
    public int update(@PathParam("id") String id, @Valid Payment payment) {
        payment = payment.setId(id);
        // Jackson serialization
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(MAPPER.writeValueAsString(payment.getAttributes()));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("JsonProcessingException: " + e.getMessage());
        }
        return paymentDAO.update(payment, sb.toString());
    }

    @DELETE
    @Path("/{id}")
    public int delete(@PathParam("id") String id) {
        return paymentDAO.deleteById(id);
    }

    @GET
    public List<Payment> fetchOffsetLimit(@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit) {
        return paymentDAO.fetchOffsetLimit(offset, limit);
    }
}
