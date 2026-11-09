package it.nexoapp.eml.config;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

/**
 * Email microservice settings, mapped from configuration properties with the {@code eml} prefix.
 * <p>
 * Every property is optional and falls back to a default when not set.
 */
@StaticInitSafe
@ConfigMapping(prefix = "eml")
public interface EmailConfig {

    /**
     * Messaging settings (properties with the {@code eml.messaging} prefix).
     */
    Messaging messaging();

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Settings of the event messaging, mapped from the {@code eml.messaging} prefix.
     */
    interface Messaging {

        /**
         * Name of the topic exchange the outbox relay publishes this service's events on
         * (property {@code eml.messaging.exchange}). Optional, defaults to {@code nexo.eml}.
         */
        @WithDefault("nexo.eml")
        String exchange();

    }

}
