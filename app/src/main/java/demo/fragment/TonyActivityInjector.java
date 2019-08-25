package demo.fragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class TonyActivityInjector {

    @ContributesAndroidInjector(modules = {TonyActivityModule.class,
            FragmentFactoryModule.class})
    abstract TonyActivity bindTonyActivity();


}
