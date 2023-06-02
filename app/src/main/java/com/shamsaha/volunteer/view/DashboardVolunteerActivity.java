package com.shamsaha.volunteer.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.shamsaha.R;

public class DashboardVolunteerActivity extends AppCompatActivity {

    ConstraintLayout container_volunteer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_volunteer);

        HomeVolFragment homeVolFragment = new HomeVolFragment();
        replace_fragment(homeVolFragment);
    }

    private void inits() {
        container_volunteer = findViewById(R.id.container_volunteer);
    }

    private void replace_fragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        ((ConstraintLayout) findViewById(R.id.container_volunteer)).removeAllViews();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
        fragmentTransaction.add(R.id.container_volunteer, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}