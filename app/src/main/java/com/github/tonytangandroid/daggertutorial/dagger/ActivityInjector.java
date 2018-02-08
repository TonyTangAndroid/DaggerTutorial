package com.github.tonytangandroid.daggertutorial.dagger;

import com.github.tonytangandroid.daggertutorial.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityInjector {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();


}
