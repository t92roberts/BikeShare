package com.bignerdranch.android.bikeshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BikeShareActivity extends AppCompatActivity {
    // GUI variables
    private Button addRide, endRide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_share);

        // Buttons
        addRide = findViewById(R.id.navigate_add_button);
        endRide = findViewById(R.id.navigate_end_button);

        // click event - navigate to add ride
        addRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = StartRideActivity.newIntent(BikeShareActivity.this);
                startActivity(intent);
            }
        });

        // click event - navigate to end ride
        endRide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = EndRideActivity.newIntent(BikeShareActivity.this);
                startActivity(intent);
            }
        });
    }
}
