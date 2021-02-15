package com.example.sbs.myapplication.util;

import android.app.Application;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.sbs.myapplication.ui.MainActivity;
import com.example.sbs.myapplication.R;

public class Util {
    private static Application application;
    private static NavController navController;

    public static void init(Application application) {
        Util.application = application;
    }

    public static float dipToPixels(int borderRadius) {
        DisplayMetrics metrics = application.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, borderRadius, metrics);
    }

    public static void log(String msg) {
        Log.d("AA1", msg);
    }

    public static NavController getMainNavController(MainActivity activity) {
        if (Util.navController == null) {
            navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
        }

        return navController;
    }

    public static void toast(String msg) {
        Toast.makeText(application, msg, Toast.LENGTH_SHORT).show();
    }
}
