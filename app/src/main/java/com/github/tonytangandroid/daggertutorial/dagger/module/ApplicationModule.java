package com.github.tonytangandroid.daggertutorial.dagger.module;

import android.app.Application;
import android.content.Context;

import com.github.tonytangandroid.daggertutorial.TutorialApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final Application application;

    public ApplicationModule(TutorialApplication application) {
        this.application = application;
    }

    @Provides
    Context provideContext() {
        return application.getApplicationContext();
    }

}
