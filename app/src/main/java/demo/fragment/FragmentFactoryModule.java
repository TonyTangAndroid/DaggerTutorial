package demo.fragment;

import androidx.fragment.app.FragmentFactory;

import dagger.Binds;
import dagger.Module;

/**
 * Created by ztang on 2/8/18.
 */

@Module
abstract class FragmentFactoryModule {

    @Binds
    abstract FragmentFactory fragmentFactory(FragmentFactoryImpl fragmentFactory);
}
