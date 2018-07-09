package com.hit.bubbl.activitydemos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Bubbles
 * @create 2018/7/9
 * @Type Activity
 * @LayoutFile activity_demo_1
 * @Describe Demo 1, 展示单一activity中组件的交互
 * @ReferDoc https://developer.android.com/training/basics/firstapp/building-ui
 */

public class Demo_1 extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.hit.bubbl.activitydemos.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo_1);

        TextView floatClassName = (TextView) findViewById(R.id.float_class_name);
        floatClassName.setText("Activity Name: Demo_1");
    }

    /**
     * Need to set the button 'OnClick' Attribute to 'sendMessage'
     * And the function should be 1.public 2.void return 3.Only param View
     * to fit the Attribute type.
     * It'll be Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        // Intent(Context context, Class class)
        // 这里第一个参数使用this是因为Activity类是Context的子类
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        if(message.length() != 0) {
            Intent intent = new Intent(this, Demo_1_DisplayMessageActivity.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
        } else {
            Toast.makeText(view.getContext(), "No words here!ヽ(`Д´)ノ", Toast.LENGTH_SHORT).show();
        }
    }
}
