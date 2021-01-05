package no.kristianped.sfgdi.config;

import no.kristianped.sfgdi.services.GreetingRepository;
import no.kristianped.sfgdi.services.GreetingService;
import no.kristianped.sfgdi.services.GreetingServiceFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Configuration
public class GreetingServiceConfig {

    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository) {
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean("i18nService")
    @Primary
    @Profile({"default", "en"})
    GreetingService primaryEnglishGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean("i18nService")
    @Primary
    @Profile({"default", "es"})
    @Qualifier("i18nService")
    GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("es");
    }

    @Bean("i18nService")
    @Primary
    @Profile({"default", "de"})
    @Qualifier("i18nService")
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory) {
        return greetingServiceFactory.createGreetingService("de");
    }
}
