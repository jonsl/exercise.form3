package com.exercise.form3;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
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
//        final Jdbi jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
//        environment.jersey().register(new UserResource(jdbi));
    }
}
