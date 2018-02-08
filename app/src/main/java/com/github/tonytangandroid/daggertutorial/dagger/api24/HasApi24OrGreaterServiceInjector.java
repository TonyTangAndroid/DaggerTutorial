package com.github.tonytangandroid.daggertutorial.dagger.api24;

import android.app.Service;

import dagger.android.AndroidInjector;

public interface HasApi24OrGreaterServiceInjector {

  AndroidInjector<Service> api24OrGreaterServiceInjector();
}
