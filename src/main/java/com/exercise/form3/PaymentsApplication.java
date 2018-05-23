package com.exercise.form3;

import com.exercise.form3.dao.PaymentDAO;
import com.exercise.form3.resources.PaymentResource;
import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;

public class PaymentsApplication extends Application<PaymentsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PaymentsApplication().run(args);
    }

    @Override
    public String getName() {
        return "Payments";
    }

    @Override
    public void initialize(final Bootstrap<PaymentsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PaymentsConfiguration configuration,
                    final Environment environment) {

        final JdbiFactory factory = new JdbiFactory();

        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "jdbc:sqlite:database");

        final PaymentDAO paymentDAO = jdbi.onDemand(PaymentDAO.class);
        final PaymentResource paymentResource = new PaymentResource(paymentDAO);

        environment.jersey().register(paymentResource);

        try (Handle h = jdbi.open()) {

            h.execute("create table if not exists PAYMENT (id_ INTEGER PRIMARY KEY AUTOINCREMENT, type varchar(100), id varchar(100), version int, organisation_id varchar(100))");

        }
    }
}
