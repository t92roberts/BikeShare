package com.bignerdranch.android.bikeshare;

/**
 * Created by Tom on 30/03/2018.
 */

public class Ride {
    private String mBikeName, mStartLocation, mEndLocation;

    public Ride() {
        this.mBikeName = "";
        this.mStartLocation = "";
        this.mEndLocation = "";
    }

    public Ride(String bikeName, String startLocation) {
        this.mBikeName = bikeName;
        this.mStartLocation = startLocation;
        this.mEndLocation = "";
    }

    public Ride(String bikeName, String startLocation, String endLocation) {
        this.mBikeName = bikeName;
        this.mStartLocation = startLocation;
        this.mEndLocation = endLocation;
    }

    public String getBikeName() {
        return mBikeName;
    }

    public void setBikeName(String bikeName) {
        mBikeName = bikeName;
    }

    public String getStartLocation() {
        return mStartLocation;
    }

    public void setStartLocation(String startLocation) {
        mStartLocation = startLocation;
    }

    public String getEndLocation() {
        return mEndLocation;
    }

    public void setEndLocation(String endLocation) {
        mEndLocation = endLocation;
    }

    public String toString() {
        String message = this.mBikeName;

        if (!this.mStartLocation.equals("")) {
            message += " started at '" + this.mStartLocation + "'";
        }

        if (!this.mEndLocation.equals("")) {
            message += ", ended at '" + this.mEndLocation + "'";
        }

        return message;
    }
}
