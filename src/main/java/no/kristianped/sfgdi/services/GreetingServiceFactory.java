package no.kristianped.sfgdi.services;

public class GreetingServiceFactory {

    private final GreetingRepository greetingRepository;

    public GreetingServiceFactory(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    public GreetingService createGreetingService(String lang) {
        switch (lang) {
            case "en":
                return new I18nEnglishGreetingService(greetingRepository);
            case "de":
                return new I18nGermanGreetingService(greetingRepository);
            case "es":
                return new I18nSpanishService(greetingRepository);
            default:
                return new I18nEnglishGreetingService(greetingRepository);
        }
    }
}
