package com.shamsaha.victim.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.shamsaha.R;
import com.shamsaha.databinding.ActivityMobileNumberAuthBinding;
import com.shamsaha.sharedpreference.SharedPreferencesHelper;
import com.shamsaha.util.MyListener;
import com.shamsaha.victim.DashboardVictimActivity;

import java.util.concurrent.TimeUnit;

public class MobileNumberAuthActivity extends AppCompatActivity {


    ActivityMobileNumberAuthBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mobile_number_auth);


        binding.requestOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validation()){
                    Intent intent = new Intent(MobileNumberAuthActivity.this, MobileNumberOTPVerificationActivity.class);
                    intent.putExtra("mobileNumber",binding.phoneVictimEdittext.getText().toString());
                    startActivity(intent);

                }

            }
        });





        binding.appCompatButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MobileNumberAuthActivity.this);
                sharedPreferencesHelper.setVicitmMobileWizardFlag("true");

                Intent intent = new Intent(MobileNumberAuthActivity.this, DashboardVictimActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }

    private boolean validation() {
        if(binding.phoneVictimEdittext.getText().toString().equals("")){
            Toast.makeText(MobileNumberAuthActivity.this, getResources().getString(R.string.please_enter_phone), Toast.LENGTH_SHORT).show();
            return false;
        }if(binding.phoneVictimEdittext.getText().toString().length()<7 ||
                binding.phoneVictimEdittext.getText().toString().length()>15){
            Toast.makeText(MobileNumberAuthActivity.this, getResources().getString(R.string.please_enter_valid_phone), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


}