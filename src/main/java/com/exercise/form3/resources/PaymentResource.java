package com.exercise.form3.resources;

import com.exercise.form3.api.Payment;
import com.exercise.form3.dao.PaymentDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/payments")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PaymentResource {

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
        paymentDAO.insert(payment);

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
