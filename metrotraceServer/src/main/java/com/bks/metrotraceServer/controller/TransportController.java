package com.bks.metrotraceServer.controller;


import com.bks.metrotraceServer.domain.Transport;
import com.bks.metrotraceServer.service.TransportService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/transport")
public class TransportController {

    @Resource
    private TransportService transportService;

    @GetMapping("/all")
    public List<Transport> getTransport(){

        return transportService.getAllTransports();
    }

    @PostMapping("/save")
    public String saveTransport(@RequestBody Transport transport){
        return transportService.saveTransport(transport);
    }
}
