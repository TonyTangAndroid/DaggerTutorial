package demo.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

public class FragmentFactoryImpl extends FragmentFactory {

    private final Dep1Factory mDep1Factory;
    private final Dep2Factory mDep2Factory;

    public FragmentFactoryImpl(Dep1Factory dep1Factory,
                               Dep2Factory dep2Factory) {
        mDep1Factory = dep1Factory;
        mDep2Factory = dep2Factory;
    }


    @NonNull
    public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className, @Nullable Bundle args) {
        Class clazz = loadFragmentClass(classLoader, className);

        Fragment fragment = null;
        if (clazz == MyFragment.class) {
            fragment = new MyFragment(mDep1Factory.newInstance(), mDep2Factory.newInstance());
        } else {
            return super.instantiate(classLoader, className, args);
        }

        if (args != null) {
            fragment.setArguments(args);
        }

        return fragment;
    }
}