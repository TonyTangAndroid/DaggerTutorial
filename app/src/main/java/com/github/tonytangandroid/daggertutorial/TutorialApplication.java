package com.github.tonytangandroid.daggertutorial;

import android.app.Activity;
import android.app.Application;
import android.app.Service;

import com.github.tonytangandroid.daggertutorial.dagger.ApplicationComponent;
import com.github.tonytangandroid.daggertutorial.dagger.DaggerApplicationComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.HasServiceInjector;
import timber.log.Timber;

import static android.os.Build.VERSION.SDK_INT;
import static android.os.Build.VERSION_CODES.N;

public class TutorialApplication extends Application implements HasActivityInjector, HasServiceInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    @Inject
    DispatchingAndroidInjector<Service> serviceDispatchingAndroidInjector;


    @Override
    public void onCreate() {
        initDagger();
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

    }

    private void initDagger() {
        ApplicationComponent component = DaggerApplicationComponent.builder().application(this).build();
        if (SDK_INT >= N) {
            component.api24OrGreaterServiceComponent().inject(this);
        } else {
            component.inject(this);
        }
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }

    @Override
    public AndroidInjector<Service> serviceInjector() {
        return serviceDispatchingAndroidInjector;
    }

}
