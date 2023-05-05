package com.shamsaha.victim.fragment;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentAboutBinding;
import com.shamsaha.databinding.FragmentArticlesBinding;
import com.shamsaha.util.GridSpacingItemDecoration;
import com.shamsaha.victim.adapter.AboutAdvisoryBoardAdapter;
import com.shamsaha.victim.adapter.EventMediaPhotoAdapter;

public class AboutFragment extends Fragment {

    FragmentAboutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater, container, false);

        RecyclerView.LayoutManager topLayoutManager = new GridLayoutManager(getActivity(), 3);
        binding.rcvAdvisoryBoard.setLayoutManager(topLayoutManager);
        binding.rcvAdvisoryBoard.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(8), true));
        binding.rcvAdvisoryBoard.setItemAnimator(new DefaultItemAnimator());
        binding.rcvAdvisoryBoard.setLayoutManager(topLayoutManager);
        AboutAdvisoryBoardAdapter aboutAdvisoryBoardAdapter = new AboutAdvisoryBoardAdapter(getActivity());
        binding.rcvAdvisoryBoard.setAdapter(aboutAdvisoryBoardAdapter);

        return binding.getRoot();
    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}