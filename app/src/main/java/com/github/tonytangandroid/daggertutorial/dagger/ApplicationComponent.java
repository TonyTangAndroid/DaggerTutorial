package com.github.tonytangandroid.daggertutorial.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.tonytangandroid.daggertutorial.dagger.module.ApplicationModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.SharedPreferenceModule;

import dagger.Component;

@Component(modules = {ApplicationModule.class, SharedPreferenceModule.class})
public interface ApplicationComponent {

    Context context();

    SharedPreferences sharedPreferences();

}
