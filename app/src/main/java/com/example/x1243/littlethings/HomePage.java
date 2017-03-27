package com.example.x1243.littlethings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth firebaseAuth;

    private TextView textViewUserEmail;
    private Button button_logout;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button youTube=(Button)findViewById(R.id.button6);
        youTube.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(HomePage.this, YouTubeAPI.class);
                HomePage.this.startActivity(myIntent);
            }
        });

        Button sleep=(Button)findViewById(R.id.button7);
        sleep.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(HomePage.this, Sleep.class);
                HomePage.this.startActivity(myIntent);
            }
        });

        Button fitness=(Button)findViewById(R.id.button4);
        fitness.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(HomePage.this, FitnessPage.class);
                HomePage.this.startActivity(myIntent);
            }
        });

        Button mindfulness=(Button)findViewById(R.id.button5);
        mindfulness.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(HomePage.this, Mindfulness.class);
                HomePage.this.startActivity(myIntent);
            }
        });

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginPage.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        title = (TextView) findViewById(R.id.title);

        title.setText("Welcome to The Little Things App "+user.getEmail());

        button_logout = (Button) findViewById(R.id.button_logout);

        button_logout.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        if(view == button_logout){
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, LoginPage.class));
        }


    }


}
