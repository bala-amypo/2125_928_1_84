package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ServiceEntryService {

    private final ServiceEntryRepository repo;

    public ServiceEntryService(ServiceEntryRepository repo) {
        this.repo = repo;
    }

    public ServiceEntry create(ServiceEntry entry) {

        if (entry.getServiceDate().after(new Date()))
            throw new IllegalArgumentException("future");

        List<ServiceEntry> prev =
                repo.findTopByVehicleOrderByOdometerReadingDesc(entry.getVehicle());

        if (!prev.isEmpty() &&
                entry.getOdometerReading() < prev.get(0).getOdometerReading())
            throw new IllegalArgumentException(">=");

        return repo.save(entry);
    }

    public List<ServiceEntry> getByVehicle(Long vehicleId) {
        return repo.findByVehicleId(vehicleId);
    }
}
