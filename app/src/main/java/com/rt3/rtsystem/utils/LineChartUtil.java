package com.rt3.rtsystem.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.rt3.rtsystem.R;
import com.rt3.rtsystem.bean.MonthCollectPlasma;
import com.rt3.rtsystem.view.CustomMarkerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by RT3
 * on 2017/8/2.
 */

public class LineChartUtil {

    private static Typeface mTf;
    //y轴数据
    private static ArrayList<Entry> mValueList;
    //x轴坐标的数据
    private static ArrayList<String> mDataList;

    private static LineDataSet mD1;

    public static void initLineChart(LineChart lineChart, Context context) {
        mTf = Typeface.createFromAsset(context.getAssets(), "OpenSans-Regular.ttf");
        lineChart.setTouchEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setDragEnabled(true);
        lineChart.setDrawBorders(true);
        lineChart.setBorderWidth(1);

        CustomMarkerView mv = new CustomMarkerView(context, R.layout.custom_marker_view);
        lineChart.setMarkerView(mv);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            lineChart.setAlpha(0.8f);
        }
        lineChart.setVisibleXRangeMaximum(10);
        lineChart.setBorderColor(context.getResources().getColor(R.color.dividerColor));
        //设置当前的折线图的描述
        Legend lineChartLegend = lineChart.getLegend();
        lineChartLegend.setEnabled(false);

        //获取当前的x轴对象
        XAxis xAxis = lineChart.getXAxis();
        //设置x轴的显示位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置x轴的字体
        xAxis.setTypeface(mTf);
        //是否绘制x轴的网格线
        xAxis.setDrawGridLines(false);
        //是否绘制x轴的轴线
        xAxis.setDrawAxisLine(true);
        //设置x轴坐标的间距
//        xAxis.setSpaceBetweenLabels(16);
        //定制X轴起点和终点Label不能超出屏幕。
        xAxis.setAvoidFirstLastClipping(true);

        //获取左边的y轴对象
        YAxis leftAxis = lineChart.getAxisLeft();
        //设置左边y轴的字体
        leftAxis.setTypeface(mTf);
        //参数1：左边y轴提供的区间的个数。 参数2：是否均匀分布这几个区间。 false：均匀。 true：不均匀
        leftAxis.setLabelCount(5, true);
        leftAxis.setAxisMinValue(0);

        //获取右边的y轴对象
        YAxis rightAxis = lineChart.getAxisRight();
        //将右边的y轴设置为不显式的
        rightAxis.setEnabled(false);

        // 设置x轴方向的动画。执行时间是750.
        // 不需要再执行：invalidate();

        lineChart.animateX(2000);

    }

    /**
     * 初始化图表的数据
     *
     * @param lineChart
     * @param result
     */
    public static void setChartData(LineChart lineChart, MonthCollectPlasma result) {

        // 提供折线数据。（通常情况下，折线的数据来自于服务器的数据）
        LineData lineData = generateDataLine(result.getResult());
        if (lineData == null) {
            lineChart.setNoDataText("暂无数据");
            return;
        } else {
            lineChart.setData(lineData);

        }

    }

    private static LineData generateDataLine(List<MonthCollectPlasma.ResultBean> result) {

        mDataList = new ArrayList<String>();
        mValueList = new ArrayList<Entry>();

        if (result.size() > 0 && result != null) {

            for (int i = 0; i < result.size(); i++) {

                int count = result.get(i).getCount();
                String date = result.get(i).getDate();
                String newDate = date.substring(0, 8);

                float aFloat = Float.parseFloat(String.valueOf(count));

                mValueList.add(new Entry(aFloat, i));
                mDataList.add(newDate);

//                mValueList.add(new Entry(aFloat + (float) (Math.random() * 50 + 40), i));

                mD1 = new LineDataSet(mValueList, "实时图");

                mD1.setDrawCubic(true);
                mD1.setDrawCircles(true);
                mD1.setDrawCircleHole(false);
                mD1.setFillAlpha(65);

//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    context.getDrawable(R.drawable.shap_fade_redbg);
//                }
                mD1.setDrawFilled(true);
                //设置折线的宽度
                mD1.setLineWidth(1.5f);
                //设置小圆圈的尺寸
                mD1.setCircleSize(0f);
                //设置高亮的颜色
                mD1.setHighLightColor(Color.RED);

                //是否显示小圆圈对应的数值
                mD1.setDrawValues(false);
                mD1.setColor(Color.BLUE);
                mD1.setAxisDependency(YAxis.AxisDependency.LEFT);

            }
        }

        ArrayList<LineDataSet> sets = new ArrayList<LineDataSet>();
        sets.add(mD1);
        LineData cd = new LineData(mDataList, sets);
        return cd;

    }
}
