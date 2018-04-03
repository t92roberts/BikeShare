package com.bignerdranch.android.bikeshare;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Created by Tom on 30/03/2018.
 */

public class RidesDB extends Observable {
    private static RidesDB sRidesDB;

    private List<Ride> mRidesHistory;

    private RidesDB (Context context) {
        // the singleton hasn't been created yet, create an empty list of rides
        mRidesHistory = new ArrayList<>();

        // Add some test rides
        addFullRide(new Ride("Jimmy's bike", "ITU", "Nørreport"));
        addFullRide(new Ride("Dave's bike", "Nørreport", "ITU"));

    }

    public synchronized static RidesDB get(Context context) {
        if (sRidesDB == null) {
            // singleton hasn't been created yet
            sRidesDB = new RidesDB(context);
        }

        return sRidesDB;
    }

    private synchronized void addToRideHistory(Ride ride) {
        this.mRidesHistory.add(ride);

        // Observer pattern - notify observers
        this.setChanged();
        notifyObservers();
    }

    public synchronized void startRide(String bikeName, String startLocation) {
        Ride newRide = new Ride(bikeName, startLocation);
        addToRideHistory(newRide);
    }

    public synchronized void addFullRide (Ride newRide) {
        addToRideHistory(newRide);
    }

    public synchronized boolean endRide(String bikeName, String endLocation) {
        // find the ride
        for (int i = 0; i < mRidesHistory.size(); ++i) {
            Ride ride = mRidesHistory.get(i);
            if (ride.getBikeName().equals(bikeName) && ride.getEndLocation().equals("")) {
                mRidesHistory.get(i).setEndLocation(endLocation);

                // Observer pattern - notify observers
                this.setChanged();
                notifyObservers();

                return true; // ride successfully ended
            }
        }

        return false; // could not find the given bike
    }

    public synchronized List<Ride> getRidesHistory() {
        return mRidesHistory;
    }
}
