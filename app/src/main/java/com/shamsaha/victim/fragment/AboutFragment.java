package com.shamsaha.victim.fragment;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
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

       /* RecyclerView.LayoutManager topLayoutManager = new GridLayoutManager(getActivity(), 3);
        binding.rcvAdvisoryBoard.setLayoutManager(topLayoutManager);
        binding.rcvAdvisoryBoard.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(8), true));
        binding.rcvAdvisoryBoard.setItemAnimator(new DefaultItemAnimator());
        binding.rcvAdvisoryBoard.setLayoutManager(topLayoutManager);
        AboutAdvisoryBoardAdapter aboutAdvisoryBoardAdapter = new AboutAdvisoryBoardAdapter(getActivity());
        binding.rcvAdvisoryBoard.setAdapter(aboutAdvisoryBoardAdapter);*/

        runthread();
        runthread1();




        return binding.getRoot();
    }
    private void runthread1() {
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

              /*  int n=0;
                for(int i=5000;i>n;i--){
                   Log.e("test_sam", String.valueOf(i)+"Second");
                }*/
                // about data api
                about_api();
            }
        });
        thread2.start();
    }


    private void runthread() {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
/*
                int n=5000;
               for(int i=0;i<n;i++){
                    Log.e("test_sam", String.valueOf(i)+"First");
                }*/

                // board member api
                board_member();

            }
        });
        thread.start();
}

    private void board_member() {

    }

    private void about_api() {

    }
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }
}