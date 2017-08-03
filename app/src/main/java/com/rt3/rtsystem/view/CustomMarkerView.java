package com.rt3.rtsystem.view;

import android.content.Context;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.rt3.rtsystem.R;

/**
 * Created by Administrator on 2017/5/3.
 */

public class CustomMarkerView extends MarkerView {

    private final TextView mTvContent;

    /**
     * Constructor. Sets up the MarkerView with a custom layout resource.
     *
     * @param context
     * @param layoutResource
     */
    public CustomMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        mTvContent = (TextView) findViewById(R.id.tvContent);
    }

    @Override
    public void refreshContent(Entry e, Highlight highlight) {
        mTvContent.setText("当前值："+e.getVal() + "");
    }

    @Override
    public int getXOffset() {
        return -(getWidth() / 2);
    }

    @Override
    public int getYOffset() {
        return -getHeight();
    }
}
