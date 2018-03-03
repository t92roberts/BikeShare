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

    public boolean endRide(String what, String where) {
        // find the ride that is ending
        // (starting from the most recently-added ride, searching backwards)
        for (int i = mAllRides.size() - 1; i >= 0; --i) {
            Ride ride = mAllRides.get(i);

            if (ride.getBikeName().equals(what) && ride.getEndRide().equals("")) {
                ride.setEndRide(where);
                return true;
            }
        }

        // the ride being ended hadn't been started
        return false;
    }

    private RidesDB(Context context) {
        mAllRides = new ArrayList<>();

        // Add some test rides
        mAllRides.add(new Ride("Jimmy's bike", "ITU", "Nørreport"));
        mAllRides.add(new Ride("Dave's bike", "Nørreport", "ITU"));
    }
}
