package com.bignerdranch.android.bikeshare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Tom on 03/04/2018.
 */

public class EndRideFragment extends Fragment {
    private static RidesDB sharedRidesHistory;

    // GUI
    private Button endRide;
    private TextView lastEnded, bikeName, endLocation;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedRidesHistory = RidesDB.get(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_end_ride, container, false);

        // Top text showing the last ride ended
        lastEnded = view.findViewById(R.id.last_ride);

        // Text inputs
        bikeName = view.findViewById(R.id.text_bike_name);
        Ride activeRide = sharedRidesHistory.getActiveRide();
        if (activeRide != null) {
            bikeName.setText(activeRide.getBikeName());
        }

        endLocation = view.findViewById(R.id.text_end_location);

        // Buttons
        endRide = view.findViewById(R.id.button_end_ride);

        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String endLocationString = endLocation.getText().toString().trim();

                boolean userHasInputData = endLocationString.length() > 0;
                Ride activeRide = sharedRidesHistory.getActiveRide();

                if (userHasInputData && activeRide != null) {
                    sharedRidesHistory.endRide(endLocationString);
                    lastEnded.setText(activeRide.getBikeName() + " ended at " + endLocationString);
                }
            }
        });

        return view;
    }
}
