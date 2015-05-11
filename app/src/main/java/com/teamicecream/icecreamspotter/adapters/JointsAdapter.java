package com.teamicecream.icecreamspotter.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.teamicecream.icecreamspotter.R;
import com.teamicecream.icecreamspotter.models.LocationsAndJoints;

import java.util.List;

/**
 * Created by eit on 4/29/15.
 */
public class JointsAdapter extends ArrayAdapter {

private List objects;
    public JointsAdapter(Context context, List objects) {
        super(context, R.layout.location_item, objects);
        this.objects = objects;
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LocationsAndJoints locationsAndJoints = (LocationsAndJoints)getItem(position);
        if (convertView == null ){
             view = View.inflate(getContext(), R.layout.location_item, null);
        }
        TextView tv  = (TextView)view.findViewById(R.id.location);
        tv.setText(locationsAndJoints.name);
        return view;
    }
}
