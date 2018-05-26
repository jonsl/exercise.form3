package com.exercise.form3.resources;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.jackson.Jackson;
//import jersey.repackaged.com.google.common.base.Optional;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

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
    public Response fetch(@PathParam("id") String id) {
        Payment fetchedPayment = paymentDAO.fetchById(id);
        if (fetchedPayment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(fetchedPayment).build();
    }

    @POST
    public Response create(@Valid Payment payment) {
        // Jackson serialization
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(MAPPER.writeValueAsString(payment.getAttributes()));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("JsonProcessingException: " + e.getMessage());
        }
        if (paymentDAO.insert(payment, sb.toString()) <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(payment).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") String id, @Valid Payment payment) {
        payment = payment.setId(id);
        // Jackson serialization
        StringBuilder sb = new StringBuilder();
        try {
            sb.append(MAPPER.writeValueAsString(payment.getAttributes()));
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            System.err.println("JsonProcessingException: " + e.getMessage());
        }
        if (paymentDAO.update(payment, sb.toString()) <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(payment).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") String id) {
        if (paymentDAO.deleteById(id) <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(id).build();
    }

    @GET
    public Response fetchOffsetLimit(@QueryParam("offset") Integer offset, @QueryParam("limit") Integer limit) {
        List<Payment> paymentList = paymentDAO.fetchOffsetLimit(offset, limit);
        if (paymentList.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(paymentList).build();
    }
}
