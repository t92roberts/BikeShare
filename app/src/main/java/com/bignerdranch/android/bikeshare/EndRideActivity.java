package com.bignerdranch.android.bikeshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EndRideActivity extends AppCompatActivity {

    // GUI variables
    private Button endRide;
    private TextView lastAdded;
    private EditText newWhat, newWhere;

    private static RidesDB ridesDB;
    private Ride last = new Ride("", "", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_ride);

        ridesDB = RidesDB.get(this);

        lastAdded = findViewById(R.id.last_ride);
        updateUI();

        // Button
        endRide = findViewById(R.id.end_button);

        // Texts
        newWhat = findViewById(R.id.what_text);
        newWhere = findViewById(R.id.where);

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
    }

    private void updateUI() {
        lastAdded.setText(last.toString());
    }

    public static Intent newIntent(Context packageContext) {
        return new Intent(packageContext, EndRideActivity.class);
    }
}
