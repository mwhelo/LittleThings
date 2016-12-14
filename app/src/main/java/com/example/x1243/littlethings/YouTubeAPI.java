package com.example.x1243.littlethings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeAPI extends YouTubeBaseActivity {

    Button b;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_api);

        Button home=(Button)findViewById(R.id.button2);
        home.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(YouTubeAPI.this, HomePage.class);
                YouTubeAPI.this.startActivity(myIntent);
            }
        });


        youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_view);
        onInitializedListener = new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("1UnWpdp2ZxU");

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }

        };

        b = (Button) findViewById(R.id.PLAY_VIDEO);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                youTubePlayerView.initialize("AIzaSyAute3-N7bM3o8vNdrOynY6IofzAKCm_X0",onInitializedListener);
            }
        });

    }
}
