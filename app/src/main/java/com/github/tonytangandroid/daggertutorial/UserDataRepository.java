package com.github.tonytangandroid.daggertutorial;

import javax.inject.Inject;

import hugo.weaving.DebugLog;

public class UserDataRepository implements UserRepository {

    @DebugLog
    @Inject
    public UserDataRepository() {

    }

    @Override
    public String getUserName() {
        return "TonyTang";
    }
}
