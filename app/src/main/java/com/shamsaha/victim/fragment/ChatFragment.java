package com.shamsaha.victim.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
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
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.shamsaha.R;
import com.shamsaha.databinding.FragmentChatBinding;
import com.shamsaha.sharedpreference.SharedPreferencesHelper;
import com.shamsaha.util.DeviceUtils;
import com.shamsaha.victim.DashboardVictimActivity;
import com.shamsaha.victim.adapter.EventVounteerAdapter;
import com.shamsaha.victim.auth.MobileNumberAuthActivity;
import com.shamsaha.victim.auth.MobileNumberOTPVerificationActivity;
import com.shamsaha.victim.viewmodel.CheckDeviceIdWithPhoneViewModel;
import com.shamsaha.victim.viewmodel.EventVolunteerViewModel;

import java.util.concurrent.TimeUnit;


public class ChatFragment extends Fragment {

    FragmentChatBinding binding;
    private CheckDeviceIdWithPhoneViewModel viewModel;
    private FirebaseAuth firebaseAuth;
    private String phoneVerificationId;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CheckDeviceIdWithPhoneViewModel.class);
        firebaseAuth = FirebaseAuth.getInstance();

        String deviceId = DeviceUtils.getUniqueDeviceId(getActivity());
        if (deviceId != null) {
            // Use the device ID as needed
            Log.e("test_sam_chat", "" + deviceId);
            //36f18e2c1b326aa3a82987fafeef30ea07cab724
            //36f18e2c1b326aa3a82987fafeef30ea07cab724
        }

        viewModel.getCheckWithDeviceIdPHone(deviceId,getActivity()).observe(getActivity(),CheckDeviceIdWithPhoneViewModel ->{
            String success = CheckDeviceIdWithPhoneViewModel.getSuccess();
            String message = CheckDeviceIdWithPhoneViewModel.getMessage();

            if(success.equalsIgnoreCase("true")){
               //Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                open_mobile_number_verificaiton_popup(getActivity());
            }else{
               // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                open_mobile_number_verificaiton_popup(getActivity());
            }
        });

        return binding.getRoot();
    }

    private void alert_dialog_message(String value) {

        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.test_dialog_xml_otp, null);

        final ImageView close_dialog = alertLayout.findViewById(R.id.close_dialog);



        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setView(alertLayout);
        alert.setCancelable(false);

        AlertDialog dialogs = alert.create();
        dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogs.show();
        dialogs.setCanceledOnTouchOutside(true);


        close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialogs.dismiss();
            }
        });
    }

    private void open_mobile_number_verificaiton_popup(FragmentActivity activity) {
        AlertDialog dialogs;
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.test_dialog_xml_otp, null);

        final AppCompatImageView close_dialog = alertLayout.findViewById(R.id.close_dialog);
        final AppCompatButton request_otp_button = alertLayout.findViewById(R.id.request_otp_button);
        final AppCompatEditText phoneVictimEdittext = alertLayout.findViewById(R.id.phoneVictimEdittext);


        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setView(alertLayout);
        alert.setCancelable(false);
        dialogs = alert.create();
        dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogs.show();
        dialogs.setCanceledOnTouchOutside(true);


        request_otp_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogs.dismiss();
                try {
                    send_verification_code("+973" + phoneVictimEdittext.getText().toString());
                    // send_verification_code("+91" + phoneVictimEdittext.getText().toString());
                } catch (NullPointerException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity(), getResources().getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
                }
                
                otp_verificaiton_popup(activity,phoneVictimEdittext.getText().toString());
            }
        });

        /*close_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogs.dismiss();
            }
        });*/


    }

    private void otp_verificaiton_popup(FragmentActivity activity, String number) {

        AlertDialog dialogs;
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        View alertLayout = inflater.inflate(R.layout.test_dialog_xml_otp2, null);

        final AppCompatImageView close_dialog = alertLayout.findViewById(R.id.close_dialog);
        final AppCompatButton request_otp_button = alertLayout.findViewById(R.id.request_otp_button);
        final AppCompatTextView phoneVictimEdittext = alertLayout.findViewById(R.id.phoneVictimEdittext);
        final AppCompatEditText otp_edittext = alertLayout.findViewById(R.id.otp_edittext);

        phoneVictimEdittext.setText(number);


        final AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
        alert.setView(alertLayout);
        alert.setCancelable(false);
        dialogs = alert.create();
        dialogs.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogs.show();
        dialogs.setCanceledOnTouchOutside(true);


        otp_edittext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(otp_edittext.getText().toString().equals("") || otp_edittext.getText().toString().length() < 6){
                    Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_valid_otp), Toast.LENGTH_SHORT).show();
                }else{
                    String code = otp_edittext.getText().toString(); // Replace with the code sent to the user's phone
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(phoneVerificationId, code);
                    signInWithPhoneAuthCredential(credential);
                }

            }
        });




    }

    private void send_verification_code(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(firebaseAuth)
                        .setPhoneNumber(phoneNumber)       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(getActivity())                 // (optional) Activity for callback binding
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
                    Toast.makeText(getActivity(), getResources().getString(R.string.something_went_wrong_please_check), Toast.LENGTH_SHORT).show();
                    Log.e("test_sam_otp", e + "sam");

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
                .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // User successfully signed in
                            AuthResult result = task.getResult();
                            FirebaseUser user = result.getUser();

                            // Do further actions with the signed-in user
                            Toast.makeText(getActivity(), getResources().getString(R.string.otp_verificaiton_successful), Toast.LENGTH_SHORT).show();

                        } else {
                            // Verification failed, handle the error
                            Toast.makeText(getActivity(), getResources().getString(R.string.wrong_otp_please_try_agin), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
    
}