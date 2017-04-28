package com.example.x1243.littlethings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FitnessPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_page);

        Button fitness =(Button)findViewById(R.id.button8);
        fitness.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(FitnessPage.this, FitnessPlanCreation.class);
                FitnessPage.this.startActivity(myIntent);
            }
        });

        Button fitnessPlan =(Button)findViewById(R.id.button3);
        fitnessPlan.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent myIntent = new Intent(FitnessPage.this, FitnessPlans.class);
                FitnessPage.this.startActivity(myIntent);
            }
        });

    }


}
