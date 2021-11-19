package com.hp.pav.demojune6.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.hp.pav.demojune6.R;
import com.hp.pav.demojune6.domain.Transport;
import com.hp.pav.demojune6.domain.User;
import com.hp.pav.demojune6.helper.StopsHelper;
import com.hp.pav.demojune6.helper.TransportHelper;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Pav on 6/13/2017.
 */

public class MapFragmet extends Fragment implements OnMapReadyCallback {

    EditText search_txt;
    TextView message;
    Button search, satellite, normal, terrain, hybrid;
    Spinner drop_stops;
    GoogleMap gmap;

    RequestQueue rq;
    int route_no = 0;

    User user;
    private StopsHelper stopsHelper;
    private Map<String, LatLng> stopsMap;
    private String[] stop_list;

    private ArrayList<Transport> transports_loaded, transports;
    private TransportHelper transportHelper;

    private ArrayList<Marker> markers;

    Polyline route9_line, route10_line;
    Polygon route9_polygon, route10_polygon;
    ProgressDialog progressDialog;
    static int count = 0;

    String url = "http://maps.googleapis.com/maps/api/geocode/json?address=";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.mapfragmentlayout, container, false);
//        progressDialog = new ProgressDialog(getActivity());
//        progressDialog.setMessage(" Loading ");
//        progressDialog.show();

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try{

            route_no = getArguments().getInt("route_no");
        }catch (Exception e){

        }

//        search_txt = (EditText)view.findViewById(R.id.search_txt);
//        search = (Button)view.findViewById(R.id.search_b);

        satellite = (Button)view.findViewById(R.id.satelite);
        normal = (Button)view.findViewById(R.id.normal );
        drop_stops = (Spinner) view.findViewById(R.id.drop_stops);
//        terrain = (Button)view.findViewById(R.id.terrain);
//        hybrid = (Button)view.findViewById(R.id.hybrid);
        rq = Volley.newRequestQueue(getActivity());

        transportHelper = new TransportHelper();
        markers = new ArrayList<>();
        user = new User();
        stopsHelper = new StopsHelper();

        message = (TextView)view.findViewById(R.id.message);

        SupportMapFragment mapFragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        stop_list = new String[20];




//        drop_stops


//        search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String loc = search_txt.getText().toString();
//                url = url.concat(loc);
//
//                Toast.makeText(getActivity(), " Search button is clicked",Toast.LENGTH_SHORT).show();
//
//                StringRequest srq = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        Toast.makeText(getActivity(), " response parsing",Toast.LENGTH_SHORT).show();
//
//                        try {
//                            JSONObject response_obj = new JSONObject(response);
//                            JSONArray results = response_obj.getJSONArray("results");
//                            JSONObject result_obj = results.getJSONObject(0);
//
//                            JSONObject geometry = result_obj.getJSONObject("geometry");
//
//                            JSONObject location = geometry.getJSONObject("location");
//                            double lat = location.getDouble("lat");
//                            double lng = location.getDouble("lng");
//
//                            message.setText(message.getText()+". Result: lat="+lat+" lng="+lng);
//                            Toast.makeText(getActivity(), " Latitude: "+lat+"  Longitude "+lng, Toast.LENGTH_LONG).show();
//                            gmap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat,lng)));
//
//                        } catch (Exception e) {
//                            message.setText(" JSON parsing error");
//                            e.printStackTrace();
//                            Toast.makeText(getActivity(), " JSON parsing error", Toast.LENGTH_SHORT).show();
//
//                        }
//
//                    }
//                }, new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        Toast.makeText(getActivity()," Volley Error. String request failed.", Toast.LENGTH_SHORT);
//                        message.setText(" Volley Error");
//                    }
//                });
//                rq.add(srq);
//
//            }
//        });

    satellite.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gmap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        }
    });

    normal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            gmap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    });

    }

//    private String[] getStopList(Map<String, LatLng> stopsMap) {
//        String[] strings = new String[20];
//        int i = 0;
//        for(Object key: stopsMap.keySet()){
//            strings[i] = key.toString();
//            i++;
//        }
//        return strings;
//    }

    private void setStopList() {
        int n = stopsMap.size();
        stop_list = new String[n+1];
        stop_list[0]="Select Destination";
        int i = 1;
        for(Object key: stopsMap.keySet()){
            stop_list[i] = key.toString();
            i++;
        }
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {

        gmap = googleMap;

        gmap.getUiSettings().setCompassEnabled(true);
        gmap.getUiSettings().setZoomControlsEnabled(true);
        LatLng focusLatLng = new LatLng(27.6774435802915,85.36253988029151);
        gmap.moveCamera(CameraUpdateFactory.newLatLngZoom(focusLatLng, 12));

//        progressDialog.dismiss();

        gmap.addMarker(new MarkerOptions()
                .position(user.getPosition())
                .title("My Location")
                .snippet("and snippet")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
        );

        if(route_no != 0){
            transports_loaded = transportHelper.getTransports(route_no);
            transports = transports_loaded;
            stopsMap = stopsHelper.getStopsMap(route_no);

            setStopList();
            Context context = getContext();
            drop_stops.setAdapter(new ArrayAdapter<String>(context,android.R.layout.simple_spinner_dropdown_item, stop_list));

//            drop_stops.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> adapterView) {
//
//                }
//            });
            switch (route_no){
                case 9:
                    route9_polygon = drawPolygon();
                    route9_polygon.setStrokeColor(Color.TRANSPARENT);

                    route9_line = drawPolyLine();
                    break;

                case 10:
                    route10_polygon = drawPolygon();
                    route10_polygon.setStrokeColor(Color.TRANSPARENT);

                    route10_line = drawPolyLine();
                    break;
            }

            drop_stops.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(i!=0){

                        Object selectedObj = adapterView.getItemAtPosition(i);
                        String destination = selectedObj.toString();
                        LatLng latLng = stopsMap.get(destination);
                        user.setDestination(latLng);
                        transports = filterTransports();
                        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Transports going to"+destination);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            pinTransports();
        }

    }

    private ArrayList<Transport> filterTransports() {
        ArrayList<double[]> vector_list = calculateVectors();
        double[] cosine_values = calculateCosineValues(vector_list);

        ArrayList<Transport> filtered_transports= new ArrayList<>();
        for(int i=0; i<transports_loaded.size();i++){
            double cosine_value = cosine_values[i];
            if(cosine_value>=0.0 && cosine_value<=1){
                filtered_transports.add(this.transports_loaded.get(i));
            }
        }

        return filtered_transports;

    }


    private double[] calculateCosineValues(ArrayList<double[]> vector_list) {
        int vector_size = vector_list.size();

        double[] cosine_values = new double[vector_size-1];

        double[] user_vector = vector_list.get(0);
        double user_vector_mod, transport_vector_mod, cosine_value;

        user_vector_mod = Math.sqrt(user_vector[0]*user_vector[0] + user_vector[1]*user_vector[1]);

        for(int i=1; i < vector_size; i++){
            double[] transport_vector = vector_list.get(i);
            transport_vector_mod = Math.sqrt(transport_vector[0]*transport_vector[0] + transport_vector[1]*transport_vector[1]);

            cosine_value = (user_vector[0]*transport_vector[0] + user_vector[1]*transport_vector[1])/(user_vector_mod*transport_vector_mod);
            cosine_values[i-1] = cosine_value;
        }

        return cosine_values;
    }

    private ArrayList<double[]> calculateVectors() {
        ArrayList<double[]> vector_list = new ArrayList<>();
        double[] user_vector = new double[2];

        user_vector[0] = user.getDestination().latitude - user.getPosition().latitude;
        user_vector[1] = user.getDestination().longitude - user.getPosition().longitude;

        vector_list.add(user_vector);

        for(Transport transport: transports_loaded){
            double[] transport_vector = new double[2];

            transport_vector[0] = transport.getLatLng().latitude - transport.getLast_latLng().latitude;
            transport_vector[1] = transport.getLatLng().longitude - transport.getLast_latLng().longitude;

            vector_list.add(transport_vector);
        }


        return vector_list;
    }

    private Polyline drawPolyLine() {

        Polyline polyline = null;
        switch (route_no){
            case 9:
                polyline = gmap.addPolyline(new PolylineOptions()
                        .add(
                                new LatLng(27.67070142,85.42249918),
                                new LatLng(27.67143305, 85.42233825 ),
                                new LatLng(27.67142355, 85.42140484 ),
                                new LatLng(27.67178462, 85.41432381 ),
                                new LatLng(27.67425503, 85.40968895 ),
                                new LatLng(27.67805556, 85.40724277 ),
                                new LatLng(27.68120989, 85.3927803 ),
                                new LatLng(27.68311005, 85.38741589 ),
                                new LatLng(27.68196996, 85.38012028 ),
                                new LatLng(27.68295804, 85.36934853 ),
                                new LatLng(27.68911434, 85.36042213 ),
                                new LatLng(27.68493417, 85.35690308 ),
                                new LatLng(27.67740948, 85.35308361 ),
                                new LatLng(27.67520517, 85.35265446 ),
                                new LatLng(27.67642135, 85.34999371 ),
                                new LatLng(27.67862562, 85.34947872 ),
                                new LatLng(27.68345208, 85.3491354 ),
                                new LatLng(27.68577022, 85.34656048 ),
                                new LatLng(27.68953235, 85.33042431 ),
                                new LatLng(27.69443432, 85.32042503 ),
                                new LatLng(27.70556743, 85.32282829 ),
                                new LatLng(27.70625134, 85.31634808 ),
                                new LatLng(27.69929807,85.31686306  ),
                                new LatLng(27.69861412, 85.32154083 )

                        )
                );
                break;

            case 10:
                polyline = gmap.addPolyline(new PolylineOptions()
                        .add(
                                new LatLng(27.67326687, 85.38621426 ),
                                new LatLng(27.67520517, 85.35265446 ),
                                new LatLng(27.67642135, 85.34999371 ),
                                new LatLng(27.67862562, 85.34947872 ),
                                new LatLng(27.68345208, 85.3491354 ),
                                new LatLng(27.68577022, 85.34656048 ),
                                new LatLng(27.68953235, 85.33042431 ),
                                new LatLng(27.69443432, 85.32042503 ),
                                new LatLng(27.69941206, 85.317206380),
                                new LatLng(27.69990602, 85.31360149 ),
                                new LatLng(27.70693524, 85.31433105 ),
                                new LatLng(27.70617535, 85.31621933 ),
                                new LatLng(27.69945006, 85.31677723 ),
                                new LatLng(27.69846213, 85.32149792 ),
                                new LatLng(27.69473831, 85.32055378 )
                        )

                );
        }
        return polyline;
    }

    private Polygon drawPolygon() {
        Polygon polygon = null;
        switch (route_no){
            case 9:
                polygon = gmap.addPolygon(new PolygonOptions()
                        .add(
                                new LatLng(27.67017537, 85.42308927),
                                new LatLng(27.67138174, 85.38805962),
                                new LatLng(27.67433708, 85.35022487),
                                new LatLng(27.69825465, 85.31257567),
                                new LatLng(27.70877947, 85.31335205),

                                new LatLng(27.7065758, 85.32313285),
                                new LatLng(27.68573827, 85.34885157),
                                new LatLng(27.69060241, 85.36121119),
                                new LatLng(27.67483538, 85.42777984)
                        ));
                break;

            case 10:
                polygon = gmap.addPolygon(new PolygonOptions()
                        .add(
                                new LatLng(27.67138174, 85.38805962),
                                new LatLng(27.67433708, 85.35022487),
                                new LatLng(27.69825465, 85.31257567),

                                new LatLng(27.70877947, 85.31335205),
                                new LatLng(27.68573827, 85.34885157),
                                new LatLng(27.67396124, 85.3881046)
                        ));

        }
        return polygon;
    }




    private void pinTransports() {

        count++;

        if(transports.isEmpty()){

            ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("No transports available ");


        }else{
            if(!markers.isEmpty()){
                for(Marker m: markers){
                    m.remove();
                }
            }
            markers = new ArrayList<>();
            for(Transport transport: transports){
//                if(route_bounds.contains(transport.getLatLng())){


                    markers.add(gmap.addMarker(new MarkerOptions()
                            .position(transport.getLatLng())
                            .title("Reg_no.:"+transport.getReg_no()+" type:"+transport.getType())
                            .snippet("and snippet")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                        )
                    );

                transport.updateLatLng();
//                }
            }

            new CountDownTimer(5000, 1000) {

                public void onTick(long millisUntilFinished) {
                    message.setText( " interval: 5s"+" count= "+count);
                }

                public void onFinish() {
                    pinTransports();

                }
            }.start();
        }

    }
}
