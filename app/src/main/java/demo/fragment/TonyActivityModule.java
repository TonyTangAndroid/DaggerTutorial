package demo.fragment;

import dagger.Binds;
import dagger.Module;

/**
 * Created by ztang on 2/8/18.
 */

@Module
abstract class TonyActivityModule {

    @Binds
    abstract TonyActivityView provideTonyView(TonyActivity myActivity);
}
