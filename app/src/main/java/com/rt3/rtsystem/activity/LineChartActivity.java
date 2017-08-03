package com.rt3.rtsystem.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.google.gson.Gson;
import com.rt3.rtsystem.R;
import com.rt3.rtsystem.bean.ItemBean;
import com.rt3.rtsystem.bean.MonthCollectPlasma;
import com.rt3.rtsystem.constant.Constants;
import com.rt3.rtsystem.utils.LineChartUtil;
import com.rt3.rtsystem.utils.OkhttpUtils;
import com.rt3.rtsystem.utils.ScreenSwitchUtils;

import java.io.IOException;
import java.io.Serializable;

public class LineChartActivity extends BaseActivity implements View.OnClickListener {

    private static final String ORDER_COUNT = "预约人数";
    private static final String REGIST_COUNT = "报名人数";
    private static final String CREATE_COUNT = "新接档人数";
    private static final String CANCEL_COUNT = "不合格人数";
    private static final String PLASMA_COUNT = "采浆袋数";
    private LineChart mLine_chart;
    private TextView mTv_item_name;
    private TextView mTv_back;
    private TextView mTv_title;
    private TextView mTv_des;
    private ProgressBar pb_progress;
    private ScreenSwitchUtils mScreenSwitchUtils;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    MonthCollectPlasma count = (MonthCollectPlasma) msg.obj;
                    LineChartUtil.setChartData(mLine_chart, count);
//                    pb_progress.setVisibility(View.GONE);
                    break;
                default:
                    break;
            }
        }
    };


    @Override
    public int getLayoutResId() {
        return R.layout.activity_line_chart;
    }

    @Override
    protected void initView() {
        mLine_chart = (LineChart) findViewById(R.id.line_chart);
        mTv_item_name = (TextView) findViewById(R.id.tv_item_name);
        mTv_back = (TextView) findViewById(R.id.tv_back);
        mTv_title = (TextView) findViewById(R.id.tv_title);
        mTv_des = (TextView) findViewById(R.id.tv_des);
        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);
        mScreenSwitchUtils = ScreenSwitchUtils.newInstance(this);
        pb_progress.setVisibility(View.VISIBLE);

    }

    @Override
    protected void initData() {
        ItemBean bean = (ItemBean) getIntent().getExtras().getSerializable("bean");

        mTv_item_name.setText(bean.getName());
        mTv_des.setText("最近一个月每天" + bean.getName() + "对比折线图");
        mTv_title.setText("折线图");

        LineChartUtil.initLineChart(mLine_chart, this);

        switch (bean.getName()) {
            case ORDER_COUNT:
                mLine_chart.removeAllViews();
                postMonthCount(Constants.MONTH_ORDER_COUNT);
                break;
            case REGIST_COUNT:
                mLine_chart.removeAllViews();
                pb_progress.setVisibility(View.VISIBLE);
                postMonthCount(Constants.MONTH_REGIST_COUNT);
                break;
            case CREATE_COUNT:
                mLine_chart.removeAllViews();
                pb_progress.setVisibility(View.VISIBLE);
                postMonthCount(Constants.MONTH_CREATE_COUNT);
                break;
            case CANCEL_COUNT:
                mLine_chart.removeAllViews();
                pb_progress.setVisibility(View.VISIBLE);
                postMonthCount(Constants.MONTH_CANCEL_COUNT);
                break;
            case PLASMA_COUNT:
                mLine_chart.removeAllViews();
                pb_progress.setVisibility(View.VISIBLE);
                postMonthCount(Constants.MONTH_COLLECT_PLASMA);
                break;
        }


    }

    private void postMonthCount(final String url) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                String parms = null;
                try {
                    parms = OkhttpUtils.post(url, Constants.BODY_JSON);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (parms.startsWith("{")) {
                    System.out.println("parms===" + parms.toString());
                    MonthCollectPlasma count = new Gson().fromJson(parms, MonthCollectPlasma.class);
                    LineChartUtil.setChartData(mLine_chart, count);
                }else {
                }

//                Message message = Message.obtain();
//                message.obj = count;
//                message.what = 1;
//                handler.sendMessage(message);

            }
        }.start();
        pb_progress.setVisibility(View.GONE);
    }

    @Override
    protected void initListener() {
        mTv_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_back:
                finish();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mScreenSwitchUtils.start(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScreenSwitchUtils.stop();
    }
}
