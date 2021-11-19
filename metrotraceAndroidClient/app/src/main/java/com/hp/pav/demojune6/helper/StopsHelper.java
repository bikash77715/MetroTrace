package com.hp.pav.demojune6.helper;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pav on 1/9/2018.
 */

public class StopsHelper {
    Map<String, LatLng> stops;


    public Map<String, LatLng> getStopsMap(int route_no) {
        stops = new HashMap();
        switch (route_no){
            case 9:
                stops.put("Bhaktapur", new LatLng(27.67070142, 85.42249918));
                stops.put("Sallaghari", new LatLng(27.6729018, 85.41213949999999));
                stops.put("Niko Shera", new LatLng(27.67980376, 85.39870264));
                stops.put("Sanothimi", new LatLng(27.68254001, 85.3723526));
                stops.put("Jadibuti", new LatLng(27.67668738, 85.35291195));

                stops.put("Koteshwor", new LatLng(27.67986969, 85.34947753));
                stops.put("Baneshwor", new LatLng(27.68819282, 85.3360033));
                stops.put("Maitighar", new LatLng(27.69363633, 85.32029629));
                stops.put("Shankar Dev", new LatLng(27.70309772, 85.32244206));
                stops.put("Ratnapark", new LatLng(27.6706893, 85.42248400000001));

                break;

            case 10:

                stops.put("Thimi", new LatLng(27.67326687, 85.38621426));
                stops.put("Gathaghar", new LatLng(27.67387497, 85.37301779));
                stops.put("Jadibuti", new LatLng(27.67668738, 85.35291195));


                stops.put("Koteshwor", new LatLng(27.67986969, 85.34947753));
                stops.put("Baneshwor", new LatLng(27.68819282, 85.3360033));
                stops.put("Maitighar", new LatLng(27.69363633, 85.32029629));
                stops.put("Shahid gate", new LatLng(27.69976353, 85.31510353));
                stops.put("NAC", new LatLng(27.70248979, 85.31360149));


        }
        return stops;
    }
}
