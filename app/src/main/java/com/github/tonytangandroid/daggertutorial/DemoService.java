package com.github.tonytangandroid.daggertutorial;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

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
        Toast.makeText(this, "service toast :" + injectedStringValue, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
