package com.github.tonytangandroid.daggertutorial.dagger;

import android.content.Context;

import com.github.tonytangandroid.daggertutorial.dagger.module.ApplicationModule;

import dagger.Component;

@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Context context();

}
