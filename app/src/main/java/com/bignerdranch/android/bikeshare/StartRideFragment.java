package com.bignerdranch.android.bikeshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Tom on 04/03/2018.
 */

public class StartRideFragment extends Fragment {
    // GUI variables
    private Button addRide;
    private TextView lastAdded;
    private EditText newWhat, newWhere;

    private static RidesDB ridesDB;
    private Ride last = new Ride("", "", "");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_start_ride, container, false);
        ridesDB = RidesDB.get(getContext());

        lastAdded = v.findViewById(R.id.last_ride);
        updateUI();

        // Button
        addRide = v.findViewById(R.id.add_button);

        // Texts
        newWhat = v.findViewById(R.id.what_text);
        newWhere = v.findViewById(R.id.where);

        // view products click event
        addRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((newWhat.getText().length() > 0) && (newWhere.getText().length() > 0)) {
                    String bikeName = newWhat.getText().toString().trim();
                    String where = newWhere.getText().toString().trim();

                    ridesDB.addRide(bikeName, where);

                    last.setBikeName(bikeName);
                    last.setStartRide(where);

                    // reset text fields
                    newWhat.setText("");
                    newWhere.setText("");
                    updateUI();
                }
            }
        });

        return v;
    }

    private void updateUI() {
        lastAdded.setText(last.toString());
    }
}
