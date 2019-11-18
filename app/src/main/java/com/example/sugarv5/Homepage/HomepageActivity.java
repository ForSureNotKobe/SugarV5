package com.example.sugarv5.Homepage;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.example.sugarv5.Database.DatabaseHelper;
import com.example.sugarv5.R;
import com.example.sugarv5.RecyclerViewStuff.MeasuresAdapter;
import com.example.sugarv5.RecyclerViewStuff.MeasuresItem;
import com.example.sugarv5.Util.BottomNavViewHelper;

public class HomepageActivity extends AppCompatActivity {

    //NEEDED DATA AND FORMATS

    Button btn_AddNewMeasure;
    EditText txt_Measure;
    EditText txt_MeasureNote;

    com.example.sugarv5.Database.DatabaseHelper sugarDB;

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");

    Date currentTime = new Date();

    private Context mContext = HomepageActivity.this;

    //END OF DATA AND FORMATS

    //RECYCLER VIEW ADAPTER

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_homepage);

        sugarDB = new DatabaseHelper(mContext);

        ShowList();

        setupBottomNavView();

        btn_AddNewMeasure = (Button)findViewById(R.id.btn_AddNewMeasure);
        txt_Measure = (EditText) findViewById(R.id.edit_Measure);
        txt_MeasureNote = (EditText)findViewById(R.id.edit_MeasureNote);

        AddMeasure();
    }

    public void AddMeasure() {
        btn_AddNewMeasure.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        String newMeasure = txt_Measure.getText().toString();
                        String newMeasureNote = txt_MeasureNote.getText().toString();
                        String currentDateToString = dateFormat.format(currentTime);
                        String currentTimeToString = timeFormat.format(currentTime);
                        boolean isInserted = sugarDB.insertData(newMeasure,newMeasureNote,currentDateToString, currentTimeToString);
                        if (isInserted) {
                            Toast.makeText(HomepageActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                            ShowList();
                        }
                        else
                            Toast.makeText(HomepageActivity.this,"Data not inserted",Toast.LENGTH_LONG).show();

                    }
                }
        );
    }

    public void ShowList(){

        ArrayList<MeasuresItem> measuresList = new ArrayList<>();

        Cursor res = sugarDB.getAllData();
        if (res.getCount() == 0)
            return;


        while (res.moveToNext()){
            Integer measureValue = res.getInt(1);
            //String measureNote = res.getString(2);
            String measureDate = res.getString(3);
            String measureTime = res.getString(4);

            if (measureValue >=70 && measureValue <= 100)
                measuresList.add(new MeasuresItem(R.drawable.ic_signal_green, measureValue.toString(), measureDate + " " + measureTime));

            if ((measureValue < 70 && measureValue >= 60) || (measureValue > 100 && measureValue <= 110))
                measuresList.add(new MeasuresItem(R.drawable.ic_signal_orange, measureValue.toString(), measureDate + " " + measureTime));

            if (measureValue < 60 || measureValue > 110)
                measuresList.add(new MeasuresItem(R.drawable.ic_signal_red, measureValue.toString(), measureDate + " " + measureTime));
        }

        mRecyclerView = findViewById(R.id.recyclerViewMeasures);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MeasuresAdapter(measuresList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }


    private void setupBottomNavView(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationView);
    }
}
