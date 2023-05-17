package com.shamsaha.volunteer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentVolunteerLoginBinding;
import com.shamsaha.util.UtilFunction;
import com.shamsaha.victim.viewmodel.VolunteerLoginViewModel;


public class VolunteerLoginFragment extends Fragment {

    private FragmentVolunteerLoginBinding binding;
    private VolunteerLoginViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVolunteerLoginBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(VolunteerLoginViewModel.class);
        binding.loginVol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validation()) {
                    viewModel.getUser(binding.emailVolLogin.getText().toString(),binding.passwordVolLogin.getText().toString()).observe((getActivity()), userLiveData-> {

                        String success = userLiveData.getSuccess();
                        String message = userLiveData.getMessage();
                        if(success.equalsIgnoreCase("true")){
                            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
                        }

                    });
                }
            }
        });

        return binding.getRoot();
    }

    private boolean validation() {
        if(binding.emailVolLogin.getText().toString().equals("")){
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_email), Toast.LENGTH_SHORT).show();
            return false;
        }else  if(!binding.emailVolLogin.getText().toString().matches(UtilFunction.regexEmail)) {
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_valid_email), Toast.LENGTH_SHORT).show();
            return false;
        }else  if(binding.passwordVolLogin.getText().toString().equals("")) {
            Toast.makeText(getActivity(), getResources().getString(R.string.please_enter_password), Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}