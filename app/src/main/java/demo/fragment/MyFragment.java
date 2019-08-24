package demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.tonytangandroid.daggertutorial.R;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import hugo.weaving.DebugLog;

@DebugLog
public class MyFragment extends Fragment {


    public static final String ARG_SOMETHING = "ARG_SOMETHING";
    private Dep1Factory newInstance;
    private Dep2Factory newInstance1;

    public MyFragment(Dep1Factory newInstance, Dep2Factory newInstance1) {

        this.newInstance = newInstance;
        this.newInstance1 = newInstance1;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_name, container, false);
        final TextView tvName = rootView.findViewById(R.id.tv_name);
        final TextView tvAge = rootView.findViewById(R.id.tv_age);
        final TextView tvArg = rootView.findViewById(R.id.tv_arg);
        tvAge.setText(age());
        tvName.setText(name());
        tvArg.setText(arg());
        return rootView;
    }

    @NotNull
    private String arg() {
        return String.valueOf(Objects.requireNonNull(getArguments()).getString(ARG_SOMETHING));
    }

    @NotNull
    private String name() {
        return String.valueOf(newInstance.getName());
    }

    @NotNull
    private String age() {
        return String.valueOf(newInstance1.getAge());
    }
}
