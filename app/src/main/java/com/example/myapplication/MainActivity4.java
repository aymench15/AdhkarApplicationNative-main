package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import androidx.core.app.NotificationCompat;
import androidx.annotation.NonNull;
import android.app.NotificationChannel;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;


public class MainActivity4 extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        NotificationManager notificationManager = (NotificationManager) this.getSystemService(this.NOTIFICATION_SERVICE);
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while(true){

                            NotificationCompat.Builder builder = null;
                            builder = new NotificationCompat.Builder(getApplicationContext(),Applic.ki);

                            builder = builder
                                    .setSmallIcon(R.drawable.adkaricon)

                                    .setContentTitle("اذكاري")
                                    .setContentText("dddddddd")
                                    .setDefaults(Notification.DEFAULT_ALL)
                                    .setAutoCancel(true);

                            notificationManager.notify(1, builder.build());
                            try{
                            Thread.sleep(2000);
                            }catch (InterruptedException e){
                                e.printStackTrace();
                            }
                        }
                    }
                }


        ).start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}