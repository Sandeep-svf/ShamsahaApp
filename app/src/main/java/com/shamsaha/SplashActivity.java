package com.shamsaha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.shamsaha.sharedpreference.SharedPreferencesHelper;
import com.shamsaha.victim.DashboardVictimActivity;
import com.shamsaha.victim.auth.MobileNumberAuthActivity;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_DISPLAY_LENGTH = 500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                SharedPreferencesHelper preferencesHelper = new SharedPreferencesHelper(SplashActivity.this); // Replace "this" with your activity or context

                /*// Saving a value to shared preferences
                preferencesHelper.setUsername("John");

                // Retrieving a value from shared preferences
                String username = preferencesHelper.getUsername();*/

                String flag = preferencesHelper.getVicitmMobileWizardFlag();
                Log.e("test_sam_WizardFlag",flag+"ok");

                if(flag == null){
                    Intent intent = new Intent(SplashActivity.this, MobileNumberAuthActivity.class);
                    startActivity(intent);
                    finish();
                }else if(flag.equals("true")){
                    Intent intent = new Intent(SplashActivity.this, DashboardVictimActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(SplashActivity.this, getResources().getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SplashActivity.this, MobileNumberAuthActivity.class);
                    startActivity(intent);
                    finish();
                }


            }
        }, SPLASH_DISPLAY_LENGTH);

    }
}