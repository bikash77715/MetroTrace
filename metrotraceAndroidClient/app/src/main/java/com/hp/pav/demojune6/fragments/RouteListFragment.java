package com.hp.pav.demojune6.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.hp.pav.demojune6.HomeActivity;
import com.hp.pav.demojune6.R;
import com.hp.pav.demojune6.helper.DBA;
import com.hp.pav.demojune6.helper.RoutesAdapter;
import com.hp.pav.demojune6.domain.Route;

import java.util.ArrayList;

/**
 * Created by pav on 12/16/2017.
 */

public class RouteListFragment extends Fragment{

    ListView listView;
    TextView message;
    private ArrayList<Route> route_list;
    private Route route_9, route_10;
//    DBA dba;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View convertView = inflater.inflate(R.layout.fragment_routes, null);
        return convertView;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = (ListView) getActivity().findViewById(R.id.list_view);
        message = (TextView) getActivity().findViewById(R.id.message);
        final Context context = getContext();
//        dba = new DBA(context);

//        route_list = dba.getRoutes();
        route_9 = new Route(9, "Bhaktapur-Ratnapark", "Dudhpati","Ratnapark","Dudh Pati, Sallaghari, Niko Sera, Purano-Thimi, Sanothimi, Pepsi-cola, Jadibuti, Koteshwor, Koteshwor Tinkune, Minbhawan, Baneshwor, Bijulibazar, Babarmahal, Singha Durbar, Putalisadak, Bagbazar, Ratnapark ");
//        route_9 = new Route(9, "Saraswotikhel-Ratnapark", "Saraswotikhel","Ratnapark","Saraswotikhel, Tigani, Bode, Purano-Thimi/Magar gaau, Sanothimi, Gathaghar, Kausaltar, Lokanthali, Jadibuti, Koteshwor, Koteshwor Tinkune, Minbhawan, Baneshwor, Bijulibazar, Babarmahal, Singha Durbar, Putalisadak, Bagbazar, Ratnapark ");

        route_10= new Route(10, "Thimi-Ratnapark", "Radhe-Radhe","Ratnapark","Radhe-Radhe, Naya-Thimi, Gathaghar, Kausaltar, Lokanthali, Jadibuti, Koteshwor, Koteshwor Tinkune, Minbhawan, Baneshwor, Bijulibazar, Babarmahal, Bhadrakali, Sundhara, Ratnapark ");

        route_list = new ArrayList<>();
        route_list.add(route_9);
        route_list.add(route_10);

        if(route_list.isEmpty()){
            message.setText("No routes in database");
        }else{
            listView.setAdapter(new RoutesAdapter(context, route_list));

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

//                    Toast.makeText(context, String.valueOf(i), Toast.LENGTH_SHORT).show();

                    int route_no = route_list.get(i).getRoute_no();

                    MapFragmet mapFragmet = new MapFragmet();
                    Bundle bundle = new Bundle();

//                    bundle.putString("route_no", String.valueOf(route_no));
                    bundle.putInt("route_no", route_no);
                    mapFragmet.setArguments(bundle);


                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.view, mapFragmet);
                    fragmentTransaction.commit();

                    ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Transports in route "+route_no);


                }
            });
        }

    }
}
