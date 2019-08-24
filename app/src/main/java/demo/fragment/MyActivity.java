package demo.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.tonytangandroid.daggertutorial.R;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        FragmentFactoryImpl fragmentFactory = new FragmentFactoryImpl(Dep1Factory.newInstance(), Dep2Factory.newInstance());
        getSupportFragmentManager().setFragmentFactory(fragmentFactory);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        Bundle args = new Bundle();
        args.putString(MyFragment.ARG_SOMETHING, "something");
        getSupportFragmentManager().beginTransaction().replace(
                R.id.fl_root_view,
                fragmentFactory.instantiate(getClassLoader(), MyFragment.class.getName(), args)
        ).commitNow();
    }
}
