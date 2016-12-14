package com.example.x1243.littlethings;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FitnessPlanCreation extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editExercise, editReps, editSets,editId;
    Button saveBtn;
    Button viewBtn;
    Button updateBtn;
    Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_plan_creation);
        myDB = new DatabaseHelper(this);

        editExercise = (EditText) findViewById(R.id.editText_exercise);
        editReps = (EditText) findViewById(R.id.editText_reps);
        editSets = (EditText) findViewById(R.id.editText_sets);
        editId = (EditText) findViewById(R.id.editText_id);
        saveBtn = (Button) findViewById(R.id.button_save);
        viewBtn = (Button) findViewById(R.id.button_view);
        updateBtn = (Button) findViewById(R.id.button_update);
        deleteBtn = (Button) findViewById(R.id.button_delete);

        SaveData();
        viewPlan();
        SaveData();
        UpdatePlan();
        DeleteExercise();

    }

    public void SaveData(){
        saveBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                boolean isInserted = myDB.insertData(editExercise.getText().toString(),
                        editReps.getText().toString(),
                        editSets.getText().toString() );

                if(isInserted == true)
                    Toast.makeText(FitnessPlanCreation.this, "Exercise added to Routine", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(FitnessPlanCreation.this, "Exercise not added to Routine", Toast.LENGTH_LONG).show();


            }
        });
    }

    public void viewPlan(){
        viewBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Cursor res = myDB.getPlan();
                if(res.getCount() == 0){
                    displayMessage("No Routine Found", "Please Start Adding Exercises to your Routine");

                    return;
                }
                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){
                    buffer.append("Id :" + res.getString(0)+"\n");
                    buffer.append("Exercise :" + res.getString(1)+"\n");
                    buffer.append("Reps :" + res.getString(2)+"\n");
                    buffer.append("Sets :" + res.getString(3)+"\n\n");

                }

                displayMessage("Data",buffer.toString());

            }
        });
    }

    public void UpdatePlan(){
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean isUpdated = myDB.updatePlan(editId.getText().toString(),
                        editExercise.getText().toString(),
                        editReps.getText().toString(),
                        editSets.getText().toString());

                if(isUpdated == true)
                    Toast.makeText(FitnessPlanCreation.this, "Routine Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(FitnessPlanCreation.this, "Routine not Updated", Toast.LENGTH_LONG).show();



            }
        });
    }

    public void DeleteExercise(){
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Integer deleteRows = myDB.deleteExercise(editId.getText().toString());
                if(deleteRows > 0)
                    Toast.makeText(FitnessPlanCreation.this, "Exercise Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(FitnessPlanCreation.this, "Exercise not Deleted", Toast.LENGTH_LONG).show();

            }
        });

    }

    public void displayMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


}
