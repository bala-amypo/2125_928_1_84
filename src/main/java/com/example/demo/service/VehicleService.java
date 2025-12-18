package com.example.demo.service;

import com.example.demo.model.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public Vehicle createVehicle(Vehicle vehicle) {
        if (repo.findByVin(vehicle.getVin()).isPresent()) {
            throw new IllegalArgumentException("VIN");
        }
        return repo.save(vehicle);
    }

    public Vehicle getVehicleById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    public List<Vehicle> getByOwner(Long ownerId) {
        return repo.findByOwnerId(ownerId);
    }

    public void deactivateVehicle(Long id) {
        Vehicle v = getVehicleById(id);
        v.setActive(false);
        repo.save(v);
    }
}
