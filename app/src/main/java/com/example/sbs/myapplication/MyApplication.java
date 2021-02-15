package com.example.sbs.myapplication;

import android.app.Application;

import com.example.sbs.myapplication.util.Util;
import com.facebook.stetho.Stetho;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        Util.init(this);
    }
}
