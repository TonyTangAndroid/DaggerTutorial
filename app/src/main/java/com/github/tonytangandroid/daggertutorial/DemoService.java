package com.github.tonytangandroid.daggertutorial;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class DemoService extends Service {


    @Inject
    String injectedStringValue;

    public static Intent constructIntent(Context context) {
        return new Intent(context, DemoService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidInjection.inject(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
