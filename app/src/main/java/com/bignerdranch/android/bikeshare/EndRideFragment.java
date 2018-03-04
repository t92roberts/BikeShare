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
 * Created by Tom on 03/03/2018.
 */

public class EndRideFragment extends Fragment {

    // GUI variables
    private Button endRide;
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
        View v = inflater.inflate(R.layout.fragment_end_ride, container, false);
        ridesDB = RidesDB.get(getContext());

        lastAdded = v.findViewById(R.id.last_ride);
        updateUI();

        // Button
        endRide = v.findViewById(R.id.end_button);

        // Texts
        newWhat = v.findViewById(R.id.what_text);
        newWhere = v.findViewById(R.id.where);

        // view products click event
        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((newWhat.getText().length() > 0) && (newWhere.getText().length() > 0)) {
                    String bikeName = newWhat.getText().toString().trim();
                    String where = newWhere.getText().toString().trim();

                    if (ridesDB.endRide(bikeName, where)) {
                        last.setBikeName(bikeName);
                        last.setEndRide(where);
                        updateUI();
                    } else {
                        String message = bikeName + " " + getString(R.string.bike_not_found);
                        lastAdded.setText(message);
                    }

                    // reset text fields
                    newWhat.setText("");
                    newWhere.setText("");
                }
            }
        });

        return v;
    }

    private void updateUI() {
        lastAdded.setText(last.toString());
    }

    public static Intent newIntent(Context packageContext) {
        return new Intent(packageContext, EndRideActivity.class);
    }
}
