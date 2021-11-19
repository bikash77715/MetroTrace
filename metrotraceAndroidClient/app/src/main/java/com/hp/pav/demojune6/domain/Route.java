package com.hp.pav.demojune6.domain;

/**
 * Created by Pav on 6/4/2017.
 */

public class Route {


    protected int route_no;
    protected String name, start_from, end_at, stops;

    public Route() {
    }

    public Route(int route_no, String name, String start_from, String end_at, String stops) {
        this.route_no = route_no;
        this.name = name;
        this.start_from = start_from;
        this.end_at = end_at;
        this.stops = stops;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRoute_no() {
        return route_no;
    }

    public void setRoute_no(int route_no) {
        this.route_no = route_no;
    }

    public String getStart_from() {
        return start_from;
    }

    public void setStart_from(String start_from) {
        this.start_from = start_from;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }
}
