package org.mifos.connector.ams.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

/**
 * Everything under {@code ams.local}, except the tenant list, which keeps its own class because it is a list of beans
 * rather than a fixed set of values.
 *
 * <p>
 * The property names are exactly the ones that were on the {@code @Value} annotations before, because the operator sets
 * several of them as environment variables ({@code ams_local_enabled}, {@code ams_local_interop_host} and so on).
 * Renaming one would silently break a deployment.
 */
@ConfigurationProperties(prefix = "ams.local")
public record AmsLocalProperties(String version, @DefaultValue("true") boolean enabled, String keystorePath, String keystorePassword,
        @DefaultValue("false") boolean serverCertCheck, @DefaultValue Interop interop, @DefaultValue Customer customer,
        @DefaultValue Account account, @DefaultValue Auth auth, @DefaultValue Loan loan) {

    public record Interop(String quotesPath, String partiesPath, String transfersPath, String accountsPath) {
    }

    public record Customer(String path, String image) {
    }

    public record Account(String savingsaccountsPath, String instancesPath, String definitonsPath) {
    }

    public record Auth(String path) {
    }

    public record Loan(String repaymentPath) {
    }
}
