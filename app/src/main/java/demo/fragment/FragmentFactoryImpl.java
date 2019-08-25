package demo.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;

public class FragmentFactoryImpl extends FragmentFactory {

    private Map<Class<? extends Fragment>, Provider<Fragment>> map;

    @Inject
    public FragmentFactoryImpl(Map<Class<? extends Fragment>, Provider<Fragment>> map) {
        this.map = map;
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Class<? extends Fragment> aClass = loadFragmentClass(classLoader, className);
        Provider<Fragment> fragmentProvider = map.get(aClass);
        if (fragmentProvider != null) {
            return fragmentProvider.get();
        } else {
            return super.instantiate(classLoader, className);
        }
    }
}