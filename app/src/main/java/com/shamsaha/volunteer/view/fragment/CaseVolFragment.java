package com.shamsaha.volunteer.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentCaseVolBinding;

import java.util.ArrayList;
import java.util.List;


public class CaseVolFragment extends Fragment {

    FragmentCaseVolBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCaseVolBinding.inflate(inflater,container,false);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(binding.viewPager,adapter);
        binding.toolbar.setupWithViewPager(binding.viewPager);
        setupTabtitle();

        return binding.getRoot();
    }

    private void setupTabtitle() {

        binding.toolbar.getTabAt(0).setText(getResources().getString(R.string.cases));
        binding.toolbar.getTabAt(1).setText(getResources().getString(R.string.case_reports));

    }
    public static void setupViewPager(ViewPager viewPager, ViewPagerAdapter adapter)
    {
        {
            adapter.addFragment(new CaseFragment());
            adapter.addFragment(new CaseReportFragment());
        }

        viewPager.setAdapter(adapter);
    }
    static class ViewPagerAdapter extends FragmentPagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment) {
            mFragmentList.add(fragment);
        }


    }
}