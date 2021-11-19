package com.hp.pav.demojune6.helper;

import com.google.android.gms.maps.model.LatLng;
import com.hp.pav.demojune6.domain.Transport;

import java.util.ArrayList;

/**
 * Created by pav on 1/8/2018.
 */

public class TransportHelper {
    private ArrayList<Transport> route9_transports, route10_transports, transports;

    public TransportHelper() {
        route9_transports = new ArrayList<>();

        route9_transports.add(new Transport("ba 1 pa 4015", "bus", 9, new LatLng(27.67070142, 85.42249918),0));// Bhaktapur buspark
        route9_transports.add(new Transport("ba 1 pa 4018", "bus", 9, new LatLng(27.6729018, 85.41213949999999),0));// iwamura
        route9_transports.add(new Transport("ba 1 pa 4020", "bus", 9, new LatLng(27.67980376, 85.39870264),1)); // Nikoshera
        route9_transports.add(new Transport("ba 1 pa 4017", "bus", 9, new LatLng(27.68254001, 85.3723526),0));// Sanothimi
        route9_transports.add(new Transport("ba 1 pa 4014", "bus", 9, new LatLng(27.67668738, 85.35291195),1)); // Jadibuti

        route9_transports.add(new Transport("ba 1 pa 4019", "bus", 9, new LatLng(27.67986969, 85.34947753),0)); // koteshwor bus stand
        route9_transports.add(new Transport("ba 1 pa 4020", "bus", 9, new LatLng(27.68819282, 85.3360033),1)); // New Baneshwor chwok
        route9_transports.add(new Transport("ba 1 pa 4021", "bus", 9, new LatLng(27.69363633, 85.32029629),0)); // Maitighar
        route9_transports.add(new Transport("ba 1 pa 4709", "bus", 9, new LatLng(27.70309772, 85.32244206),1)); // Shankar Dev
        route9_transports.add(new Transport("ba 1 pa 4016", "bus", 9, new LatLng(27.6706893, 85.42248400000001),1));// Ratnapark


        route10_transports = new ArrayList<>();

        route10_transports.add(new Transport("ba 1 pa 3015", "micro-bus", 10, new LatLng(27.67326687, 85.38621426),0)); //Thimi
        route10_transports.add(new Transport("ba 1 pa 3016", "micro-bus", 10, new LatLng(27.67387497, 85.37301779),0)); // Gathaghar
        route10_transports.add(new Transport("ba 1 pa 3017", "micro-bus", 10, new LatLng(27.67511016, 85.35338402),1)); //Jadibuti bus stand
        route10_transports.add(new Transport("ba 1 pa 3018", "micro-bus", 10, new LatLng(27.68001278, 85.34947872),0)); //Koteshwor
        route10_transports.add(new Transport("ba 1 pa 3019", "micro-bus", 10, new LatLng(27.68603623, 85.3454876),1)); // Koteshwor Tinkune

        route10_transports.add(new Transport("ba 1 pa 3010", "micro-bus", 10, new LatLng(27.68814532, 85.33623934),0)); // New Baneshwor chowk stand
        route10_transports.add(new Transport("ba 1 pa 3011", "micro-bus", 10, new LatLng(27.69321834, 85.32220602),1)); // Babarmahal
        route10_transports.add(new Transport("ba 1 pa 3020", "micro-bus", 10, new LatLng(27.69976353, 85.31510353),0)); // Shahid gate
        route10_transports.add(new Transport("ba 1 pa 3021", "micro-bus", 10, new LatLng(27.70248979, 85.31360149),1)); // NAC
        route10_transports.add(new Transport("ba 1 pa 3022", "micro-bus", 10, new LatLng(27.70248979, 85.31360149),1)); // NAC

    }

    public ArrayList<Transport> getTransports(int route_no){
        switch (route_no){
            case 9:
                transports = route9_transports;
//                for(Transport transport:transports){
//                    transport.updateLatLng();
//                }
                break;

            case 10:
                transports = route10_transports;

                break;

        }
        return transports;
    }

}
