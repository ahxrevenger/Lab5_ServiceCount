package com.example.user.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate() {
        new Thread() {
            boolean flag = true;
            int count = 0;

            public void run() {
                while (flag) {
                    Intent i = new Intent("MyMessage");
                    i.putExtra("bs", count);
                    sendBroadcast(i);
                    count++;
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}




