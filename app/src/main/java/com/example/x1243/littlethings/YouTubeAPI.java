package com.example.x1243.littlethings;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YouTubeAPI extends YouTubeBaseActivity {

    ImageView b;
    ImageView a;
    ImageView c;
    ImageView d;
    ImageView e;
    ImageView f;
    ImageView g;
    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_you_tube_api);


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

        b = (ImageView) findViewById(R.id.PLAY_VIDEO);
        b.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                youTubePlayerView.initialize("AIzaSyAute3-N7bM3o8vNdrOynY6IofzAKCm_X0",onInitializedListener);
            }
        });


        a = (ImageView) findViewById(R.id.s_iv);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:116123"));
                startActivity(callIntent);
            }
        });



        c = (ImageView) findViewById(R.id.a_iv);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1800804848"));
                startActivity(callIntent);
            }
        });


        d = (ImageView) findViewById(R.id.g_iv);
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:1890474474"));
                startActivity(callIntent);
            }
        });


        e = (ImageView) findViewById(R.id.browser_1);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.samaritans.ie"));
                startActivity(s_intent);
            }
        });

        f = (ImageView) findViewById(R.id.browser_2);
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.aware.ie"));
                startActivity(a_intent);
            }
        });


        g = (ImageView) findViewById(R.id.browser_3);
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent g_intent = new Intent(Intent.ACTION_VIEW, Uri.parse("www.grow.ie"));
                startActivity(g_intent);
            }
        });



    }
}
