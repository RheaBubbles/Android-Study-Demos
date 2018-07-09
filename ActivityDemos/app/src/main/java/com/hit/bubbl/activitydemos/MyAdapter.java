package com.hit.bubbl.activitydemos;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
//import android.widget.TextView;

/**
 * @author Bubbles 
 * @create 2018/7/9
 * @Type 自定义RecyclerView.Adapter
 * @LayoutFile text_button_item
 * @Describe 自定义RecyclerItem的组件初始化和监听器打开对应Demo.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private String[] mDataset;
    private static final String TAG = "MyAdapter";
    private MyAdapter that;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public Button mButton;
        public int activityId;

        public ViewHolder(View v) {
            super(v);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String demoClass = "Demo_" + (getAdapterPosition() + 1);
                    Context context = v.getContext();
                    Intent openDemoIntent = new Intent();
                    openDemoIntent.setClassName("com.hit.bubbl.activitydemos",
                            "com.hit.bubbl.activitydemos." + demoClass);

                    PackageManager pm = context.getPackageManager();
                    ComponentName componentName = openDemoIntent.resolveActivity(pm);
                    ResolveInfo resolveInfo = pm.resolveActivity(openDemoIntent, 0);

                    if(openDemoIntent != null && componentName != null && resolveInfo != null) {
                        // 成功启动Activity
                        Log.d(TAG, "Success Open " + demoClass + ".");
                        context.startActivity(openDemoIntent);
                    }
                    else if(openDemoIntent == null) {
                        // 解析Intent失败
                        Log.e(TAG, "The Intent is null for " + demoClass + ".");
                    }
                    else if(componentName == null || resolveInfo == null) {
                        // 没有对应的指定Activity
                        Log.e(TAG, "No Match Activity for " + demoClass + ".");
                    }
                }
            });

            mButton = (Button) v.findViewById(R.id.textView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.text_button_item, parent, false);

        // ...

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mButton.setText(mDataset[position]);
        holder.activityId = position;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}