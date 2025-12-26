package com.example.demo.service.impl;

import com.example.demo.model.Garage;
import com.example.demo.repository.GarageRepository;
import com.example.demo.service.GarageService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GarageServiceImpl implements GarageService {

    private final GarageRepository garageRepository;

    public GarageServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public Garage createGarage(Garage garage) {
        if (garageRepository.findByGarageName(garage.getGarageName()).isPresent()) {
            throw new IllegalArgumentException("Garage already exists");
        }
        return garageRepository.save(garage);
    }

    @Override
    public Garage updateGarage(Long id, Garage garage) {
        Garage existing = getById(id);
        existing.setGarageName(garage.getGarageName());
        existing.setAddress(garage.getAddress());
        return garageRepository.save(existing);
    }

    @Override
    public Garage getById(Long id) {
        return garageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Garage not found"));
    }

    @Override
    public List<Garage> getAll() {
        return garageRepository.findAll();
    }

    @Override
    public void deactivate(Long id) {
        Garage g = getById(id);
        g.setActive(false);
        garageRepository.save(g);
    }
}
