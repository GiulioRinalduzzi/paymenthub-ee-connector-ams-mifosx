package org.mifos.connector.ams.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * The Zeebe gateway address and client tuning.
 *
 * <p>
 * {@code zeebe.client.evenly-allocated-max-jobs} is deliberately not here: its value can be a SpEL expression
 * ({@code #{...}}, see the commented-out block in application.yml) and only {@code @Value} evaluates those.
 */
@ConfigurationProperties(prefix = "zeebe")
public record ZeebeProperties(@DefaultValue("true") boolean enabled, @DefaultValue Broker broker, @DefaultValue Client client) {

    public record Broker(String contactpoint) {
    }

    public record Client(@DefaultValue("50") int maxExecutionThreads, @DefaultValue("10") int pollInterval) {
    }
}
