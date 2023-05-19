package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentArticlesBinding;
import com.shamsaha.victim.adapter.ResourcesSST;


public class ArticlesFragment extends Fragment {


    FragmentArticlesBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentArticlesBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

       /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rcvArticle.setLayoutManager(linearLayoutManager);
        ResourcesSST resourcesSST = new ResourcesSST(getActivity());
        binding.rcvArticle.setAdapter(resourcesSST);*/

        return  view;
    }
}