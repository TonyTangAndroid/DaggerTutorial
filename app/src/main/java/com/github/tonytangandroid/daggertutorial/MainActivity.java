package com.github.tonytangandroid.daggertutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    @Inject
    Context injectedContext;

    @Inject
    SharedPreferences injectedSharedPreferences;

    @Named("app_name_from_named_annotation")
    @Inject
    String appName;

    @Named("shared_preference_value")
    @Inject
    String sharedPreferenceValue;

    @Inject
    String nameWithoutAnnotation;

    @Inject
    boolean debug;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TutorialApplication) getApplication()).activityInjector().inject(this);
        setContentView(R.layout.activity_main);
        TextView tvAppName = findViewById(R.id.tv_app_name);
        TextView tvSharedPreference = findViewById(R.id.tv_shared_preferences);
        TextView tvNameWithoutNamedAnnotation = findViewById(R.id.tv_name_without_annotation);
        TextView tvDebug = findViewById(R.id.tv_debug);
        tvAppName.setText(appName);
        tvSharedPreference.setText(sharedPreferenceValue);
        tvNameWithoutNamedAnnotation.setText(nameWithoutAnnotation);
        tvDebug.setText(String.valueOf(debug));

    }
}
