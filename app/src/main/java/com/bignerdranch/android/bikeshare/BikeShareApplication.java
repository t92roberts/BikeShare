package com.bignerdranch.android.bikeshare;

import android.app.Application;

import io.realm.Realm;

/**
 * Created by Tom on 18/04/2018.
 */

public class BikeShareApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
