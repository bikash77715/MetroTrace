package com.bks.metrotraceServer.controller;


import com.bks.metrotraceServer.domain.Transport;
import com.bks.metrotraceServer.service.TransportService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @Resource
    private TransportService transportService;

    @RequestMapping("/all")
    public String getTransport(){

        return "all transports are returned";
    }

    @PostMapping("/save")
    public boolean saveTransport(@RequestBody Transport transport){
        return transportService.saveTransport(transport);
    }
}
