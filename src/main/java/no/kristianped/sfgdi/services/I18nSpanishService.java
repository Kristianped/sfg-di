package no.kristianped.sfgdi.services;

public class I18nSpanishService implements GreetingService {

    private final GreetingRepository greetingRepository;

    public I18nSpanishService(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public String sayGreeting() {
        return greetingRepository.getSpanishGreeting();
    }
}
