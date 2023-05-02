package com.shamsaha.victim;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ListPopupWindow;
import android.widget.PopupWindow;

import com.shamsaha.R;
import com.shamsaha.databinding.ActivityMainBinding;
import com.shamsaha.victim.fragment.ChatFragment;
import com.shamsaha.victim.fragment.HomeFragment;

public class DashboardVictimActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Animation animFadeIn, animSlideIn, animSlideInTop;

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

        binding.chatVictimLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatFragment chatFragment = new ChatFragment();
                replace_fragment(chatFragment);
            }
        });

        binding.menuVictimLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manualcodePopup();
            }
        });




    }
    private void set_animation() {
        animSlideIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
        animSlideInTop = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_in_top_custom);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);


    }
    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ((ConstraintLayout) findViewById(R.id.container)).removeAllViews();
        androidx.fragment.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragment);
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