package com.example.x1243.littlethings;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

public class Mindfulness extends Activity implements Runnable {

    private ImageView startButton;
    private ImageView pauseButton;
    private ImageView stopButton;
    private MediaPlayer soundPlayer;
    private SeekBar soundSeekBar;

    private ImageView startButton2;
    private ImageView pauseButton2;
    private ImageView stopButton2;
    private MediaPlayer soundPlayer2;
    private SeekBar soundSeekBar2;

    private ImageView startButton3;
    private ImageView pauseButton3;
    private ImageView stopButton3;
    private MediaPlayer soundPlayer3;
    private SeekBar soundSeekBar3;
    private Thread soundThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mindfulness);

        startButton = (ImageView) findViewById(R.id.playButton1);
        pauseButton = (ImageView) findViewById(R.id.pauseButton1);
        stopButton = (ImageView) findViewById(R.id.stopButton1);
        soundSeekBar = (SeekBar) findViewById(R.id.seekBar1);
        soundPlayer = MediaPlayer.create(this.getBaseContext(),R.raw.sos);

        startButton2 = (ImageView) findViewById(R.id.playButton2);
        pauseButton2 = (ImageView) findViewById(R.id.pauseButton2);
        stopButton2 = (ImageView) findViewById(R.id.stopButton2);
        soundSeekBar2 = (SeekBar) findViewById(R.id.seekBar2);
        soundPlayer2 = MediaPlayer.create(this.getBaseContext(),R.raw.meditation);

        startButton3 = (ImageView) findViewById(R.id.playButton3);
        pauseButton3 = (ImageView) findViewById(R.id.pauseButton3);
        stopButton3 = (ImageView) findViewById(R.id.stopButton3);
        soundSeekBar3 = (SeekBar) findViewById(R.id.seekBar3);
        soundPlayer3 = MediaPlayer.create(this.getBaseContext(),R.raw.sleep);

        setupListeners1();
        setupListeners2();
        setupListeners3();

        soundThread = new Thread(this);
        soundThread.start();

    }

    private void setupListeners1(){
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

    private void setupListeners2(){
        startButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                soundPlayer2.start();
            }
        });

        pauseButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                soundPlayer2.pause();
            }
        });

        stopButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View cuttentView){
                soundPlayer2.stop();
                soundPlayer2 = MediaPlayer.create(getBaseContext(), R.raw.meditation);
            }
        });

        soundSeekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                if(fromUser){
                    soundPlayer2.seekTo(progress);
                }
            }
        });
    }

    private void setupListeners3(){
        startButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                soundPlayer3.start();
            }
        });

        pauseButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                soundPlayer3.pause();
            }
        });

        stopButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View cuttentView){
                soundPlayer3.stop();
                soundPlayer3 = MediaPlayer.create(getBaseContext(), R.raw.sleep);
            }
        });

        soundSeekBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onStopTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar){

            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){
                if(fromUser){
                    soundPlayer3.seekTo(progress);
                }
            }
        });
    }


    public void run()
    {
        int currentPosition = 0;
        int soundTotal = soundPlayer.getDuration();
        soundSeekBar.setMax(soundTotal);

        int currentPosition2 = 0;
        int soundTotal2 = soundPlayer2.getDuration();
        soundSeekBar2.setMax(soundTotal2);

        int currentPosition3 = 0;
        int soundTotal3 = soundPlayer3.getDuration();
        soundSeekBar3.setMax(soundTotal3);

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

        while(soundPlayer2 !=null && currentPosition2 < soundTotal2)
        {
            try
            {
                Thread.sleep(300);
                currentPosition = soundPlayer2.getCurrentPosition();
            }
            catch(InterruptedException soundException)
            {
                return;
            }
            catch(Exception otherException)
            {
                return;
            }
            soundSeekBar2.setProgress(currentPosition);
        }

        while(soundPlayer3 !=null && currentPosition3 < soundTotal3)
        {
            try
            {
                Thread.sleep(300);
                currentPosition = soundPlayer3.getCurrentPosition();
            }
            catch(InterruptedException soundException)
            {
                return;
            }
            catch(Exception otherException)
            {
                return;
            }
            soundSeekBar3.setProgress(currentPosition);
        }
    }

}
