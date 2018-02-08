package com.github.tonytangandroid.daggertutorial;

import android.app.Application;

import com.github.tonytangandroid.daggertutorial.dagger.ActivityComponent;
import com.github.tonytangandroid.daggertutorial.dagger.ApplicationComponent;
import com.github.tonytangandroid.daggertutorial.dagger.DaggerActivityComponent;
import com.github.tonytangandroid.daggertutorial.dagger.DaggerApplicationComponent;
import com.github.tonytangandroid.daggertutorial.dagger.module.ApplicationModule;

public class TutorialApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ActivityComponent activityInjector() {
        return DaggerActivityComponent.builder().applicationComponent(applicationComponent).build();
    }
}
