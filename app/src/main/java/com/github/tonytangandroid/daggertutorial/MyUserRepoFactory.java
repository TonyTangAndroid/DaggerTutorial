package com.github.tonytangandroid.daggertutorial;

import dagger.assisted.AssistedFactory;

@AssistedFactory
public interface MyUserRepoFactory {

  MyUserRepo create(Config config);
}
