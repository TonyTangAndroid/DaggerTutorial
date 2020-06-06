package com.github.tonytangandroid.daggertutorial;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;
import javax.inject.Named;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity implements MainView {

  @Inject Context injectedContext;

  @Inject SharedPreferences injectedSharedPreferences;

  @Named("app_name_from_named_annotation")
  @Inject
  String appName;

  @Named("shared_preference_value")
  @Inject
  String sharedPreferenceValue;

  @Inject String nameWithoutAnnotation;

  @Inject MainPresenter mainPresenter;

  @Inject MainPresenter mainPresenter2;

  @Inject boolean debug;
  private TextView tvMessage;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    TextView tvAppName = findViewById(R.id.tv_app_name);
    TextView tvSharedPreference = findViewById(R.id.tv_shared_preferences);
    TextView tvNameWithoutNamedAnnotation = findViewById(R.id.tv_name_without_annotation);
    tvMessage = findViewById(R.id.tv_message);
    TextView tvDebug = findViewById(R.id.tv_debug);
    tvAppName.setText(appName);
    tvSharedPreference.setText(sharedPreferenceValue);
    tvNameWithoutNamedAnnotation.setText(nameWithoutAnnotation);
    tvDebug.setText(String.valueOf(debug));

    mainPresenter.create();
    mainPresenter2.create();
  }

  @Override
  public void showMessage(String message) {
    tvMessage.setText(message);
  }
}
