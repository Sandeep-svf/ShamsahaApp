package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentSurvivorSupportToolsBinding;
import com.shamsaha.victim.adapter.ResourcesPerCountryAdapter;
import com.shamsaha.victim.adapter.ResourcesSST;


public class SurvivorSupportToolsFragment extends Fragment {


    FragmentSurvivorSupportToolsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentSurvivorSupportToolsBinding.inflate(inflater, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rcvSst.setLayoutManager(linearLayoutManager);
        ResourcesSST resourcesSST = new ResourcesSST(getActivity());
        binding.rcvSst.setAdapter(resourcesSST);




        return binding.getRoot();
    }
}