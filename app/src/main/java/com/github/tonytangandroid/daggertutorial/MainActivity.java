package com.github.tonytangandroid.daggertutorial;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Context injectedContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((TutorialApplication) getApplication()).activityInjector().inject(this);
        setContentView(R.layout.activity_main);
        TextView tvAppName = findViewById(R.id.tv_app_name);
        tvAppName.setText(injectedContext.getText(R.string.app_name));

    }
}
