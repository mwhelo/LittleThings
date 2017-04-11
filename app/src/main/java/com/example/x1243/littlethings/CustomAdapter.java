package com.example.x1243.littlethings;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by x1243 on 4/3/2017.
 */

public class CustomAdapter extends ArrayAdapter<String> {

    private Activity activity;
    private ArrayList data;
    public Resources res;
    SpinnerModel tempValues=null;
    LayoutInflater inflater;

    public CustomAdapter(InformationPage activitySpinner,
                         int textViewResourceId,
                         ArrayList objects,
                         Resources resLocal){
        super(activitySpinner, textViewResourceId,objects);

        activity = activitySpinner;
        data = objects;
        res = resLocal;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent){
        View row = inflater.inflate(R.layout.spinner_rows, parent, false);

        tempValues = null;
        tempValues = (SpinnerModel) data.get(position);

        TextView title = (TextView)row.findViewById(R.id.title);
        TextView info = (TextView)row.findViewById(R.id.info);

        if(position==0){
            title.setText("Select a disorder for information");
            info.setText("");
        }
        else{
            title.setText(tempValues.getTitle());
            info.setText(tempValues.getInfo());
        }
        return row;

    }
}
