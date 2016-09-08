package com.example.vopolski.myleakcanary;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;
import android.app.Application;

public class MainActivity extends AppCompatActivity {

    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rightWay();


    }

    private void rightWay() {
        new MyThread().start();
    }

    private class MyThread extends Thread {
        @Override
        public void run() {
            while (true) {
                SystemClock.sleep(1000);
            }
        }
    }

    private void wrongWay() {
        new Thread() {
            @Override
            public void run() {
                while (true){
                    SystemClock.sleep(1000);
                }
            }
        }.start();
    }
}
