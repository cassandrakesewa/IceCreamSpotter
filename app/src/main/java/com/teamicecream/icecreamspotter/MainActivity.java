package com.teamicecream.icecreamspotter;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.teamicecream.icecreamspotter.adapters.JointsAdapter;
import com.teamicecream.icecreamspotter.models.LocationsAndJoints;


import java.util.ArrayList;


public class MainActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{
    ArrayList<LocationsAndJoints> locationsAndJointses;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(android.R.id.list);

        locationsAndJointses = new ArrayList<>();

        String[] location = getResources().getStringArray(R.array.locations);
        String[] joints = getResources().getStringArray(R.array.East_legon);
        String[]  anotherJoint = getResources().getStringArray(R.array.Osu);
        String[] locMall = getResources().getStringArray(R.array.Accra_mall);

        LocationsAndJoints loc = new LocationsAndJoints(location[0], joints);
        locationsAndJointses.add(loc);
        loc = new LocationsAndJoints(location[1], anotherJoint);
        locationsAndJointses.add(loc);
        loc = new LocationsAndJoints(location[2], locMall);
        locationsAndJointses.add(loc);
        JointsAdapter adapter = new JointsAdapter(this, locationsAndJointses);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        LocationsAndJoints loc = (LocationsAndJoints)parent.getAdapter().getItem(position);
        Log.e("location clicked: ", loc.joints[position]);
        Intent i = new Intent(this, JointsActivity.class);
        i.putExtra("LocData", loc.joints);
        startActivity(i);
    }

    public void showFlavors(View view) {
        Intent intent = new Intent(this, FlavorActivity.class);
        startActivity(intent);
    }
}
