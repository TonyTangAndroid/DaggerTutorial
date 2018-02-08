package com.github.tonytangandroid.daggertutorial.dagger;

import com.github.tonytangandroid.daggertutorial.DemoService;
import com.github.tonytangandroid.daggertutorial.QuickTileService;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ServiceInjector {

    @ContributesAndroidInjector()
    abstract DemoService bindDemoService();

    @ContributesAndroidInjector()
    abstract QuickTileService bindQuickTileService();

}
