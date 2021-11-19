package com.hp.pav.demojune6.domain;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by pav on 1/7/2018.
 */

public class Transport {

    private String reg_no, type;
    private int route_no;
    private LatLng latLng, last_latLng;
    private int direction;
    public Transport() {
    }

    public Transport(String reg_no, String type, int route_no, LatLng latLng, int direction) {
        this.reg_no = reg_no;
        this.type = type;
        this.route_no = route_no;
        this.latLng = latLng;
        this.direction = direction;
        this.last_latLng = latLng;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getRoute_no() {
        return route_no;
    }

    public void setRoute_no(int route_no) {
        this.route_no = route_no;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public LatLng getLast_latLng() {
        return last_latLng;
    }

    public void updateLatLng() {

//        double x = 0.1, y =05;

        this.last_latLng = getLatLng();
        double x = 0.0001, y =0.00001;
        if(direction == 0){

            setLatLng(new LatLng(latLng.latitude+y, latLng.longitude-x));

        }else{
            setLatLng(new LatLng(latLng.latitude-y, latLng.longitude+x));


        }

    }
}
