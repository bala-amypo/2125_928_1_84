package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
@Tag(name = "Service Part Controller")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ResponseEntity<ServicePart> create(@RequestBody ServicePart part) {
        return ResponseEntity.ok(servicePartService.createPart(part));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicePart> getById(@PathVariable Long id) {
        return ResponseEntity.ok(servicePartService.getById(id));
    }

    @GetMapping("/entry/{entryId}")
    public ResponseEntity<List<ServicePart>> getByEntry(@PathVariable Long entryId) {
        return ResponseEntity.ok(servicePartService.getByEntry(entryId));
    }
}
