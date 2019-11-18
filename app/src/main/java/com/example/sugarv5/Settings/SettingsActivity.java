package com.example.sugarv5.Settings;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import com.example.sugarv5.R;
import com.example.sugarv5.Util.BottomNavViewHelper;

public class SettingsActivity extends AppCompatActivity {

    private Context mContext = SettingsActivity.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupBottomNavView();
    }


    private void setupBottomNavView(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationView);
    }
}
