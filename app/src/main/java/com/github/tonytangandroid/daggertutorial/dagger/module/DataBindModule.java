package com.github.tonytangandroid.daggertutorial.dagger.module;

import com.github.tonytangandroid.daggertutorial.PremiumDataRepository;
import com.github.tonytangandroid.daggertutorial.PremiumRepository;
import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public abstract class DataBindModule {

  @Binds
  abstract PremiumRepository providePremiumRepository(PremiumDataRepository premiumDataRepository);
}
