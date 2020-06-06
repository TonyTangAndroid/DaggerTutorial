package com.github.tonytangandroid.daggertutorial.dagger.scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import javax.inject.Scope;

@Scope
@Retention(RUNTIME)
public @interface ApplicationScope {}
