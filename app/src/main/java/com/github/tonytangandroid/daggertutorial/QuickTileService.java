package com.github.tonytangandroid.daggertutorial;

import android.app.Service;
import android.os.Build;
import android.service.quicksettings.TileService;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjection;
import dagger.android.ContributesAndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Inject;
import timber.log.Timber;

/** Created by ztang on 2/8/18. */
@RequiresApi(api = Build.VERSION_CODES.N)
public class QuickTileService extends TileService {

  @Inject String injectedString;

  @Override
  public void onCreate() {
    AndroidInjection.inject(this);
    super.onCreate();
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

  @Subcomponent(modules = Api24OrGreaterServiceModule.class)
  public interface Api24OrGreaterServiceComponent {

    void inject(TutorialApplication app);

    DispatchingAndroidInjector<Service> injector();
  }

  @Module
  public abstract class Api24OrGreaterServiceModule {

    @ContributesAndroidInjector()
    abstract QuickTileService bindQuickTileService();
  }
}
