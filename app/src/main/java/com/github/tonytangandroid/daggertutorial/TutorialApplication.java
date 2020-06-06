package com.github.tonytangandroid.daggertutorial;

import android.app.Application;
import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

@HiltAndroidApp
public class TutorialApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());
  }
}
