package demo.fragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import javax.inject.Inject;
import javax.inject.Provider;

public class FragmentFactoryImpl extends FragmentFactory {

    private final Provider<TonyFragment> fragmentProvider;

    @Inject
    public FragmentFactoryImpl(Provider<TonyFragment> fragmentProvider) {
        this.fragmentProvider = fragmentProvider;
    }

    @NonNull
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
        Class<? extends Fragment> aClass = loadFragmentClass(classLoader, className);
        Fragment fragment;
        if (aClass == TonyFragment.class) {
            fragment = fragmentProvider.get();
        } else {
            return super.instantiate(classLoader, className);
        }
        return fragment;
    }
}