package com.bks.metrotraceServer.service;

import com.bks.metrotraceServer.domain.Transport;
import com.bks.metrotraceServer.repository.TransportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransportService {

    @Autowired
    private TransportRepository transportRepository;

    public boolean saveTransport(Transport transport) {

        if(transportRepository.save(transport) instanceof Transport)
            return true;
        return false;
    }
}
