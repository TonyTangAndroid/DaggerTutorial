package com.github.tonytangandroid.daggertutorial.dagger.module;

import android.app.Application;
import android.content.Context;
import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

  @Provides
  Context provideContext(Application application) {
    return application.getApplicationContext();
  }
}
