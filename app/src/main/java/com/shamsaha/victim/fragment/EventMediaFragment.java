package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentEventMediaBinding;

import java.util.ArrayList;
import java.util.List;


public class EventMediaFragment extends Fragment {

    FragmentEventMediaBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding =  FragmentEventMediaBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(binding.viewPager,adapter);
        binding.toolbar.setupWithViewPager(binding.viewPager);
        setupTabtitle();

        return view;
    }
    private void setupTabtitle() {

        binding.toolbar.getTabAt(0).setText(getResources().getString(R.string.photo));
        binding.toolbar.getTabAt(1).setText(getResources().getString(R.string.articles));

    }
    public static void setupViewPager(ViewPager viewPager, ViewPagerAdapter adapter)
    {
        {
            adapter.addFragment(new PhotosFragment());
            adapter.addFragment(new ArticlesFragment());
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