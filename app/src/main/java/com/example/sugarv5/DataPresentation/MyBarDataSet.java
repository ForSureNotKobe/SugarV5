package com.example.sugarv5.DataPresentation;

import android.support.v4.content.ContextCompat;

import com.example.sugarv5.R;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

public class MyBarDataSet extends BarDataSet {


    public MyBarDataSet(List<BarEntry> yVals, String label) {
        super(yVals, label);
    }

    @Override
    public int getColor(int index) {
        if ((getEntryForXIndex(index).getVal() < 70 && getEntryForXIndex(index).getVal() >= 60)
        || getEntryForXIndex(index).getVal() <= 110 && getEntryForXIndex(index).getVal() > 100) // less than 95 green
            return mColors.get(0);
        else if (getEntryForXIndex(index).getVal() < 60 || getEntryForXIndex(index).getVal() >110) // less than 100 orange
            return mColors.get(1);
        else
            return mColors.get(2);
    }

}
