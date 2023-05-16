package com.shamsaha.victim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.PopupWindow;

import com.shamsaha.R;
import com.shamsaha.databinding.ActivityMainBinding;
import com.shamsaha.util.ImageUtils;
import com.shamsaha.victim.fragment.AboutFragment;
import com.shamsaha.victim.fragment.ChatFragment;
import com.shamsaha.victim.fragment.ContactUsFragment;
import com.shamsaha.victim.fragment.EventMediaFragment;
import com.shamsaha.victim.fragment.GetInvolveFragment;
import com.shamsaha.victim.fragment.HomeFragment;
import com.shamsaha.victim.fragment.LockAppFragment;
import com.shamsaha.victim.fragment.ResourcesFragment;
import com.shamsaha.volunteer.VolunteerLoginFragment;

public class DashboardVictimActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Animation animFadeIn, animSlideIn, animSlideInTop,animMoveUp,animMoveDown;
    Boolean menuFlag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        set_animation();




        binding.homeVictimLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeFragment homeFragment = new HomeFragment();
                replace_fragment(homeFragment);
            }
        });


        binding.volLoginLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VolunteerLoginFragment volunteerLoginFragment = new VolunteerLoginFragment();
                replace_fragment(volunteerLoginFragment);
            }
        });

        binding.resourcesVictimLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResourcesFragment resourcesFragment = new ResourcesFragment();
                replace_fragment(resourcesFragment);
            }
        });
        binding.chatVictimLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatFragment chatFragment = new ChatFragment();
                replace_fragment(chatFragment);
            }
        });
        binding.aboutShamsahaMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AboutFragment aboutFragment = new AboutFragment();
                replace_fragment(aboutFragment);
                binding.menuLayout.setVisibility(View.GONE);
                menuFlag = false;
            }
        });

        binding.getInvolvedMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GetInvolveFragment getInvolveFragment = new GetInvolveFragment();
                replace_fragment(getInvolveFragment);
                binding.menuLayout.setVisibility(View.GONE);
                menuFlag = false;
            }
        });

        binding.eventMediaMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventMediaFragment eventMediaFragment = new EventMediaFragment();
                replace_fragment(eventMediaFragment);
                binding.menuLayout.setVisibility(View.GONE);
                menuFlag = false;
            }
        });


        binding.contactUsMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactUsFragment contactUsFragment = new ContactUsFragment();
                replace_fragment(contactUsFragment);
                binding.menuLayout.setVisibility(View.GONE);
                menuFlag = false;
            }
        });

        binding.lockAppMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LockAppFragment lockAppFragment = new LockAppFragment();
                replace_fragment(lockAppFragment);
                binding.menuLayout.setVisibility(View.GONE);
                menuFlag = false;
            }
        });

        binding.termConditionMenuLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.menuVictimLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  manualcodePopup();
                if(menuFlag.booleanValue()==false){
                    binding.menuLayout.setVisibility(View.VISIBLE);
                    binding.menuLayout.setAnimation(animMoveUp);
                    menuFlag = true;
                }else{
                    binding.menuLayout.setVisibility(View.GONE);
                    binding.menuLayout.setAnimation(animMoveDown);
                    menuFlag = false;
                }

            }
        });




    }
    private void set_animation() {
        animSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animSlideInTop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top_custom);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);
        animMoveUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animMoveDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
    }

    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.add(R.id.container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void manualcodePopup() {

        View customView = getLayoutInflater().inflate(R.layout.manualcode_layout, null);
       /* ImageView close = customView.findViewById(R.id.close);
        close.setAnimation(animSlideIn);*/
        //btnMenu.setAnimation(animSlideInTop);
        int width = 900;
        int height = 900;

       // int height = 0;
        try {
            WindowManager wm = (WindowManager) customView.getContext().getSystemService(Context.WINDOW_SERVICE);
            //int width = wm.getDefaultDisplay().getWidth();
            //height = wm.getDefaultDisplay().getHeight();
        } catch (Exception e) {
            e.printStackTrace();
        }
        PopupWindow popupWindow = new PopupWindow(customView, ViewGroup.LayoutParams.WRAP_CONTENT, (int) (height * 1 / 1.14), true);
        popupWindow.setAnimationStyle(R.style.popup_window_animation);
        popupWindow.showAtLocation(customView, Gravity.BOTTOM, 40, 60);
        popupWindow.setWidth(width*3/6);
        popupWindow.setHeight(height*3/8);

    /*    close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupWindow.dismiss();
            }
        });*/
    }
}