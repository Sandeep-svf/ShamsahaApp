package com.shamsaha.victim.fragment;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.shamsaha.R;
import com.shamsaha.databinding.FragmentEventBinding;

import java.util.ArrayList;
import java.util.List;


public class EventFragment extends Fragment {

  FragmentEventBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding= FragmentEventBinding.inflate(inflater, container, false);

//        EventMediaFragment.ViewPagerAdapter adapter = new EventMediaFragment.ViewPagerAdapter(getChildFragmentManager());
//        setupViewPager(binding.viewPager,adapter);
//        binding.toolbar.setupWithViewPager(binding.viewPager);
//        setupTabtitle();

        // Create an instance of the child fragment
        EventFragment eventFragment = new EventFragment();

        // Replace the container with the child fragment
        getChildFragmentManager().beginTransaction()
                .replace(binding.container.getId(), eventFragment)
                .commit();

        return binding.getRoot();
    }


/*    private void setupTabtitle() {

        binding.toolbar.getTabAt(0).setText(getResources().getString(R.string.volunteer));
        binding.toolbar.getTabAt(1).setText(getResources().getString(R.string.publicstring));

    }
    public static void setupViewPager(ViewPager viewPager, EventMediaFragment.ViewPagerAdapter adapter)
    {
        {
            adapter.addFragment(new VolunteerFragment());
            adapter.addFragment(new PublicFragment());
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


    }*/
}