package com.teamicecream.icecreamspotter.models;

import java.util.ArrayList;

/**
 * Created by eit on 4/29/15.
 */
public class LocationsAndJoints {
    public String name ;
    public String[] joints;

    public LocationsAndJoints(String name, String[] joints){
        this.name = name;
        this.joints = joints;

    }

    public LocationsAndJoints(){}
}
