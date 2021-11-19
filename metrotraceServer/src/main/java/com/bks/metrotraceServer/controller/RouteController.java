package com.bks.metrotraceServer.controller;

import com.bks.metrotraceServer.domain.Route;
import com.bks.metrotraceServer.service.RouteService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Resource(name = "routeService")
    private RouteService routeService;

    @GetMapping("/all")
    public List<Route> getRouteInfo(){

        return routeService.getAll();
    }

    @PostMapping("/save")
    public String saveRoute(@RequestBody Route route){

        return routeService.saveRoute(route);
    }

}
