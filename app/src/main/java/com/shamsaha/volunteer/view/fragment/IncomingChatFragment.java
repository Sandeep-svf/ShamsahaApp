package com.shamsaha.volunteer.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentIncomingChatBinding;


public class IncomingChatFragment extends Fragment {

    private FragmentIncomingChatBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentIncomingChatBinding.inflate(inflater,container,false);





        return binding.getRoot();
    }
}