package com.shamsaha.volunteer.view;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentHomeVolBinding;
import com.shamsaha.victim.adapter.EventMediaArticleAdapter;
import com.shamsaha.volunteer.adapter.AnouncementAdapter;
import com.shamsaha.volunteer.view.fragment.CaseVolFragment;
import com.shamsaha.volunteer.view.fragment.ChatVolFragment;


public class HomeVolFragment extends Fragment {

    private FragmentHomeVolBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeVolBinding.inflate(inflater,container,false);
        intis();

        binding.announcementTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.indicator1.setVisibility(View.VISIBLE);
                binding.indicator2.setVisibility(View.GONE);
                binding.indicator3.setVisibility(View.GONE);
                binding.announcementTab.setBackgroundResource(R.drawable.annouce_custom_bg);
                binding.chatTab.setBackgroundResource(R.color.black_them);
                binding.caseTab.setBackgroundResource(R.drawable.custom_end_corner_bg);

                binding.caotainerVol.setVisibility(View.GONE);
                binding.rcvAnouncementVol.setVisibility(View.VISIBLE);


                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
                linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
                binding.rcvAnouncementVol.setLayoutManager(linearLayoutManager);
                AnouncementAdapter anouncementAdapter = new AnouncementAdapter(getActivity());
                binding.rcvAnouncementVol.setAdapter(anouncementAdapter);

            }
        });

        binding.chatTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.indicator1.setVisibility(View.GONE);
                binding.indicator2.setVisibility(View.VISIBLE);
                binding.indicator3.setVisibility(View.GONE);
                binding.announcementTab.setBackgroundResource(R.drawable.custom_start_corner_bg);
                binding.chatTab.setBackgroundResource(R.color.pick_them);
                binding.caseTab.setBackgroundResource(R.drawable.custom_end_corner_bg);

                ChatVolFragment chatVolFragment = new ChatVolFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.caotainer_vol, chatVolFragment);
                transaction.commit();

                binding.caotainerVol.setVisibility(View.VISIBLE);
                binding.rcvAnouncementVol.setVisibility(View.GONE);
            }
        });

        binding.caseTab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.indicator1.setVisibility(View.GONE);
                binding.indicator2.setVisibility(View.GONE);
                binding.indicator3.setVisibility(View.VISIBLE);
                binding.announcementTab.setBackgroundResource(R.drawable.custom_start_corner_bg);
                binding.chatTab.setBackgroundResource(R.color.black_them);
                binding.caseTab.setBackgroundResource(R.drawable.case_custom_bg);

                CaseVolFragment caseVolFragment = new CaseVolFragment();
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.replace(R.id.caotainer_vol, caseVolFragment);
                transaction.commit();

                binding.caotainerVol.setVisibility(View.VISIBLE);
                binding.rcvAnouncementVol.setVisibility(View.GONE);
            }
        });

        return binding.getRoot();
    }

    private void intis() {
        binding.announcementTab.setBackgroundResource(R.drawable.annouce_custom_bg);
        binding.chatTab.setBackgroundResource(R.color.black_them);
        binding.caseTab.setBackgroundResource(R.drawable.custom_end_corner_bg);

        binding.caotainerVol.setVisibility(View.GONE);
        binding.rcvAnouncementVol.setVisibility(View.VISIBLE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        binding.rcvAnouncementVol.setLayoutManager(linearLayoutManager);
        AnouncementAdapter anouncementAdapter = new AnouncementAdapter(getActivity());
        binding.rcvAnouncementVol.setAdapter(anouncementAdapter);
    }
}