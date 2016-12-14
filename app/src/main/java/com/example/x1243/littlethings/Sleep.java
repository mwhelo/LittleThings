package com.example.x1243.littlethings;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Sleep extends AppCompatActivity {

    AlarmManager alarm_manager;
    TimePicker alarm_timepicker;
    TextView update_text;
    Context context;
    PendingIntent pending_intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        this.context = this;

        Button home=(Button)findViewById(R.id.button);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(Sleep.this, HomePage.class);
                Sleep.this.startActivity(myIntent);
            }
        });


        alarm_manager  = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarm_timepicker = (TimePicker)findViewById(R.id.timePicker);
        update_text = (TextView) findViewById(R.id.update_text);

        final Calendar calendar = Calendar.getInstance();


        final Intent my_intent = new Intent(this.context, Alarm_Receiver.class);


        Button alarm_on = (Button)findViewById(R.id.alarm_on);




        alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar.set(Calendar.HOUR_OF_DAY, alarm_timepicker.getHour());
                calendar.set(Calendar.MINUTE, alarm_timepicker.getMinute());

                int hour = alarm_timepicker.getHour();
                int minute = alarm_timepicker.getMinute();

                String hour_string = String.valueOf(hour);
                String minute_string = String.valueOf(minute);

                if (hour > 12){
                    hour_string = String.valueOf(hour - 12);
                }

                if(minute <10){
                    minute_string = "0" + String.valueOf(minute);
                }


                set_alarm_text("Alarm Set to " + hour_string + ":" + minute_string);

                my_intent.putExtra("extra", "Alarm on");

                pending_intent = PendingIntent.getBroadcast(Sleep.this, 0,my_intent,PendingIntent.FLAG_UPDATE_CURRENT);

                alarm_manager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);

            }
        });

        Button alarm_off = (Button)findViewById(R.id.alarm_off);
        alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_alarm_text("Alarm Off");

                alarm_manager.cancel(pending_intent);

                my_intent.putExtra("extra", "Alarm off");

                sendBroadcast(my_intent);


            }
        });




    }

    private void set_alarm_text(String output) {
        update_text.setText(output);

    }

    }

