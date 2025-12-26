package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/garages")
@Tag(name = "Garage Controller")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @PostMapping
    public ResponseEntity<Garage> create(@RequestBody Garage garage) {
        return ResponseEntity.ok(garageService.createGarage(garage));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garage> update(@PathVariable Long id, @RequestBody Garage garage) {
        return ResponseEntity.ok(garageService.updateGarage(id, garage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Garage> getById(@PathVariable Long id) {
        return ResponseEntity.ok(garageService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Garage>> getAll() {
        return ResponseEntity.ok(garageService.getAll());
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable Long id) {
        garageService.deactivate(id);
    }
}
