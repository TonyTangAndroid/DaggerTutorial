package demo.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.tonytangandroid.daggertutorial.R;

import javax.inject.Inject;
import javax.inject.Named;

public class TonyFragment extends Fragment implements TonyFragmentView {

    private final Context injectedContext;

    private final SharedPreferences injectedSharedPreferences;

    private final String appName;

    private final String sharedPreferenceValue;

    private final String nameWithoutAnnotation;

    private final TonyFragmentPresenter tonyFragmentPresenter;

    private final boolean debug;
    private final Dep1Factory dep1Factory;
    private final Dep2Factory dep2Factory;

    private TextView tvMessage;

    @Inject
    public TonyFragment(Context injectedContext,
                        SharedPreferences injectedSharedPreferences,
                        @Named("app_name_from_named_annotation") String appName,
                        @Named("shared_preference_value") String sharedPreferenceValue,
                        String nameWithoutAnnotation,
                        TonyFragmentPresenter tonyFragmentPresenter,
                        boolean debug,
                        Dep1Factory dep1Factory,
                        Dep2Factory dep2Factory) {
        this.injectedContext = injectedContext;
        this.injectedSharedPreferences = injectedSharedPreferences;
        this.appName = appName;
        this.sharedPreferenceValue = sharedPreferenceValue;
        this.nameWithoutAnnotation = nameWithoutAnnotation;
        this.tonyFragmentPresenter = tonyFragmentPresenter;
        this.debug = debug;
        this.dep1Factory = dep1Factory;
        this.dep2Factory = dep2Factory;
        tonyFragmentPresenter.setTonyFragmentView(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_name, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView tv_age = view.findViewById(R.id.tv_age);
        tv_age.setText(String.valueOf(dep2Factory.getAge()));
        TextView tv_name = view.findViewById(R.id.tv_name);
        tv_name.setText(dep1Factory.getName());

        TextView tvAppName = view.findViewById(R.id.tv_app_name);
        TextView tvSharedPreference = view.findViewById(R.id.tv_shared_preferences);
        TextView tvNameWithoutNamedAnnotation = view.findViewById(R.id.tv_name_without_annotation);
        tvMessage = view.findViewById(R.id.tv_message);
        TextView tvDebug = view.findViewById(R.id.tv_debug);
        tvAppName.setText(appName);
        tvSharedPreference.setText(sharedPreferenceValue);
        tvNameWithoutNamedAnnotation.setText(nameWithoutAnnotation);
        tvDebug.setText(String.valueOf(debug));
        tonyFragmentPresenter.create();
    }


    @Override
    public void showFragmentMessage(String message) {
        tvMessage.setText("fragment: " + message);
    }
}
