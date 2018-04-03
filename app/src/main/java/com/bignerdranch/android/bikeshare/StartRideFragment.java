package com.bignerdranch.android.bikeshare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tom on 30/03/2018.
 */

public class StartRideFragment extends Fragment {

    private static RidesDB sharedRidesHistory;

    // GUI
    private Button startRide;
    private TextView lastAdded;
    private TextView bikeName, startLocation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedRidesHistory = RidesDB.get(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_ride, container, false);

        // Top text showing the last ride started
        lastAdded = view.findViewById(R.id.last_ride);

        // Text inputs
        bikeName = view.findViewById(R.id.text_bike_name);
        startLocation = view.findViewById(R.id.text_start_location);

        // Buttons
        startRide = view.findViewById(R.id.button_start_ride);

        startRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bikeNameString = bikeName.getText().toString().trim();
                String startLocationString = startLocation.getText().toString().trim();

                boolean userHasInputData = bikeNameString.length() > 0 && startLocationString.length() > 0;

                if (userHasInputData) {
                    sharedRidesHistory.startRide(bikeNameString, startLocationString);
                    lastAdded.setText(bikeNameString + " started at " + startLocationString);
                }
            }
        });

        return view;
    }
}
