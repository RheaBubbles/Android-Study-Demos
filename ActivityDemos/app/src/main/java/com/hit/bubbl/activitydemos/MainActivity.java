package com.hit.bubbl.activitydemos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

/**
 * @author Bubbles 
 * @create 2018/7/9
 * @Type Activity
 * @LayoutFile activity_demos_recycler_view
 * @Describe Demo的列表Activity，用一个RecyclerView来显示所有的Demo入口。
 */

public class MainActivity extends AppCompatActivity {

    private String[] demoNames;
    private static final int DATASET_COUNT = 10;

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDemoNames();

        mRecyclerView = (RecyclerView) findViewById(R.id.activity_demos_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(demoNames);

        // set the adapter to RecyclerView
        mRecyclerView.setAdapter(mAdapter);

        TextView floatClassName = (TextView) findViewById(R.id.float_class_name);
        floatClassName.setText("Activity Name: MainActivity");
    }

    private void initDemoNames() {
        demoNames = new String[DATASET_COUNT];
        for (int i = 0; i < DATASET_COUNT; i++) {
            demoNames[i] = "Activity Demo " + (i+1);
        }
    }
}
