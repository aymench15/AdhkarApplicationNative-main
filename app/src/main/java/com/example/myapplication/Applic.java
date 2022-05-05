package com.example.myapplication;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class Applic extends Application {
    public static final String ki="channel1";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }
    public void createNotificationChannel() {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);
       // NotificationCompat.Builder builder = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel notificationChannel = new NotificationChannel(ki, "Name", importance);
            notificationManager.createNotificationChannel(notificationChannel);
          //  builder = new NotificationCompat.Builder(getApplicationContext(), notificationChannel.getId());
        }


    }

}
