package com.bignerdranch.android.bikeshare;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {
    private static RidesDB sharedRidesHistory;

    // GUI
    private Button startRide, endRide, mainMenu;

    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedRidesHistory = RidesDB.get(this);

        // Buttons
        startRide = findViewById(R.id.start_ride_button);
        endRide = findViewById(R.id.end_ride_button);
        mainMenu = findViewById(R.id.main_menu_button);

        startRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpFragment(new StartRideFragment(), R.id.fragment_list_container);
            }
        });

        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpFragment(new EndRideFragment(), R.id.fragment_list_container);
            }
        });

        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            recreate(); // restart the activity
            }
        });

        setUpFragment(new ListFragment(), R.id.fragment_list_container);
    }

    private void setUpFragment(Fragment newFragment, int res) {
        Fragment fragment = fm.findFragmentById(res);

        if (fragment == null) {
            // Fragment is not already active
            fragment = newFragment;

            fm.beginTransaction()
                    .add(res, fragment)
                    .commit();
        } else {
            // Fragment is also active
            // Remove it before inserting the new one
            fm.beginTransaction()
                    .remove(fragment)
                    .add(res, newFragment)
                    .commit();
        }
    }
}
