package com.github.tonytangandroid.daggertutorial;

import javax.inject.Inject;
import javax.inject.Named;

public class GetMessageUseCase {

    private final PremiumDataRepository premiumDataRepository;
    private final String messageForPremium;
    private final String messageForNonePremium;

    @Inject
    public GetMessageUseCase(PremiumDataRepository premiumDataRepository,
                             @Named("premium_message") String messageForPremium,
                             @Named("none_premium_message") String messageForNonePremium) {
        this.premiumDataRepository = premiumDataRepository;
        this.messageForPremium = messageForPremium;
        this.messageForNonePremium = messageForNonePremium;
    }

    public String retrieveMessage() {
        return premiumDataRepository.isPremiumUser() ? messageForPremium : messageForNonePremium;
    }
}
