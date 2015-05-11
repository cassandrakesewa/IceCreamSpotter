package com.teamicecream.icecreamspotter.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.teamicecream.icecreamspotter.R;

import java.util.ArrayList;

/**
 * Created by eit on 4/29/15.
 */
public class FlavorAdaptor extends ArrayAdapter {

    ArrayList<String> locationsAndJoints;

    public FlavorAdaptor(Context context, ArrayList<String> objects) {
        super(context, R.layout.flavor_item, objects);
        locationsAndJoints = objects;
    }

    @Override
    public String getItem(int position) {
        super.getItem(position);

        return locationsAndJoints.get(position);
    }


    int flavorImages[] =  {
         R.drawable.vanilla,
            R.drawable.chocolate,
            R.drawable.chocolatechip,
            R.drawable.strawberry,
            R.drawable.cherry,
            R.drawable.cookiesncream,
            R.drawable.frenchvanilla,
            R.drawable.neapolitan,
            R.drawable.vanillafudge,
            R.drawable.praline
    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        String spot = getItem(position);
        if (convertView == null ){
            view = View.inflate(getContext(), R.layout.flavor_item, null);
        }
        ImageView flavorimage = (ImageView) view.findViewById(R.id.vanilla);
        TextView tv  = (TextView)view.findViewById(R.id.vanilla_flavor);
flavorimage.setImageResource(flavorImages[position]);
//        flavorimage.setImageDrawable(getContext().getDrawable(flavorImages[position]));
        tv.setText(spot);
        return view;
    }
}

