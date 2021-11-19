package com.bks.metrotraceServer.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int route_no;

    private String route_name;

    @ManyToOne
    private Stop start_stop, end_stop;

    @ManyToMany
    private List<Stop> stops;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoute_no() {
        return route_no;
    }

    public void setRoute_no(int route_no) {
        this.route_no = route_no;
    }

    public String getRoute_name() {
        return route_name;
    }

    public void setRoute_name(String route_name) {
        this.route_name = route_name;
    }

    public Stop getStart_stop() {
        return start_stop;
    }

    public void setStart_stop(Stop start_stop) {
        this.start_stop = start_stop;
    }

    public Stop getEnd_stop() {
        return end_stop;
    }

    public void setEnd_stop(Stop end_stop) {
        this.end_stop = end_stop;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", route_no=" + route_no +
                ", route_name='" + route_name + '\'' +
                ", start_stop=" + start_stop +
                ", end_stop=" + end_stop +
                ", stops=" + stops +
                '}';
    }
}
