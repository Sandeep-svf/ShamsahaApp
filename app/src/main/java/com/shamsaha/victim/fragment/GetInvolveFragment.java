package com.shamsaha.victim.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shamsaha.R;
import com.shamsaha.databinding.FragmentGetInvolveBinding;
import com.shamsaha.victim.model.res.GetInvolvedRes;
import com.shamsaha.victim.viewmodel.GetInvolvedViewModel;
import com.shamsaha.victim.viewmodel.VolunteerLoginViewModel;
import com.shamsaha.volunteer.DashboardVol;


public class GetInvolveFragment extends Fragment {

    FragmentGetInvolveBinding binding;
    private GetInvolvedViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentGetInvolveBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(GetInvolvedViewModel.class);

        get_involed_view_model_call();

        binding.takeActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //

                Toast.makeText(getActivity(), "Pressed...", Toast.LENGTH_SHORT).show();
            }
        });
        binding.valunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Pressed...", Toast.LENGTH_SHORT).show();

            }
        });

        binding.empGiftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Pressed...", Toast.LENGTH_SHORT).show();

            }
        });

            return binding.getRoot();
    }

    private void get_involed_view_model_call() {
        viewModel.getInvolved("en",getActivity()).observe(getActivity(), getInvolvedLiveData-> {

            String success = getInvolvedLiveData.getSuccess();
            String message = getInvolvedLiveData.getMessage();
            if (success.equalsIgnoreCase("true")) {

                GetInvolvedRes getInvolvedRes = getInvolvedLiveData.getData();
                binding.t1.setText(getInvolvedRes.getHeading());
                binding.t2.setText(getInvolvedRes.getContent1());
                binding.t3.setText(getInvolvedRes.getContent2());
                binding.t4.setText(getInvolvedRes.getContent3());
                Glide.with(getActivity())
                        .load(getInvolvedRes.getImage())
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(binding.image1);


                //Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });
    }
}