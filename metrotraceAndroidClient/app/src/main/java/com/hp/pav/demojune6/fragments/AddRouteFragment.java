package com.hp.pav.demojune6.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hp.pav.demojune6.HomeActivity;
import com.hp.pav.demojune6.R;
import com.hp.pav.demojune6.domain.Route;
import com.hp.pav.demojune6.helper.DBA;

/**
 * Created by pav on 12/16/2017.
 */

public class AddRouteFragment extends Fragment {

    EditText route_no, start, end, stops, name;
    Button save, cancel;

    FragmentTransaction fragmentTransaction;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View convertView = inflater.inflate(R.layout.fragment_addroute, null);
        return convertView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        route_no = (EditText)getActivity().findViewById(R.id.route_no);
        name = (EditText) getActivity().findViewById(R.id.name);
        start = (EditText)getActivity().findViewById(R.id.start);
        end = (EditText)getActivity().findViewById(R.id.end);
        stops = (EditText)getActivity().findViewById(R.id.stops);

        save = (Button)getActivity().findViewById(R.id.save);
        cancel = (Button)getActivity().findViewById(R.id.cancel);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Route route = new Route();
                route.setRoute_no(Integer.parseInt(route_no.getText().toString()));
                route.setName(name.getText().toString());
                route.setStops(stops.getText().toString());
                route.setStart_from(start.getText().toString());
                route.setEnd_at(end.getText().toString());

                DBA dba = new DBA(getContext());
                dba.addRoute(route);
                fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.view, new AddRouteFragment());
                fragmentTransaction.commit();

                Toast.makeText(getContext(), "one route added successfully", Toast.LENGTH_LONG).show();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getContext(), HomeActivity.class);
                startActivity(i);

            }
        });

    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        Intent i = new Intent(getContext(), HomeActivity.class);
//        startActivity(i);
//    }
}
