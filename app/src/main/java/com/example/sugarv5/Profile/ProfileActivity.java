package com.example.sugarv5.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sugarv5.Homepage.HomepageActivity;
import com.example.sugarv5.R;
import com.example.sugarv5.Util.BottomNavViewHelper;

public class ProfileActivity extends AppCompatActivity {

    private Context mContext = ProfileActivity.this;

    EditText txt_UpperSugar, txt_LowerSugar;
    Button btn_SetNewProfileData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txt_UpperSugar = findViewById(R.id.edit_UpperSugarLvl);
        txt_LowerSugar = findViewById(R.id.edit_LowerSugarLvl);
        btn_SetNewProfileData = findViewById(R.id.btn_SetNewProfileData);

        setNewProfileData();

        setupBottomNavView();
    }

    public void setNewProfileData(){
        btn_SetNewProfileData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick (View v) {
                        String newUpper = txt_UpperSugar.getText().toString();
                        String newLower = txt_LowerSugar.getText().toString();
                        new ProfileData(Integer.parseInt(newUpper), Integer.parseInt(newLower));
                    }
                }
        );
    }

    private void setupBottomNavView(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavBar);
        BottomNavViewHelper.enableNavigation(mContext, bottomNavigationView);
    }
}
