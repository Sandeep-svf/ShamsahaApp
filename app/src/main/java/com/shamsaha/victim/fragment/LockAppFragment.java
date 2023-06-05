package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentLockAppBinding;
import com.shamsaha.util.DeviceUtils;
import com.shamsaha.util.GridSpacingItemDecoration;
import com.shamsaha.util.UtilFunction;
import com.shamsaha.victim.adapter.EventMediaPhotoAdapter;
import com.shamsaha.victim.viewmodel.PinViewModel;


public class LockAppFragment extends Fragment implements View.OnClickListener {

    private FragmentLockAppBinding binding;
    private  String deviceId;
    private PinViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLockAppBinding.inflate(inflater,container,false);
        viewModel = new ViewModelProvider(this).get(PinViewModel.class);
        binding.appCompatButton.setOnClickListener(this);
        deviceId = DeviceUtils.getUniqueDeviceId(getActivity());
        return binding.getRoot();
    }

    @Override
    public void onClick(View view) {
        // Handle the click event here
        switch (view.getId()) {
            case R.id.appCompatButton:
                if(validation()) {
                    createPinApi();
                }
                break;
        }
    }

    private void createPinApi() {
        viewModel.getPinCreate("en",getActivity(),binding.pinEditText.getText().toString(),
                binding.emailEditText.getText().toString(),deviceId).observe(getActivity(),
                checkDeviceWithPhoneModel -> {
                    String success = checkDeviceWithPhoneModel.getSuccess();
                    String message = checkDeviceWithPhoneModel.getMessage();
                    if(success.equalsIgnoreCase("true")){
                        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                    }
        });
    }

    private boolean validation() {
        if(binding.emailEditText.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_email), Toast.LENGTH_SHORT).show();
            return false;
        }else if(!binding.emailEditText.getText().toString().matches(UtilFunction.regexEmail)){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_valid_email), Toast.LENGTH_SHORT).show();
            return false;
        }else if(binding.pinEditText.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_pin), Toast.LENGTH_SHORT).show();
            return false;
        }else if(binding.pinReEnterEditText.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_re_enter_email), Toast.LENGTH_SHORT).show();
            return false;
        }else if(deviceId == null){
            Toast.makeText(getActivity(), getResources().getString(R.string.something_went_wrong), Toast.LENGTH_SHORT).show();
            return false;
        }
    return true;
    }
}