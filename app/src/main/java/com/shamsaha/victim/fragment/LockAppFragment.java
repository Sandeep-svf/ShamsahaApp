package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentLockAppBinding;


public class LockAppFragment extends Fragment {

    FragmentLockAppBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLockAppBinding.inflate(inflater,container,false);







        return binding.getRoot();
    }
}