package com.github.tonytangandroid.daggertutorial.dagger;

import com.github.tonytangandroid.daggertutorial.MainActivity;
import com.github.tonytangandroid.daggertutorial.MainView;

import dagger.Binds;
import dagger.Module;

/**
 * Created by ztang on 2/8/18.
 */

@Module
abstract class MainActivityModule {

    @Binds
    abstract MainView provideMainView(MainActivity mainActivity);
}
