package com.shamsaha.victim.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.shamsaha.R;
import com.shamsaha.databinding.ActivityMobileNumberOtpverificationBinding;
import com.shamsaha.util.MyListener;
import com.shamsaha.victim.DashboardVictimActivity;

public class MobileNumberOTPVerificationActivity extends AppCompatActivity {

    ActivityMobileNumberOtpverificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mobile_number_otpverification);

        binding.editMobileNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MobileNumberOTPVerificationActivity.this, MobileNumberAuthActivity.class);
                startActivity(intent);
            }
        });


        binding.appCompatButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MobileNumberOTPVerificationActivity.this, DashboardVictimActivity.class);
                startActivity(intent);
            }
        });
    }
}