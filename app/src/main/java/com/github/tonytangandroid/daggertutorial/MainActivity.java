package com.github.tonytangandroid.daggertutorial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvAppName = findViewById(R.id.tv_app_name);
        tvAppName.setText(getApplicationContext().getText(R.string.app_name));

    }
}
