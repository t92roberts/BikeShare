package com.bignerdranch.android.bikeshare;

/**
 * Created by Tom on 06/02/2018.
 */

public class Ride {
    private String mBikeName, mStartRide, mEndRide;

    public Ride(String name, String start) {
        mBikeName = name;
        mStartRide = start;
        mEndRide = "";
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

    public String toString(String stage) {
        if (stage.equals("start"))
            return mBikeName + " started at " + mStartRide;

        if (stage.equals("end"))
            return mBikeName + " ended at " + getEndRide();

        return "Unexpected 'stage' string given to Ride toString()";
    }

    public String getEndRide() {
        return mEndRide;
    }

    public void setEndRide(String endRide) {
        mEndRide = endRide;
    }
}
