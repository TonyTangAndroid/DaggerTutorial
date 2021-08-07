package com.github.tonytangandroid.daggertutorial;

import dagger.assisted.Assisted;
import dagger.assisted.AssistedInject;

public class MyUserRepo {

  private final UserRepository userRepository;
  private final Config config;

  @AssistedInject
  MyUserRepo(UserRepository userRepository, @Assisted Config config) {
    this.userRepository = userRepository;
    this.config = config;
  }

  public Config getConfig() {
    return config;
  }
}
