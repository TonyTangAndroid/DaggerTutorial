package com.github.tonytangandroid.daggertutorial;

import javax.inject.Inject;
import javax.inject.Named;

public class GetMessageUseCase {

  private final UserRepository userRepository;
  private final PremiumRepository premiumRepository;
  private final String messageForPremium;
  private final String messageForNonePremium;

  @Inject
  public GetMessageUseCase(
      UserRepository userRepository,
      PremiumRepository premiumRepository,
      @Named("premium_message") String messageForPremium,
      @Named("none_premium_message") String messageForNonePremium) {
    this.userRepository = userRepository;
    this.premiumRepository = premiumRepository;
    this.messageForPremium = messageForPremium;
    this.messageForNonePremium = messageForNonePremium;
  }

  public String retrieveMessage() {
    return "Hello "
        + userRepository.getUserName()
        + ","
        + (premiumRepository.isPremiumUser() ? messageForPremium : messageForNonePremium);
  }
}
