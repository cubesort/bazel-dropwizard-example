package example.health;

import com.codahale.metrics.health.HealthCheck;

public class ServerHealthCheck extends HealthCheck {

    private final String defaultName;

    public ServerHealthCheck(String defaultName) {
        this.defaultName = defaultName;
    }

    @Override
    protected Result check() throws Exception {
        if (defaultName.isEmpty()) {
            return Result.unhealthy("Default name not set.");
        }

        return Result.healthy();
    }
}
