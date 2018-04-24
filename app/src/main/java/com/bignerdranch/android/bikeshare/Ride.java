package com.bignerdranch.android.bikeshare;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;

/**
 * Created by Tom on 30/03/2018.
 */

public class Ride extends RealmObject {

    private String mRideID;

    private String mBikeName;

    private String mStartLocation;
    private Date mStartTime;

    private String mEndLocation;
    private Date mEndTime;

    private static String DATE_FORMAT_PATTERN = "EEE dd MMMM yyyy";
    private static String TIME_FORMAT_PATTERN = "HH:mm:ss";

    public Ride() {
        this.mRideID = UUID.randomUUID().toString();
    }

    public void startRide(String bikeName, String startLocation) {
        this.mBikeName = bikeName;

        this.mStartLocation = startLocation;
        this.mStartTime = new Date();
    }

    public void endRide(String endLocation) {
        this.mEndLocation = endLocation;
        this.mEndTime = new Date();
    }

    public String getBikeName() {
        return mBikeName;
    }

    public String getStartLocation() {
        return mStartLocation;
    }

    public String getFormattedStartDate() {
        return new SimpleDateFormat(DATE_FORMAT_PATTERN).format(mStartTime);
    }

    public String getFormattedStartTime() {
        return new SimpleDateFormat(TIME_FORMAT_PATTERN).format(mStartTime);
    }

    public String getFormattedStartDateTime() {
        return new SimpleDateFormat(DATE_FORMAT_PATTERN + ' ' +TIME_FORMAT_PATTERN).format(mStartTime);
    }

    public String getEndLocation() {
        return mEndLocation;
    }

    public String getFormattedEndDate() {
        return new SimpleDateFormat(DATE_FORMAT_PATTERN).format(mEndTime);
    }

    public String getFormattedEndTime() {
        return new SimpleDateFormat(TIME_FORMAT_PATTERN).format(mEndTime);
    }

    public String getFormattedEndDateTime() {
        return new SimpleDateFormat(DATE_FORMAT_PATTERN + ' ' + TIME_FORMAT_PATTERN).format(mEndTime);
    }

    public String toString() {
        String message = this.mBikeName;

        if (this.mStartLocation != null) {
            message += " started at '" + this.mStartLocation + "' (" + getFormattedStartDateTime() + ')';
        }

        if (this.mEndLocation != null) {
            message += ", ended at '" + this.mEndLocation + "' (" + getFormattedEndDateTime() + ')';
        }

        return message;
    }
}
