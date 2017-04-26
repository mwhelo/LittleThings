package com.example.x1243.littlethings;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class FitnessPlans extends AppCompatActivity {
    ListView list;
    CustomAdapter adapter;

    final String[] names = {
            "Chest workout",
            "Arm workout",
            "Shoulder workout",
            "Back workout",
            "Leg workout",
            "Cardio workout"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_plans);

        list = (ListView) findViewById(R.id.listView);
        adapter = new CustomAdapter(this, R.layout.listview_item, names);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent firstIntent = new Intent(FitnessPlans.this, ChestWorkoutPage.class);
                        startActivity(firstIntent);
                        break;

                    case 1:
                        Intent secondIntent = new Intent(FitnessPlans.this, ArmWorkoutPage.class);
                        startActivity(secondIntent);
                        break;

                    case 2:
                        Intent thirdIntent = new Intent(FitnessPlans.this, ShoulderWorkout.class);
                        startActivity(thirdIntent);
                        break;

                    case 3:
                        Intent fourthIntent = new Intent(FitnessPlans.this, BackWorkoutPage.class);
                        startActivity(fourthIntent);
                        break;

                    case 4:
                        Intent fifthIntent = new Intent(FitnessPlans.this, LegWorkoutPage.class);
                        startActivity(fifthIntent);
                        break;

                    case 5:
                        Intent sixthIntent = new Intent(FitnessPlans.this, CardioWorkoutPage.class);
                        startActivity(sixthIntent);
                        break;
                }
            }
        });




    }


}
