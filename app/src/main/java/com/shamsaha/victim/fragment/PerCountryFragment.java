package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentPerCountryBinding;
import com.shamsaha.victim.adapter.ResourcesPerCountryAdapter;


public class PerCountryFragment extends Fragment {

  FragmentPerCountryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPerCountryBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rcvPerCountryList.setLayoutManager(linearLayoutManager);
        ResourcesPerCountryAdapter resourcesPerCountryAdapter = new ResourcesPerCountryAdapter(getActivity());
        binding.rcvPerCountryList.setAdapter(resourcesPerCountryAdapter);

        return view;
    }
}