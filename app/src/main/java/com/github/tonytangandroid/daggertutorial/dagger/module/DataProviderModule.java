package com.github.tonytangandroid.daggertutorial.dagger.module;

import com.github.tonytangandroid.daggertutorial.UserDataRepository;
import com.github.tonytangandroid.daggertutorial.UserRepository;
import dagger.Module;
import dagger.Provides;

@Module
public class DataProviderModule {

  @Provides
  UserRepository provideUserRepositoryInterface() {
    return new UserDataRepository();
  }
}
