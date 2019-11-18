package com.example.sugarv5;

import android.content.Context;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sugarv5.Util.BottomNavViewHelper;
import com.example.sugarv5.Util.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    //Database creation
    DatabaseHelper sugarDB;

    private Context mContext = MainActivity.this;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sugarDB = new DatabaseHelper(mContext);

        setupBottomNavView();
    }


    private void setupBottomNavView(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationView);
    }
}
