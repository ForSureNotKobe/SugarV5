package com.example.sugarv5.Util;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import com.example.sugarv5.DataPresentation.DataPresentationActivity;
import com.example.sugarv5.Homepage.HomepageActivity;
import com.example.sugarv5.Profile.ProfileActivity;
import com.example.sugarv5.R;
import com.example.sugarv5.Settings.SettingsActivity;

public class BottomNavViewHelper {

    public static void enableNavigation(final Context context, BottomNavigationView view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.ic_homepage:
                        Intent intentHomepage = new Intent(context, HomepageActivity.class);
                        context.startActivity(intentHomepage);
                        break;

                    case R.id.ic_settings:
                        Intent intentSettings = new Intent(context, SettingsActivity.class);
                        context.startActivity(intentSettings);
                        break;

                    case R.id.ic_profile:
                        Intent intentProfile = new Intent(context, ProfileActivity.class);
                        context.startActivity(intentProfile);
                        break;

                    case R.id.ic_chart:
                        Intent intentChart = new Intent(context, DataPresentationActivity.class);
                        context.startActivity(intentChart);
                        break;
                }


                return false;
            }
        });
    }
}
