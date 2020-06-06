package com.github.tonytangandroid.daggertutorial.dagger.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
public class ApplicationModule {

  @Provides
  Context provideContext(Application application) {
    return application.getApplicationContext();
  }
}
