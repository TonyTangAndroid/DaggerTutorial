package com.github.tonytangandroid.daggertutorial.dagger.module;

import com.github.tonytangandroid.daggertutorial.PremiumDataRepository;
import com.github.tonytangandroid.daggertutorial.PremiumRepository;
import com.github.tonytangandroid.daggertutorial.dagger.scope.ApplicationScope;
import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataBindModule {

  @ApplicationScope
  @Binds
  abstract PremiumRepository providePremiumRepository(PremiumDataRepository premiumDataRepository);
}
