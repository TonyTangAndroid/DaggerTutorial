package com.github.tonytangandroid.daggertutorial.dagger.module;

import com.github.tonytangandroid.daggertutorial.UserDataRepository;
import com.github.tonytangandroid.daggertutorial.UserRepository;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class DataProviderModule {

  @Provides
  UserRepository provideUserRepositoryInterface() {
    return new UserDataRepository();
  }
}
