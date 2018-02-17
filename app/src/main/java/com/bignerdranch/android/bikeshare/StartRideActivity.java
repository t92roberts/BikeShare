package com.bignerdranch.android.bikeshare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartRideActivity extends AppCompatActivity {

    // GUI variables
    private Button addRide;
    private TextView lastAdded;
    private EditText newWhat, newWhere;

    private Ride last = new Ride("", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_ride);

        lastAdded = findViewById(R.id.last_ride);
        updateUI();

        // Button
        addRide = findViewById(R.id.add_button);

        // Texts
        newWhat = findViewById(R.id.what_text);
        newWhere = findViewById(R.id.where);

        // view products click event
        addRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((newWhat.getText().length() > 0) && (newWhere.getText().length() > 0)) {
                    last.setBikeName(newWhat.getText().toString().trim());
                    last.setStartRide(newWhere.getText().toString().trim());

                    // reset text fields
                    newWhat.setText("");
                    newWhere.setText("");
                    updateUI();
                }
            }
        });
    }

    private void updateUI() {
        lastAdded.setText(last.toString("start"));
    }

    public static Intent newIntent(Context packageContext) {
        return new Intent(packageContext, StartRideActivity.class);
    }
}