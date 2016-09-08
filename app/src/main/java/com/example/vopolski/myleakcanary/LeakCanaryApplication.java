package com.example.vopolski.myleakcanary;

import android.app.Application;
import android.content.Context;
import android.os.SystemClock;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

public class LeakCanaryApplication extends Application {

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        LeakCanaryApplication application =
                (LeakCanaryApplication) context.getApplicationContext();
        return application.refWatcher;
    }
}
