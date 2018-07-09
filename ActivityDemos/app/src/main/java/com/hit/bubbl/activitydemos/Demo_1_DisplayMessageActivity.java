package com.hit.bubbl.activitydemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Bubbles
 * @create 2018/7/9
 * @Type Activity
 * @LayoutFile activity_demo_1_display_message
 * @Describe Demo 1 第一个Activity点击Send按钮后, 此Activity展示Intent传输的Message。
 * @ReferDoc https://developer.android.com/training/basics/firstapp/starting-activity
 */

public class Demo_1_DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_1_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(Demo_1.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        TextView floatClassName = (TextView) findViewById(R.id.float_class_name);
        floatClassName.setText("Activity Name: Demo_1_DisplayMessageActivity");
    }
}
