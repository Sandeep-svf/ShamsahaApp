package com.shamsaha.victim.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.shamsaha.R;
import com.shamsaha.databinding.ActivityMobileNumberOtpverificationBinding;
import com.shamsaha.sharedpreference.SharedPreferencesHelper;
import com.shamsaha.util.MyListener;
import com.shamsaha.victim.DashboardVictimActivity;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class MobileNumberOTPVerificationActivity extends AppCompatActivity {

    ActivityMobileNumberOtpverificationBinding binding;
    private FirebaseAuth firebaseAuth;
    private String phoneVerificationId;


    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mobile_number_otpverification);
        firebaseAuth = FirebaseAuth.getInstance();

        String mobileNumber = getIntent().getStringExtra("mobileNumber");
        Log.e("test_sam_otp","mobileNumber :"+mobileNumber);
        binding.emailVolLogin.setText("+973"+mobileNumber);
        send_verification_code("+973"+mobileNumber);
       // send_verification_code("+91"+mobileNumber);




        binding.backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        binding.editMobileNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MobileNumberOTPVerificationActivity.this, MobileNumberAuthActivity.class);
                startActivity(intent);
            }
        });

        binding.submitOtpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.otpEdittext.getText().toString().equals("")||binding.otpEdittext.getText().toString().length()<6){
                    Toast.makeText(MobileNumberOTPVerificationActivity.this, getResources().getString(R.string.please_enter_valid_otp), Toast.LENGTH_SHORT).show();
                }else{
                    String code = binding.otpEdittext.getText().toString(); // Replace with the code sent to the user's phone
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(phoneVerificationId, code);
                    signInWithPhoneAuthCredential(credential);
                }

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


    private void send_verification_code(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // (optional) Activity for callback binding
                        // If no activity is passed, reCAPTCHA verification can not be used.
                        .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onVerificationFailed(FirebaseException e) {
                    // Verification failed, handle the error
                    Toast.makeText(MobileNumberOTPVerificationActivity.this, getResources().getString(R.string.something_went_wrong_please_check), Toast.LENGTH_SHORT).show();
                    Log.e("test_sam_otp",e+"sam");
                    Intent intent = new Intent(MobileNumberOTPVerificationActivity.this, MobileNumberAuthActivity.class);
                    startActivity(intent);
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    // Auto-retrieval or instant verification completed successfully
                    // You can use credential to sign in the user
                    signInWithPhoneAuthCredential(phoneAuthCredential);
                }

                @Override
                public void onCodeSent(String verificationId, PhoneAuthProvider.ForceResendingToken token) {
                    // Code sent to the user's phone, save the verification ID and token to use later
                    phoneVerificationId = verificationId;
                }
            };


    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // User successfully signed in
                            AuthResult result = task.getResult();
                            FirebaseUser user = result.getUser();


                            SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MobileNumberOTPVerificationActivity.this);
                            sharedPreferencesHelper.setVicitmMobileWizardFlag("true");

                            // Do further actions with the signed-in user
                            Toast.makeText(MobileNumberOTPVerificationActivity.this, getResources().getString(R.string.otp_verificaiton_successful), Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MobileNumberOTPVerificationActivity.this, DashboardVictimActivity.class);
                            startActivity(intent);
                            finish();
                        } else {
                            // Verification failed, handle the error
                            Toast.makeText(MobileNumberOTPVerificationActivity.this, getResources().getString(R.string.wrong_otp_please_try_agin), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}