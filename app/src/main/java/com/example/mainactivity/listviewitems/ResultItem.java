package com.example.mainactivity.listviewitems;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;

import com.example.mainactivity.R;
import com.github.mikephil.charting.charts.BubbleChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BubbleData;
import com.github.mikephil.charting.data.BubbleDataSet;
import com.github.mikephil.charting.data.BubbleEntry;
import com.github.mikephil.charting.data.ChartData;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.interfaces.datasets.IBubbleDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;


public class ResultItem extends ChartItem {

    private final Typeface mTf;

    public ResultItem(ChartData<?> cd, Context c) {
        super(cd);

        mTf = Typeface.createFromAsset(c.getAssets(), "OpenSans-Regular.ttf");
    }

    @Override
    public int getItemType() {
        return TYPE_LINECHART;
    }

    @SuppressLint("InflateParams")
    @Override
    public View getView(int position, View convertView, Context c) {

        ViewHolder holder;



        if (convertView == null) {

            holder = new ViewHolder();

            convertView = LayoutInflater.from(c).inflate(
                    R.layout.list_item_linechart, null);
            holder.chart = convertView.findViewById(R.id.chart);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.chart.getDescription().setEnabled(false);

//        holder.chart.setOnChartValueSelectedListener(this);

        holder.chart.setDrawGridBackground(false);

        holder.chart.setTouchEnabled(true);

        Legend l = holder.chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setTypeface(mTf);

        YAxis yl = holder.chart.getAxisLeft();
        yl.setTypeface(mTf);
        yl.setSpaceTop(30f);
        yl.setSpaceBottom(30f);
        yl.setDrawZeroLine(false);

        holder.chart.getAxisRight().setEnabled(false);

        XAxis xl = holder.chart.getXAxis();
        xl.setPosition(XAxis.XAxisPosition.BOTTOM);
        xl.setTypeface(mTf);


//        int count = seekBarX.getProgress();
//        int range = seekBarY.getProgress();
//
//        tvX.setText(String.valueOf(count));
//        tvY.setText(String.valueOf(range));

        ArrayList<BubbleEntry> values1 = new ArrayList<>();
        ArrayList<BubbleEntry> values2 = new ArrayList<>();
        ArrayList<BubbleEntry> values3 = new ArrayList<>();

//        for (int i = 0; i < 100; i++) {
//            values1.add(new BubbleEntry(i, (float) (Math.random() * 100), (float) (Math.random() * range), getResources().getDrawable(R.drawable.star)));
//            values2.add(new BubbleEntry(i, (float) (Math.random() * 100), (float) (Math.random() * range), getResources().getDrawable(R.drawable.star)));
//            values3.add(new BubbleEntry(i, (float) (Math.random() * 100), (float) (Math.random() * range)));
//        }

        // create a dataset and give it a type
        BubbleDataSet set1 = new BubbleDataSet(values1, "DS 1");
        set1.setDrawIcons(false);
        set1.setColor(ColorTemplate.COLORFUL_COLORS[0], 130);
        set1.setDrawValues(true);

        BubbleDataSet set2 = new BubbleDataSet(values2, "DS 2");
        set2.setDrawIcons(false);
        set2.setIconsOffset(new MPPointF(0, 15));
        set2.setColor(ColorTemplate.COLORFUL_COLORS[1], 130);
        set2.setDrawValues(true);

        BubbleDataSet set3 = new BubbleDataSet(values3, "DS 3");
        set3.setColor(ColorTemplate.COLORFUL_COLORS[2], 130);
        set3.setDrawValues(true);

        ArrayList<IBubbleDataSet> dataSets = new ArrayList<>();
        dataSets.add(set1); // add the data sets
        dataSets.add(set2);
        dataSets.add(set3);

        // create a data object with the data sets
        BubbleData data = new BubbleData(dataSets);
        data.setDrawValues(false);
        data.setValueTypeface(mTf);
        data.setValueTextSize(8f);
        data.setValueTextColor(Color.WHITE);
        data.setHighlightCircleWidth(1.5f);

        holder.chart.setData(data);
        holder.chart.invalidate();

//        // apply styling
//        // holder.chart.setValueTypeface(mTf);
//        holder.chart.getDescription().setEnabled(false);
//        holder.chart.setDrawGridBackground(false);
//
//        XAxis xAxis = holder.chart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setTypeface(mTf);
//        xAxis.setDrawGridLines(false);
//        xAxis.setDrawAxisLine(true);
//
//        YAxis leftAxis = holder.chart.getAxisLeft();
//        leftAxis.setTypeface(mTf);
//        leftAxis.setLabelCount(5, false);
//        leftAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//
//        YAxis rightAxis = holder.chart.getAxisRight();
//        rightAxis.setTypeface(mTf);
//        rightAxis.setLabelCount(5, false);
//        rightAxis.setDrawGridLines(false);
//        rightAxis.setAxisMinimum(0f); // this replaces setStartAtZero(true)
//
//        // set data
//        holder.chart.setData((LineData) mChartData);
//
//        // do not forget to refresh the chart
//        // holder.chart.invalidate();
//        holder.chart.animateX(750);

        return convertView;
    }

    private static class ViewHolder {
        BubbleChart chart;
    }
}