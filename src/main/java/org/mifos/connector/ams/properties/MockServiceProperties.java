package org.mifos.connector.ams.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * The paths of the bundled Fineract mock, used when {@code ams.local.enabled} is false. Same property names as before.
 */
@ConfigurationProperties(prefix = "mock-service.local")
public record MockServiceProperties(@DefaultValue Interop interop, @DefaultValue Loan loan) {

    public record Interop(String transfersPath, String partiesPath) {
    }

    public record Loan(String repaymentPath) {
    }
}
