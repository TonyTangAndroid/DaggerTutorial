package demo.fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Created by ztang on 2/8/18.
 */

@Module
abstract class TonyActivityModule {

    @Binds
    abstract TonyActivityView provideTonyView(TonyActivity myActivity);

    @Named("dynamic_param")
    @Provides
    static String dynamicParam(TonyActivity myActivity) {
        return myActivity.param();
    }

}
