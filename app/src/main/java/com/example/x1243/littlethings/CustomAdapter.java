package com.example.x1243.littlethings;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by x1243 on 4/26/2017.
 */

class CustomAdapter extends ArrayAdapter<String> implements ListAdapter {

    String[] listItems;
    Context context;

    public CustomAdapter(Context context, int resID, String[] array){
        super(context, resID, array);

        listItems = array;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        View view = convertView;
        TextView nameTv;

        if(view != null){
            nameTv= (TextView)view.findViewById(R.id.name);
        }else{
            LayoutInflater lf  = (LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = lf.inflate(R.layout.listview_item, null);
            nameTv = (TextView)view.findViewById(R.id.name);

        }

        nameTv.setText(listItems[position]);



        return view;
    }



    @Override
    public int getCount(){
        return listItems.length;
    }
}
