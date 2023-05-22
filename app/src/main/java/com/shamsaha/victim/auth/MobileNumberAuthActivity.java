package com.shamsaha.victim.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shamsaha.R;
import com.shamsaha.databinding.ActivityMobileNumberAuthBinding;
import com.shamsaha.victim.DashboardVictimActivity;

public class MobileNumberAuthActivity extends AppCompatActivity {


    ActivityMobileNumberAuthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mobile_number_auth);


        binding.appCompatButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MobileNumberAuthActivity.this, DashboardVictimActivity.class);
                startActivity(intent);
            }
        });




    }
}