package com.exercise.form3.core;

import com.exercise.form3.api.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentRepository {

    List<Payment> findAll();

    Optional<Payment> findById(Long id);

    Payment save(Payment payment);

    Optional<Payment> update(Long id, Payment payment);

    void delete(Long id);

}
