package com.github.tonytangandroid.daggertutorial.dagger;

import com.github.tonytangandroid.daggertutorial.DemoService;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ServiceInjector {

    @ContributesAndroidInjector()
    abstract DemoService bindDemoService();


}
