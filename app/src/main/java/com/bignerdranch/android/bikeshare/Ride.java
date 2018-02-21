package com.bignerdranch.android.bikeshare;

/**
 * Created by Tom on 06/02/2018.
 */

public class Ride {
    private String mBikeName, mStartRide, mEndRide;

    public Ride(String name, String start, String end) {
        mBikeName = name;
        mStartRide = start;
        mEndRide = end;
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
        if (mStartRide.equals("") && mEndRide.equals("")) // no start or end
            return "";
        else if (!mStartRide.equals("") && mEndRide.equals("")) // started but not ended
            return mBikeName + " started at " + mStartRide;
        else if (!mStartRide.equals("") && !mEndRide.equals("")) // started and ended
            return mBikeName + " started at " + mStartRide + ", ended at " + mEndRide;
        else
            return mBikeName + " ended at " + mEndRide; // ended but not started (??)
    }

    public String getEndRide() {
        return mEndRide;
    }

    public void setEndRide(String endRide) {
        mEndRide = endRide;
    }
}
