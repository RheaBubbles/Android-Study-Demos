package com.hit.bubbl.activitydemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Demo_2_Launched extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_2_launched);

        String intentType = getIntent().getStringExtra(Intent.EXTRA_TEXT);
        textView = findViewById(R.id.show_parent_activity);
        textView.setText("Launch by the " + intentType + " Intent.");

        TextView floatClassName = (TextView) findViewById(R.id.float_class_name);
        floatClassName.setText("Activity Name: Demo_2_Launched");
    }
}
