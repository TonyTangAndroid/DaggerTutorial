package com.github.tonytangandroid.daggertutorial;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.N;

import android.app.Application;
import com.github.tonytangandroid.daggertutorial.dagger.AppComponent;
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
    AppComponent component = DaggerAppComponent.builder().application(this).build();
    if (SDK_INT >= N) {
      component.api24OrGreaterServiceComponent().inject(this);
    } else {
      component.inject(this);
    }
  }
}
