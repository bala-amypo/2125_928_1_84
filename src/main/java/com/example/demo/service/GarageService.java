package com.example.demo.service;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.exception.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageService {

    private final GarageRepository repo;

    public GarageService(GarageRepository repo) {
        this.repo = repo;
    }

    public Garage createGarage(Garage garage) {
        if (repo.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("already exists");
        }
        return repo.save(garage);
    }

    public Garage updateGarage(Long id, Garage garage) {
        Garage g = getGarageById(id);
        g.setAddress(garage.getAddress());
        g.setContactNumber(garage.getContactNumber());
        return repo.save(g);
    }

    public Garage getGarageById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }

    public List<Garage> getAllGarages() {
        return repo.findAll();
    }

    public void deactivateGarage(Long id) {
        Garage g = getGarageById(id);
        g.setActive(false);
        repo.save(g);
    }
}
