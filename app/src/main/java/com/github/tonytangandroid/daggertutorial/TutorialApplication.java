package com.github.tonytangandroid.daggertutorial;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.github.tonytangandroid.daggertutorial.dagger.ApplicationComponent;
import com.github.tonytangandroid.daggertutorial.dagger.DaggerApplicationComponent;
import com.github.tonytangandroid.daggertutorial.dagger.api24.HasApi24OrGreaterServiceInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import timber.log.Timber;

public class TutorialApplication extends Application implements HasActivityInjector, HasServiceInjector, HasApi24OrGreaterServiceInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder().application(this).build();
        applicationComponent.inject(this);
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> api24OrGreaterServiceInjector() {
        return applicationComponent.api24OrGreaterServiceComponent().injector();
    }
}
