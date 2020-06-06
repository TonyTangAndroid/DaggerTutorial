package com.github.tonytangandroid.daggertutorial;

import hugo.weaving.DebugLog;
import javax.inject.Inject;

public class UserDataRepository implements UserRepository {

  @DebugLog
  @Inject
  public UserDataRepository() {}

  @Override
  public String getUserName() {
    return "TonyTang";
  }
}
