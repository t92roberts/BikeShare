package com.bignerdranch.android.bikeshare;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Tom on 06/02/2018.
 */

public class Ride {
    private String mBikeName, mStartRide, mEndRide;
    private Date mStartTime, mEndTime;
    private String dateFormat = "EEEE, dd MMMM, yyyy";
    private String timeFormat = "HH:mm:ss";

    public Ride(String name, String start, String end) {
        mBikeName = name;
        mStartRide = start;
        mEndRide = end;
        mStartTime = new Date();
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
            return mBikeName + " started at " + mStartRide
                    + " on " + getStartTime(dateFormat)
                    + " at " + getStartTime(timeFormat);
        else if (!mStartRide.equals("") && !mEndRide.equals("")) // started and ended
            return mBikeName + " started at " + mStartRide
                    + " on " + getStartTime(dateFormat)
                    + " at " + getStartTime(timeFormat)
                    + ", ended at " + mEndRide
                    + " on " + getEndTime(dateFormat)
                    + " at " + getEndTime(timeFormat);
        else
            return mBikeName + " ended at " + mEndRide
                    + " on " + getEndTime(dateFormat)
                    + " at " + getEndTime(timeFormat); // ended but not started (??)
    }

    public String getEndRide() {
        return mEndRide;
    }

    public void setEndRide(String endRide) {
        mEndRide = endRide;
        mEndTime = new Date();
    }

    public String getStartTime(String pattern) {
        return new SimpleDateFormat(pattern).format(mStartTime);
    }

    public String getEndTime(String pattern) {
        return new SimpleDateFormat(pattern).format(mEndTime);
    }
}
