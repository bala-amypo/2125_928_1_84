package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import com.example.demo.service.ServicePartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-parts")
@Tag(name = "Service Parts")
public class ServicePartController {

    private final ServicePartService service;

    public ServicePartController(ServicePartService service) {
        this.service = service;
    }

    @PostMapping
    public ServicePart create(@RequestBody ServicePart part) {
        return service.createPart(part);
    }

    @GetMapping("/{id}")
    public ServicePart get(@PathVariable Long id) {
        return service.getPartById(id);
    }

    @GetMapping("/entry/{entryId}")
    public List<ServicePart> list(@PathVariable Long entryId) {
        return service.getPartsForEntry(entryId);
    }
}
