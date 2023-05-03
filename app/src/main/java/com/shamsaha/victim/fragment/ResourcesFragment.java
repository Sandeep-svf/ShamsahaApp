package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.shamsaha.R;

import java.util.ArrayList;
import java.util.List;


public class ResourcesFragment extends Fragment {

    ViewPager viewPager;
    TabLayout toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_resources, container, false);
        intis(view);
        EventMediaFragment.ViewPagerAdapter adapter = new EventMediaFragment.ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(viewPager,adapter);
        toolbar.setupWithViewPager(viewPager);
        setupTabtitle();



        return  view;
    }


    private void setupTabtitle() {
        toolbar.getTabAt(0).setText(getResources().getString(R.string.per_country));
        toolbar.getTabAt(1).setText(getResources().getString(R.string.servival_suppoer_tool));
    }

    public static void setupViewPager(ViewPager viewPager, EventMediaFragment.ViewPagerAdapter adapter)
    {
        {
            adapter.addFragment(new PerCountryFragment());
            adapter.addFragment(new SurvivorSupportToolsFragment());

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

    private void intis(View view) {
    viewPager = view.findViewById(R.id.view_pager_resources);
    toolbar = view.findViewById(R.id.toolbar_resources);
    }
}