package com.github.tonytangandroid.daggertutorial.dagger;

import android.app.Application;
import com.github.tonytangandroid.daggertutorial.QuickTileService;
import com.github.tonytangandroid.daggertutorial.TutorialApplication;
import com.github.tonytangandroid.daggertutorial.dagger.module.ApplicationModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.DataBindModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.DataProviderModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.NamedAnnotationModule;
import com.github.tonytangandroid.daggertutorial.dagger.module.SharedPreferenceModule;
import com.github.tonytangandroid.daggertutorial.dagger.scope.ApplicationScope;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@ApplicationScope
@Component(
    modules = {
      ApplicationModule.class,
      SharedPreferenceModule.class,
      NamedAnnotationModule.class,
      DataProviderModule.class,
      DataBindModule.class,
      AndroidInjectionModule.class,
      ActivityInjector.class,
      ServiceInjector.class
    })
public interface ApplicationComponent {

  QuickTileService.Api24OrGreaterServiceComponent api24OrGreaterServiceComponent();

  void inject(TutorialApplication app);

  @Component.Builder
  interface Builder {

    @BindsInstance
    Builder application(Application application);

    ApplicationComponent build();
  }
}
