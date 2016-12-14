package com.example.x1243.littlethings;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by x1243 on 12/12/2016.
 */

public class RingtonePlayingService extends Service {

    MediaPlayer media_song;
    private boolean isRunning;
    private int startId;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("LocalService", "Received start id " + startId + ": " + intent);

        String state = intent.getExtras().getString("extra");

        Log.e("Ringtone state is", state);




        assert state !=null;
        switch (state) {
            case "alarm on":
                startId = 1;
                break;
            case "alarm off":
                startId = 0;
                Log.e("Start ID is", state);
                break;
            default:
                startId = 0;
                break;
        }



        if (!this.isRunning && startId == 1) {
            Log.e("There is no music,", "and you want start");

            media_song = MediaPlayer.create(this, R.raw.alarm);
            media_song.start();

            this.isRunning = true;
            this.startId = 0;

            NotificationManager notify_manager = (NotificationManager)
                    getSystemService(NOTIFICATION_SERVICE);
            Intent intent_main_activity = new Intent(this. getApplicationContext(), Sleep.class);

            PendingIntent pending_intent_main_activity = PendingIntent.getActivity(this, 0, intent_main_activity, 0);

            Notification notification_popup = new Notification.Builder(this).setContentTitle("An alarm is going off!")
                    .setContentText("Click me")
                    .setContentIntent(pending_intent_main_activity)
                    .setAutoCancel(true)
                    .build();

            notify_manager.notify(0,notification_popup);

        }
        else if (this.isRunning && startId == 0) {
            Log.e("There is music,", "and you want end");

            media_song.stop();
            media_song.reset();

            this.isRunning = false;
            this.startId = 0;


        }
        else if (!this.isRunning && startId == 0) {
            Log.e("There is no music,", "and you want end");

            this.isRunning = false;
            this.startId = 0;


        }
        else if (this.isRunning && startId == 1) {
            Log.e("There is music,", "and you want start");
            this.isRunning = true;
            this.startId = 1;


        }
        else {
            Log.e("else,", "you're pressing too many buttons");


        }






        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.e("on destroy called", "Destroyed");

        super.onDestroy();
        this.isRunning = false;



    }
}
