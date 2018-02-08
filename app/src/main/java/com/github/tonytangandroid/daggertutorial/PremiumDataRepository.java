package com.github.tonytangandroid.daggertutorial;

import android.content.SharedPreferences;

import javax.inject.Inject;

import hugo.weaving.DebugLog;

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
