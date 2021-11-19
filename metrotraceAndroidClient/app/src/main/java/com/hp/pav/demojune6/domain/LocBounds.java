package com.hp.pav.demojune6.domain;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by pav on 1/8/2018.
 */

public class LocBounds {
    private double x_min, y_min, x_max, y_max;

    public LocBounds() {
    }

    public LocBounds(LatLng loc1, LatLng loc2) {
        x_min = loc1.longitude;
        y_min = loc1.latitude;

        if(x_min>loc2.longitude){
            x_min =loc2.longitude;
            x_max =loc1.longitude;
        }else{
            x_max = loc2.longitude;
        }

        if(y_min>loc2.latitude){
            y_min =loc2.latitude;
            y_max =loc1.latitude;
        }else{
            y_max = loc2.latitude;
        }
    }
}
