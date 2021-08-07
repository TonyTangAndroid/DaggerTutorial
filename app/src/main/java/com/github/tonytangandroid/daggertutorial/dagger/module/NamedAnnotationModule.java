package com.github.tonytangandroid.daggertutorial.dagger.module;

import com.github.tonytangandroid.daggertutorial.BuildConfig;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class NamedAnnotationModule {

  @Provides
  @Named("app_name_from_named_annotation")
  String provideAppName() {
    return "This is a value from named annotation";
  }

  @Provides
  String provideValueWithoutAnnotationAppName() {
    return "This is a value without named annotation";
  }

  @Provides
  boolean debug() {
    return BuildConfig.DEBUG;
  }

  @Named("premium_message")
  @Provides
  String messageForPremium() {
    return "You are a premium user";
  }

  @Named("none_premium_message")
  @Provides
  String messageForNonPremium() {
    return "You are not a premium user";
  }

  @Provides
  @Named("shared_preference_value")
  String provideSharedPreferenceValue() {
    return "This is a shared preference value";
  }
}
