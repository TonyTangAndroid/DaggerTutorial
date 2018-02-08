package com.github.tonytangandroid.daggertutorial.dagger.api24;

import com.github.tonytangandroid.daggertutorial.QuickTileService;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class Api24OrGreaterServiceModule {

    @ContributesAndroidInjector()
    abstract QuickTileService bindQuickTileService();

}
