package com.example.x1243.littlethings;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by x1243 on 12/12/2016.
 */

public class Alarm_Receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Log.e("we are in the receiver.", "Yay");

        String get_your_string = intent.getExtras().getString("extra");

        Log.e("what is the key?", get_your_string);

        Intent service_intent = new Intent(context, RingtonePlayingService.class);

        service_intent.putExtra("extra", get_your_string);

        context.startService(service_intent);
    }
}
