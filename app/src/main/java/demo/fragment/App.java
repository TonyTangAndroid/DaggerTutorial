package demo.fragment;

import android.app.Application;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import timber.log.Timber;

public class App extends Application implements HasAndroidInjector {

    @Inject
    DispatchingAndroidInjector<Object> dispatchingAndroidInjector;

    @Override
    public void onCreate() {
        initDagger();
        super.onCreate();
        Timber.plant(new Timber.DebugTree());

    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return dispatchingAndroidInjector;
    }

    private void initDagger() {
        AppComponent component = DaggerAppComponent.builder().application(this).build();
        component.inject(this);

    }
}
