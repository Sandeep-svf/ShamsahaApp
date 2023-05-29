package com.shamsaha.victim.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.shamsaha.util.DeviceUtils;
import com.shamsaha.util.MyListener;
import com.shamsaha.victim.DashboardVictimActivity;
import com.shamsaha.victim.viewmodel.CheckDeviceIdWithPhoneViewModel;
import com.shamsaha.victim.viewmodel.CreateVictimViewModel;

import java.util.concurrent.TimeUnit;

public class MobileNumberAuthActivity extends AppCompatActivity {

    ActivityMobileNumberAuthBinding binding;
    private CreateVictimViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_mobile_number_auth);
        viewModel = new ViewModelProvider(this).get(CreateVictimViewModel.class);


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



                String deviceId = DeviceUtils.getUniqueDeviceId(MobileNumberAuthActivity.this);
                if (deviceId != null) {
                    // Use the device ID as needed
                    Log.e("test_sam_chat", "" + deviceId);
                }

                viewModel.getCreateVictim(deviceId,binding.phoneVictimEdittext.getText().toString(),MobileNumberAuthActivity.this)
                        .observe(MobileNumberAuthActivity.this, CheckDeviceIdWithPhoneViewModel -> {
                            String success = CheckDeviceIdWithPhoneViewModel.getSuccess();
                            String message = CheckDeviceIdWithPhoneViewModel.getMessage();

                            if(success.equalsIgnoreCase("true")){

                                SharedPreferencesHelper sharedPreferencesHelper = new SharedPreferencesHelper(MobileNumberAuthActivity.this);
                                sharedPreferencesHelper.setVicitmMobileWizardFlag("true");

                                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MobileNumberAuthActivity.this, DashboardVictimActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                 Toast.makeText(getApplicationContext(), getResources().getString(R.string.something_went_wrong)+" "+message, Toast.LENGTH_SHORT).show();
                                // open_mobile_number_verificaiton_popup(getActivity());
                            }
                        });
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