package demo.fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Map;

import javax.inject.Provider;

import dagger.Binds;
import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

@Module
public abstract class FragmentFactoryModule {

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @MapKey
    @interface FragmentKey {
        Class<? extends Fragment> value();
    }

    @Provides
    static FragmentFactory FragmentFactory(Map<Class<? extends Fragment>, Provider<Fragment>> providerMap) {
        return new FragmentFactoryImpl(providerMap);
    }

    @Binds
    @IntoMap
    @FragmentKey(TonyFragment.class)
    abstract Fragment tonyFragment(TonyFragment tonyFragment);

    @Binds
    @IntoMap
    @FragmentKey(EmptyFragment.class)
    abstract Fragment emptyFragment(EmptyFragment tonyFragment);

}