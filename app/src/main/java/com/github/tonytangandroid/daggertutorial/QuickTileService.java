package com.github.tonytangandroid.daggertutorial;

import android.os.Build;
import android.service.quicksettings.TileService;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import timber.log.Timber;

/**
 * Created by ztang on 2/8/18.
 */
@RequiresApi(api = Build.VERSION_CODES.N)
public class QuickTileService extends TileService {

    @Inject
    String injectedString;

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidInjection.inject(this);
    }

    @Override
    public void onTileAdded() {
        Timber.d("Tile added");
    }

    @Override
    public void onStartListening() {
        Timber.d("Start listening");
    }

    @Override
    public void onClick() {
        Toast.makeText(this, "toast from tile :" + injectedString, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onStopListening() {
        Timber.d("Stop Listening");
    }

    @Override
    public void onTileRemoved() {
        Timber.d("Tile removed");
    }

}
