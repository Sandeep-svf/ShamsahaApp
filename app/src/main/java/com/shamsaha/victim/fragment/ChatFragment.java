package com.shamsaha.victim.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
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
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.shamsaha.R;
import com.shamsaha.databinding.FragmentChatBinding;
import com.shamsaha.util.DeviceUtils;
import com.shamsaha.victim.adapter.EventVounteerAdapter;
import com.shamsaha.victim.viewmodel.CheckDeviceIdWithPhoneViewModel;
import com.shamsaha.victim.viewmodel.EventVolunteerViewModel;


public class ChatFragment extends Fragment {

    FragmentChatBinding binding;
    private CheckDeviceIdWithPhoneViewModel viewModel;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentChatBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(CheckDeviceIdWithPhoneViewModel.class);

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
            }else{
               // Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
               // open_mobile_number_verificaiton_popup(getActivity());
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
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.custom_popup, null);

        PopupWindow popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        Button btnClose = customView.findViewById(R.id.btnClose);

        popupWindow.setOutsideTouchable(true); // Dismiss the popup when touched outside
        popupWindow.setFocusable(true); // Enable or disable focusability of the popup window

        // Set animation style if desired
       // popupWindow.setAnimationStyle(R.style.PopupAnimation);

        // Customize additional properties if needed, e.g., background color, elevation, etc.
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setElevation(8); // Adjust elevation as needed


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.showAsDropDown(binding.viewArcherChat);

    }
}