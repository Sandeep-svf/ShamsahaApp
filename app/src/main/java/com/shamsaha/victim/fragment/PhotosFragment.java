package com.shamsaha.victim.fragment;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentPhotosBinding;
import com.shamsaha.util.GridSpacingItemDecoration;
import com.shamsaha.victim.adapter.EventMediaPhotoAdapter;


public class PhotosFragment extends Fragment {



    FragmentPhotosBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentPhotosBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        RecyclerView.LayoutManager topLayoutManager = new GridLayoutManager(getActivity(), 2);
        binding.rcvPhotoList.setLayoutManager(topLayoutManager);
        binding.rcvPhotoList.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(8), true));
        binding.rcvPhotoList.setItemAnimator(new DefaultItemAnimator());
        binding.rcvPhotoList.setLayoutManager(topLayoutManager);
        EventMediaPhotoAdapter eventMediaPhotoAdapter = new EventMediaPhotoAdapter(getActivity());
        binding.rcvPhotoList.setAdapter(eventMediaPhotoAdapter);


        return view;
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}