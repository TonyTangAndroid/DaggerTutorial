package demo.fragment;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;

import com.github.tonytangandroid.daggertutorial.R;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class TonyActivity extends AppCompatActivity implements TonyActivityView {

    @Inject
    TonyActivityPresenter tonyActivityPresenter;

    @Inject
    FragmentFactory fragmentFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        getSupportFragmentManager().setFragmentFactory(fragmentFactory);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_holder);
        ClassLoader classLoader = getClassLoader();
        Fragment fragment = fragmentFactory.instantiate(classLoader, TonyFragment.class.getName());
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_root_view, fragment).commitNow();
        tonyActivityPresenter.create();

    }

    @Override
    public void showActivityMessage(String message) {
        Toast.makeText(this, "showed message in activity", Toast.LENGTH_SHORT).show();
    }


    public String param() {
        return "message param";
    }
}
