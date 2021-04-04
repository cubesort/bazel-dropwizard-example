package example;

import example.health.ServerHealthCheck;
import example.resources.HelloResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<AppConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "Example app";
    }

    @Override
    public void initialize(Bootstrap<AppConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(AppConfiguration configuration, Environment environment) {
        final ServerHealthCheck serverHealthCheck = new ServerHealthCheck(configuration.getDefaultName());
        final HelloResource resource = new HelloResource(configuration.getDefaultName());

        environment.healthChecks().register("server", serverHealthCheck);
        environment.jersey().register(resource);
    }

}
