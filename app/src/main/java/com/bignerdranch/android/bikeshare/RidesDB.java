package com.bignerdranch.android.bikeshare;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Tom on 30/03/2018.
 */

public class RidesDB extends Observable {
    private static RidesDB sRidesDB;
    private static Realm realm;

    private Ride mActiveRide;

    private RidesDB (Context context) {
        // the singleton hasn't been created yet, create an empty list of rides
        realm = Realm.getDefaultInstance();
    }

    public synchronized static RidesDB get(Context context) {
        if (sRidesDB == null) {
            // singleton hasn't been created yet
            sRidesDB = new RidesDB(context);
        }

        return sRidesDB;
    }

    public Ride getActiveRide() {
        return mActiveRide;
    }

    public synchronized void startRide(String bikeName, String startLocation) {
        // Don't persist it in the database yet - temporarily store the
        // information about the current ride in this singleton
        if (mActiveRide == null) {
            mActiveRide = new Ride();
            mActiveRide.startRide(bikeName, startLocation);

            this.setChanged();
            notifyObservers();
        }
    }

    public synchronized void endRide(String endLocation) {
        if (mActiveRide != null) {
            mActiveRide.endRide(endLocation);

            addFullRide(mActiveRide);
            mActiveRide = null;

            this.setChanged();
            notifyObservers();
        }
    }

    public synchronized void addFullRide (Ride newRide) {
        final Ride fRide = newRide;

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealm(fRide);
            }
        });

        this.setChanged();
        notifyObservers();
    }

    public synchronized List<Ride> getRidesDB() {
        return realm.where(Ride.class).findAll();
    }

    public void delete(String id) {
        final String fID = id;

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<Ride> rows = realm.where(Ride.class)
                        .equalTo("mBikeName", fID)
                        .findAll();

                if (rows.size() > 0) {
                    rows.get(0).deleteFromRealm();
                }
            }
        });

        this.setChanged();
        notifyObservers();
    }
}
