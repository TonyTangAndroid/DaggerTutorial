package com.github.tonytangandroid.daggertutorial.dagger;

import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

/** Created by ztang on 2/8/18. */
@Module
@InstallIn(ActivityComponent.class)
abstract class MainActivityModule {}
