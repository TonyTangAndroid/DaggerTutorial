package com.github.tonytangandroid.daggertutorial;

import android.content.SharedPreferences;
import hugo.weaving.DebugLog;
import javax.inject.Inject;

public class PremiumDataRepository implements PremiumRepository {

  private final SharedPreferences sharedPreferences;

  @DebugLog
  @Inject
  public PremiumDataRepository(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
  }

  public boolean isPremiumUser() {
    return sharedPreferences.getBoolean("pref_premium_status", true);
  }
}
