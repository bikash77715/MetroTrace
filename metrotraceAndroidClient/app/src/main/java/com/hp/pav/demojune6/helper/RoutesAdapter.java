package com.hp.pav.demojune6.helper;

import android.app.FragmentTransaction;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hp.pav.demojune6.R;
import com.hp.pav.demojune6.domain.Route;
import com.hp.pav.demojune6.domain.RouteHolder;

import java.util.ArrayList;

/**
 * Created by pav on 12/16/2017.
 */

public class RoutesAdapter extends BaseAdapter {

    Context context;
    ArrayList<Route> route_list;
    LayoutInflater inflater;

    public RoutesAdapter(Context context, ArrayList<Route> route_list) {
        this.context = context;
        this.route_list = route_list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


//    public CustomAdapter(RoutesActivity context, ArrayList<Route> route_list) {
//        this.context = context;
//        this.route_list = route_list;
//        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    }

    @Override
    public int getCount() {
        return route_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        RouteHolder holder;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.singleroute, null);

            holder = new RouteHolder();
            holder.route_no = (TextView)convertView.findViewById(R.id.route_no);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.start = (TextView)convertView.findViewById(R.id.start_from);
            holder.end = (TextView)convertView.findViewById(R.id.end_at);
            holder.stops = (TextView)convertView.findViewById(R.id.stops);

            convertView.setTag(holder);

        }else {
            holder = (RouteHolder) convertView.getTag();
        }

        String route_name = String.valueOf(route_list.get(position).getName());
        holder.name.setText(route_name);
        holder.route_no.setText(String.valueOf(route_list.get(position).getRoute_no()));
        holder.start.setText(String.valueOf(route_list.get(position).getStart_from()));
        holder.end.setText(String.valueOf(route_list.get(position).getEnd_at()));
        holder.stops.setText(String.valueOf(route_list.get(position).getStops()));

        /** click listener **/


        return convertView;


    }
}
