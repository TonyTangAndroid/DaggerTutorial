package com.github.tonytangandroid.daggertutorial.dagger;

import android.app.Activity;
import com.github.tonytangandroid.daggertutorial.MainActivity;
import com.github.tonytangandroid.daggertutorial.MainView;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/** Created by ztang on 2/8/18. */
@Module
@InstallIn(ActivityComponent.class)
abstract class MainActivityModule {

  @Provides
  static MainView provideMainView(Activity activity) {
    return ((MainActivity) activity);
  }
}
