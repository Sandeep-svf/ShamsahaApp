package com.shamsaha.victim.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentVolunteerBinding;
import com.shamsaha.victim.adapter.EventVounteerAdapter;
import com.shamsaha.victim.adapter.ResourcesSST;
import com.shamsaha.victim.model.res.EventVolunteerRes;
import com.shamsaha.victim.viewmodel.EventVolunteerViewModel;
import com.shamsaha.victim.viewmodel.VolunteerLoginViewModel;
import com.shamsaha.volunteer.DashboardVol;

import java.util.ArrayList;
import java.util.List;


public class VolunteerFragment extends Fragment {

    FragmentVolunteerBinding binding;
    private EventVolunteerViewModel viewModel;
    private List<EventVolunteerRes> eventVolunteerResList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentVolunteerBinding.inflate(inflater, container, false);
        viewModel = new ViewModelProvider(this).get(EventVolunteerViewModel.class);

        viewModel.getEventVolList("en",getActivity()).observe(getActivity(),eventVolunteerModel -> {
            String success = eventVolunteerModel.getSuccess();
            String message = eventVolunteerModel.getMessage();

            if(success.equalsIgnoreCase("true")){
                eventVolunteerResList = eventVolunteerModel.getData();

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                binding.rcvEventVolunteer.setLayoutManager(linearLayoutManager);
                EventVounteerAdapter resourcesSST = new EventVounteerAdapter(getActivity(),eventVolunteerResList);
                binding.rcvEventVolunteer.setAdapter(resourcesSST);

            }else{
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }
}