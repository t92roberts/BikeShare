package com.bignerdranch.android.bikeshare;

/**
 * Created by Tom on 06/02/2018.
 */

public class Ride {
    private String mBikeName, mStartRide;

    public Ride(String name, String start) {
        mBikeName = name;
        mStartRide = start;
    }

    public String getBikeName() {
        return mBikeName;
    }

    public void setBikeName(String bikeName) {
        mBikeName = bikeName;
    }

    public String getStartRide() {
        return mStartRide;
    }

    public void setStartRide(String startRide) {
        mStartRide = startRide;
    }

    public String toString() {
        return mBikeName + " started at " + mStartRide;
    }
}
