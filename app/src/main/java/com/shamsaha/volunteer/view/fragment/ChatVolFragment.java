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
import com.shamsaha.databinding.FragmentAnouncementBinding;
import com.shamsaha.victim.fragment.EventMediaFragment;
import com.shamsaha.victim.fragment.PublicFragment;
import com.shamsaha.victim.fragment.VolunteerFragment;

import java.util.ArrayList;
import java.util.List;


public class ChatVolFragment extends Fragment {

FragmentAnouncementBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAnouncementBinding.inflate(inflater,container,false);

       ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        setupViewPager(binding.viewPager,adapter);
        binding.toolbar.setupWithViewPager(binding.viewPager);
        setupTabtitle();



        return binding.getRoot();
    }

    private void setupTabtitle() {

        binding.toolbar.getTabAt(0).setText(getResources().getString(R.string.incoming_chats));
        binding.toolbar.getTabAt(1).setText(getResources().getString(R.string.past_chats));

    }
    public static void setupViewPager(ViewPager viewPager, ViewPagerAdapter adapter)
    {
        {
            adapter.addFragment(new IncomingChatFragment());
            adapter.addFragment(new PastChatFragment());
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