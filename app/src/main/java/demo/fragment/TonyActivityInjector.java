package demo.fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import demo.fragment.TonyActivityInjector.YourActivitySubcomponent.Factory;

@Module(subcomponents = TonyActivityInjector.YourActivitySubcomponent.class)
abstract class TonyActivityInjector {
    @Binds
    @IntoMap
    @ClassKey(TonyActivity.class)
    abstract AndroidInjector.Factory<?> bindYourAndroidInjectorFactory(Factory factory);

    @Subcomponent(modules = {
            TonyActivityModule.class,
            FragmentFactoryModule.class
    })
    public interface YourActivitySubcomponent extends AndroidInjector<TonyActivity> {

        @Subcomponent.Factory
        interface Factory extends AndroidInjector.Factory<TonyActivity> {


        }
    }
}