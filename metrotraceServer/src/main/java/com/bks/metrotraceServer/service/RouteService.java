package com.bks.metrotraceServer.service;

import com.bks.metrotraceServer.domain.Route;
import com.bks.metrotraceServer.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("routeService")
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    // return all routes in the system
    public List<Route> getAll(){
        return routeRepository.findAll();
    }

    // save supplied route
    public String saveRoute(Route route){
//        if(routeRepository.findB() instanceof Route)
        if(routeRepository.save(route) instanceof Route)
            return "Route is added";

        return "transaction failed";
    }


}
