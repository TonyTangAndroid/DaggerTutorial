package com.github.tonytangandroid.daggertutorial.dagger;

import android.content.Context;
import android.content.SharedPreferences;

import com.github.tonytangandroid.daggertutorial.dagger.module.ApplicationModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.NamedAnnotationModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.SharedPreferenceModule;

import javax.inject.Named;

import dagger.Component;

@Component(modules = {ApplicationModule.class, SharedPreferenceModule.class, NamedAnnotationModule.class})
public interface ApplicationComponent {

    Context context();

    SharedPreferences sharedPreferences();

    @Named("app_name_from_named_annotation")
    String appName();

    @Named("shared_preference_value")
    String defaultSharedPreferenceValue();

    String nameWithoutNamedAnnotation();

    boolean debug();

}
