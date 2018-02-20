package com.bignerdranch.android.bikeshare;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom on 20/02/2018.
 */

public class RidesDB {
    private static RidesDB sRidesDB;

    public static RidesDB get(Context context) {
        if (sRidesDB == null) sRidesDB = new RidesDB(context);
        return sRidesDB;
    }

    private ArrayList<Ride> mAllRides;
    private Ride mLastRide = new Ride("", "", "");

    public List<Ride> getRidesDB() {
        return mAllRides;
    }

    public void addRide(String what, String where) {
        mAllRides.add(new Ride(what, where, ""));
    }

    public void endRide(String what, String where) {
        mAllRides.add(new Ride(what, "", where));
    }

    private RidesDB(Context context) {
        mAllRides = new ArrayList<>();

        // Add some test rides
        mAllRides.add(new Ride("Tom's bike", "ITU", "Nørreport"));
        mAllRides.add(new Ride("Dave's bike", "Nørreport", "ITU"));
    }
}
