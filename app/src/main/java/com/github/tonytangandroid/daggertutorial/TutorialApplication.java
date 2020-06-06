package com.github.tonytangandroid.daggertutorial;

import android.app.Application;
import com.github.tonytangandroid.daggertutorial.dagger.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import javax.inject.Inject;
import timber.log.Timber;

public class TutorialApplication extends Application implements HasAndroidInjector {

  @Inject DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

  @Override
  public void onCreate() {
    initDagger();
    super.onCreate();
    Timber.plant(new Timber.DebugTree());
  }

  @Override
  public AndroidInjector<Object> androidInjector() {
    return dispatchingAndroidInjector;
  }

  private void initDagger() {
    DaggerAppComponent.builder().application(this).build().inject(this);
  }
}
