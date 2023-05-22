package com.shamsaha.victim.auth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.shamsaha.R;
import com.shamsaha.databinding.ActivityMobileNumberOtpverificationBinding;

public class MobileNumberOTPVerificationActivity extends AppCompatActivity {

    ActivityMobileNumberOtpverificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mobile_number_otpverification);


    }
}