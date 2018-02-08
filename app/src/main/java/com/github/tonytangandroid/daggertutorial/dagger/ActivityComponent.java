package com.github.tonytangandroid.daggertutorial.dagger;

import com.github.tonytangandroid.daggertutorial.MainActivity;

import dagger.Component;

@Component(dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);

}
