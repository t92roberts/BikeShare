package com.bignerdranch.android.bikeshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class BikeShareActivity extends AppCompatActivity {
    // GUI variables
    private Button addRide, endRide, listRides;
    private static RidesDB ridesDB;
    private ArrayAdapter<Ride> listAdaper;
    private ListView mainListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bike_share);

        ridesDB = RidesDB.get(this);

        // Buttons
        addRide = findViewById(R.id.navigate_add_button);
        endRide = findViewById(R.id.navigate_end_button);
        listRides = findViewById(R.id.list_rides_button);

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

        // click event - list rides
        listRides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainListView.setAdapter(listAdaper);
            }
        });

        listAdaper = new ArrayAdapter<>(this, R.layout.list_item, ridesDB.getRidesDB());
        mainListView = findViewById(R.id.mainListView);
        mainListView.setAdapter(listAdaper);
    }
}
