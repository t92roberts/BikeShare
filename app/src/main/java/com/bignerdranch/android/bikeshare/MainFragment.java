package com.bignerdranch.android.bikeshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by Tom on 03/03/2018.
 */

public class MainFragment extends Fragment {
    // GUI variables
    private Button addRide, endRide;
    private static RidesDB ridesDB;
    private ArrayAdapter<Ride> listAdapter;
    private ListView mainListView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ridesDB = RidesDB.get(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main, container, false);

        // Buttons
        addRide = v.findViewById(R.id.navigate_add_button);
        endRide = v.findViewById(R.id.navigate_end_button);

        // click event - navigate to add ride
        addRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = StartRideActivity.newIntent(getContext());
                startActivity(intent);
            }
        });

        // click event - navigate to end ride
        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = EndRideActivity.newIntent(getContext());
                startActivity(intent);
            }
        });

        listAdapter = new ArrayAdapter<>(getContext(), R.layout.list_item, ridesDB.getRidesDB());
        mainListView = v.findViewById(R.id.mainListView);
        mainListView.setAdapter(listAdapter);

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mainListView.setAdapter(listAdapter);
    }
}
