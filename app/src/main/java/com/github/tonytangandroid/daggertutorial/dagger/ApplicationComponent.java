package com.github.tonytangandroid.daggertutorial.dagger;

import android.app.Application;

import com.github.tonytangandroid.daggertutorial.TutorialApplication;
import com.github.tonytangandroid.daggertutorial.dagger.module.ApplicationModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.NamedAnnotationModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.SharedPreferenceModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {ApplicationModule.class, SharedPreferenceModule.class, NamedAnnotationModule.class,
        AndroidInjectionModule.class, ActivityInjector.class})
public interface ApplicationComponent {

    void inject(TutorialApplication app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }
}
