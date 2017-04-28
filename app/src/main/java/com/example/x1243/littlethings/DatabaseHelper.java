package com.example.x1243.littlethings;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by x1243 on 12/13/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "ExerciseRoutine.db";
    public static final String TABLE_NAME = "Exercise_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "Exercise";
    public static final String COL_3 = "Reps";
    public static final String COL_4 = "Sets";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, Exercise TEXT, Reps INTEGER, Sets INTEGER) ");


    }

    public Integer deleteExercise(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);


    }

    public boolean insertData(String exercise, String reps, String sets){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, exercise);
        contentValues.put(COL_3, reps);
        contentValues.put(COL_4, sets);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getPlan(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    public boolean updatePlan(String id, String exercise, String reps, String sets ){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(COL_1, id);
        contentValues.put(COL_2, exercise);
        contentValues.put(COL_3, reps);
        contentValues.put(COL_4, sets);

        db.update(TABLE_NAME, contentValues, "id = ?", new String[]{id});

        return true;



    }
}
