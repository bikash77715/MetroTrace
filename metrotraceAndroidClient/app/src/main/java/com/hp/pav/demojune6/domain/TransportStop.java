package com.hp.pav.demojune6.domain;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by pav on 1/9/2018.
 */

public class TransportStop {
    private LatLng latLng;
    private String loc_name;


    public TransportStop() {
    }

    public TransportStop(String loc_name, LatLng latLng) {
        this.latLng = latLng;
        this.loc_name = loc_name;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public String getLoc_name() {
        return loc_name;
    }

    public void setLoc_name(String loc_name) {
        this.loc_name = loc_name;
    }

    public static ArrayList<TransportStop> getStopList(int route_no) {
        ArrayList<TransportStop> stops = new ArrayList<>();
        switch (route_no){
            case 9:
                stops.add(new TransportStop("Bhaktapur" ,new LatLng(27.67070142, 85.42249918)));
                stops.add(new TransportStop("Sallaghari", new LatLng(27.6729018, 85.41213949999999)));
                stops.add(new TransportStop());
                stops.add(new TransportStop());
                stops.add(new TransportStop());
                stops.add(new TransportStop());
                stops.add(new TransportStop());
                stops.add(new TransportStop());
                stops.add(new TransportStop());
                stops.add(new TransportStop());
                stops.add(new TransportStop());

                break;

            case 10:
//                stops.add(,);

                break;

        }
        return stops;
    }
}
