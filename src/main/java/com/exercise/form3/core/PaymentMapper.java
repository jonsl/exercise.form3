package com.exercise.form3.core;

import com.exercise.form3.api.Payment;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaymentMapper implements RowMapper<Payment> {
    public Payment map(ResultSet resultSet, StatementContext statementContext) throws SQLException {
        return new Payment(
                resultSet.getString("type"),
                resultSet.getString("id"),
                resultSet.getInt("version"),
                resultSet.getString("organisation_id"),
                Payment.PaymentAttribute.fromJson(resultSet.getString("attributes")));
    }
}
