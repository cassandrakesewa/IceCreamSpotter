package com.teamicecream.icecreamspotter.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.teamicecream.icecreamspotter.R;
import com.teamicecream.icecreamspotter.models.LocationsAndJoints;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by eit on 4/29/15.
 */
public class SpotsAdapter extends ArrayAdapter {

        ArrayList<String> locationsAndJoints;

    public SpotsAdapter(Context context, ArrayList<String> objects) {
        super(context, R.layout.spot_item, objects);
        locationsAndJoints = objects;
    }

    @Override
    public String getItem(int position) {
        super.getItem(position);

        return locationsAndJoints.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        String spot = getItem(position);
        if (convertView == null ){
             view = View.inflate(getContext(), R.layout.spot_item, null);
        }
        TextView tv  = (TextView)view.findViewById(R.id.spot);
        tv.setText(spot);
        return view;
    }
}
