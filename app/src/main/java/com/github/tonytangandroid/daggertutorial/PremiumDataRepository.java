package com.github.tonytangandroid.daggertutorial;

import android.content.SharedPreferences;

import javax.inject.Inject;

public class PremiumDataRepository {

    private final SharedPreferences sharedPreferences;

    @Inject
    public PremiumDataRepository(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public boolean isPremiumUser() {
        return sharedPreferences.getBoolean("pref_premium_status", true);
    }
}
