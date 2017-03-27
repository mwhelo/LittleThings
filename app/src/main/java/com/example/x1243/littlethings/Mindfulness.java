package com.example.x1243.littlethings;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class Mindfulness extends Activity implements Runnable {

    private Button startButton;
    private Button pauseButton;
    private Button stopButton;
    private MediaPlayer soundPlayer;
    private SeekBar soundSeekBar;
    private Thread soundThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);

        startButton = (Button) findViewById(R.id.playButton1);
        pauseButton = (Button) findViewById(R.id.pauseButton1);
        stopButton = (Button) findViewById(R.id.stopButton1);
        soundSeekBar = (SeekBar) findViewById(R.id.seekBar1);
        soundPlayer = MediaPlayer.create(this.getBaseContext(),R.raw.sos);

        setupListeners();

        soundThread = new Thread(this);
        soundThread.start();

    }

    private void setupListeners(){
        startButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                soundPlayer.start();
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                soundPlayer.pause();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View cuttentView){
                soundPlayer.stop();
                soundPlayer = MediaPlayer.create(getBaseContext(), R.raw.sos);
            }
        });

        soundSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                if(fromUser){
                    soundPlayer.seekTo(progress);
                }
            }
        });
    }


    public void run()
    {
        int currentPosition = 0;
        int soundTotal = soundPlayer.getDuration();
        soundSeekBar.setMax(soundTotal);

        while(soundPlayer !=null && currentPosition < soundTotal)
        {
            try
            {
                Thread.sleep(300);
                currentPosition = soundPlayer.getCurrentPosition();
            }
            catch(InterruptedException soundException)
            {
                return;
            }
            catch(Exception otherException)
            {
                return;
            }
            soundSeekBar.setProgress(currentPosition);
        }
    }
}
