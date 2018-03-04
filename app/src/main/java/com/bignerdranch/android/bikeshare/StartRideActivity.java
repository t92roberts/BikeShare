package com.bignerdranch.android.bikeshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class StartRideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ride);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_start_ride);

        if (fragment == null) {
            fragment = new StartRideFragment();
            fm.beginTransaction()
                    .add(R.id.fragment_start_ride, fragment)
                    .commit();
        }
    }

    public static Intent newIntent(Context packageContext) {
        return new Intent(packageContext, StartRideActivity.class);
    }
}
