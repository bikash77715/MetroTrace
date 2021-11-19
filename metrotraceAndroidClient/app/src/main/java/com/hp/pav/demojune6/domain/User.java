package com.hp.pav.demojune6.domain;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by Pav on 9/5/2017.
 */

public class User {
//    private int id;
    private LatLng position, destination;

    RequestQueue rq;
    String url = "http://maps.googleapis.com/maps/api/geocode/json?address=";


    public User(){
        this.position = new LatLng(27.6774435802915,85.36253988029151);
    }


//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public LatLng getPosition() {
        return position;
    }

    public void setPosition(LatLng latLng) {
        this.position = latLng;
    }

    public LatLng getDestination() {
        return destination;
    }

    public void setDestination(LatLng destination) {
        this.destination = destination;
    }


    public void parseInput(String to, String from) {
        LatLng userLatLng = parse(to), newdestinationLatLng = parse(from);
        this.position = userLatLng;
        this.destination = newdestinationLatLng;

    }

    private LatLng parse(String to) {

        url = url.concat(to);
        final double[] lat = new double[1];
        final double[] lng = new double[1];
//        rq = Volley.newRequestQueue();


        StringRequest srq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject response_obj = new JSONObject(response);
                    JSONArray results = response_obj.getJSONArray("results");
                    JSONObject result_obj = results.getJSONObject(0);

                    JSONObject geometry = result_obj.getJSONObject("geometry");

                    JSONObject location = geometry.getJSONObject("location");
                    lat[0] = location.getDouble("lat");
                    lng[0] = location.getDouble("lng");

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        rq.add(srq);
        return (new LatLng(lat[0], lng[0]));
    }
}
