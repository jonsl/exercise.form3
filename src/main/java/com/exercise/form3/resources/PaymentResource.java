package com.exercise.form3.resources;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;
import java.util.StringJoiner;

/**
 * model the Payment resources exposed in RESTful API using Jersey
 */

@Path("/payments")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PaymentResource {

    @Context
    UriInfo uriInfo;

    private PaymentDAO paymentDAO;

    public PaymentResource(PaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    public URI getUri() {
        return uriInfo.getBaseUriBuilder().path(PaymentResource.class).build();
    }

    @GET
    @Path("/{paymentId}")
    public Response fetch(@PathParam("paymentId") String id) {
        Payment fetchedPayment = paymentDAO.fetchById(id);
        if (fetchedPayment == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(getFullJsonResponse(fetchedPayment)).build();
    }

    @POST
    public Response create(@Valid Payment payment) {
        if (paymentDAO.insert(payment, Payment.PaymentAttribute.toJson(payment.getAttributes())) <= 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(getFullJsonResponse(payment)).build();
    }

    @PUT
    @Path("/{paymentId}")
    public Response update(@PathParam("paymentId") String id, @Valid Payment payment) {
        payment = payment.setId(id);
        String attributesJson = Payment.PaymentAttribute.toJson(payment.getAttributes());
        if (paymentDAO.update(payment, attributesJson) <= 0) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(getFullJsonResponse(payment)).build();
    }

    @DELETE
    @Path("/{paymentId}")
    public Response delete(@PathParam("paymentId") String id) {
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
        return Response.ok(getFullJsonResponse(paymentList)).build();
    }

    private String getFullJsonResponse(Payment payment) {
        return "{\"data\":["
                + Payment.toJson(payment)
                + "]," +
                "\"links\":{\"self\":\"" + getUri().toString() + "\"}}";
    }

    private String getFullJsonResponse(List<Payment> payments) {
        StringBuilder sb = new StringBuilder("{\"data\":[");

        StringJoiner joiner = new StringJoiner(",");
        for (Payment payment : payments) {
            joiner.add(Payment.toJson(payment));
        }
        sb.append(joiner.toString());

        return sb.append("],\"links\":{\"self\":\"").append(getUri().toString()).append("\"}}").toString();
    }
}
