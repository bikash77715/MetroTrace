package com.bks.metrotraceServer.service;

import com.bks.metrotraceServer.domain.Transport;
import com.bks.metrotraceServer.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    public String saveTransport(Transport transport) {

        if(transportRepository.save(transport) instanceof Transport)
            return "1 transport saved successfully";
        return "Transport save unsuccessful";
    }

    public List<Transport> getAllTransports(){
        return transportRepository.findAll();
    }

//    public List<Transport> getTransportsInGivenRoute(){
//        return transportRepository.findByRoute();
//    }
}
