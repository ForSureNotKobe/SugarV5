package com.example.sugarv5.DataPresentation;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;


import com.example.sugarv5.Database.DatabaseHelper;
import com.example.sugarv5.Homepage.HomepageActivity;
import com.example.sugarv5.R;
import com.example.sugarv5.Util.BottomNavViewHelper;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class DataPresentationActivity extends AppCompatActivity {

    private Context mContext = DataPresentationActivity.this;


    BarChart barChart;
    com.example.sugarv5.Database.DatabaseHelper sugarDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_presentation);
        setupBottomNavView();

        sugarDB = new DatabaseHelper(this);

        ShowChart();
    }

    public void ShowChart() {

        barChart = findViewById(R.id.chart_weeklyData);
        int i = 0;

        Cursor res = sugarDB.getAllData();
        if (res.getCount() == 0)
            return;

        ArrayList<BarEntry> barEntries = new ArrayList<>();

        ArrayList<String> theDates = new ArrayList<>();

        while (res.moveToNext()) {
            Integer measureValue = res.getInt(1);
            String measureDate = res.getString(3);
            barEntries.add(new BarEntry(measureValue, i));
            theDates.add(measureDate);

            i++;
            if (i == 7) break;
        }


        MyBarDataSet barDataSet = new MyBarDataSet(barEntries, "Sugar Level");

        barDataSet.setColors(new int[]{ContextCompat.getColor(this, R.color.colorPrimaryDark),
                ContextCompat.getColor(this, R.color.colorAccent),
                ContextCompat.getColor(this, R.color.colorPrimary)});

        BarData theData = new BarData(theDates, barDataSet);

        barChart.setData(theData);

        barChart.setTouchEnabled(true);
        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
    }

    private void setupBottomNavView() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationView);
    }


}
