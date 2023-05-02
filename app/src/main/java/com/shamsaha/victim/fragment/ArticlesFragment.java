package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentArticlesBinding;


public class ArticlesFragment extends Fragment {


    FragmentArticlesBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentArticlesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();




        return  view;
    }
}