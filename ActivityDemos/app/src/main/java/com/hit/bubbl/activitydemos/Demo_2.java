package com.hit.bubbl.activitydemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author Bubbles
 * @create 2018/7/11
 * @Type Activity
 * @LayoutFile activity_demos_2
 * @Describe Demo 2，几种常用的不同的启动Activity的方式，
 */

public class Demo_2 extends AppCompatActivity {

    // 自定义隐式Intent ACTION 类型字段
    // 只有设置对对应ACTION <intent-filter> 标签的Activity能够被启动
    static final String ACTION_IMPLICITLY = "com.hit.bubbl.IMPLICITLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_2);

        TextView floatClassName = (TextView) findViewById(R.id.float_class_name);
        floatClassName.setText("Activity Name: Demo_2");
    }

    public void launchWithExplicitIntent(View view) {
        Intent intent = new Intent(this, Demo_2_Launched.class);
        intent.putExtra(Intent.EXTRA_TEXT, "Explicit");
        intent.setType("text/plain");
        startActivity(intent);
    }

    public void launchWithImplicitIntent(View view) {
        Intent intent = new Intent();
        intent.setAction(ACTION_IMPLICITLY);
        intent.putExtra(Intent.EXTRA_TEXT, "Implicit");
        intent.setType("text/plain");

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
