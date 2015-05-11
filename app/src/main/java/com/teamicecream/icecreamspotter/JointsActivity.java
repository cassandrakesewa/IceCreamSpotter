package com.teamicecream.icecreamspotter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.teamicecream.icecreamspotter.adapters.JointsAdapter;
import com.teamicecream.icecreamspotter.adapters.SpotsAdapter;
import com.teamicecream.icecreamspotter.models.LocationsAndJoints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eit on 4/29/15.
 */
public class JointsActivity extends Activity implements AdapterView.OnItemClickListener{
    ArrayList<LocationsAndJoints> locationsAndJointses;
    ListView listView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joint_layout);
        listView = (ListView)findViewById(android.R.id.list);
        final ArrayList<String> jointList = new ArrayList<>();
        final String[] data = getIntent().getStringArrayExtra("LocData");


        final SpotsAdapter adapter = new SpotsAdapter(this, jointList);
        listView.setAdapter(adapter);
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (String x: data){
                    jointList.add(x);
                    adapter.notifyDataSetChanged();
                }
            }
        };

        runnable.run();

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
        Toast.makeText(this, "Heyy come wate", Toast.LENGTH_LONG).show();
        LocationsAndJoints loc = (LocationsAndJoints)parent.getAdapter().getItem(position);
        Log.e("location clicked: ", loc.joints[0] + "sure");
        Intent i = new Intent(this, SpotDetailsActivity.class);
        i.putExtra("loc", loc.joints);
        startActivity(i);
    }

}

