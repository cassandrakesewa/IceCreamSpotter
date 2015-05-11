package com.teamicecream.icecreamspotter;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.teamicecream.icecreamspotter.adapters.FlavorAdaptor;

import java.util.ArrayList;

/**
 * Created by eit on 4/29/15.
 */
public class FlavorActivity extends Activity implements AdapterView.OnItemClickListener {

    ListView listView;
    ArrayList<String> flavorsandpics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flavor_layout);


        listView = (ListView) findViewById(android.R.id.list);

        flavorsandpics = new ArrayList<>();

        final String[] flav = getResources().getStringArray(R.array.diffflavors);


        final FlavorAdaptor adapter = new FlavorAdaptor(this, flavorsandpics);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (String x : flav) {
                    flavorsandpics.add(x);
                    adapter.notifyDataSetChanged();
                }
            }
        };

        runnable.run();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("alog", "this is my log of the error that i'm expecting right now");
        Toast.makeText(this,listView.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show();
    }

}
