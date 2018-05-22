package com.exercise.form3;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PaymentsApplication extends Application<PaymentsConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PaymentsApplication().run(args);
    }

    @Override
    public String getName() {
        return "Events";
    }

    @Override
    public void initialize(final Bootstrap<PaymentsConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PaymentsConfiguration configuration,
                    final Environment environment) {
    }
}
