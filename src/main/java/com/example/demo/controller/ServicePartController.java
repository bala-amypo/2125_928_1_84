package com.example.demo.controller;

import com.example.demo.model.ServicePart;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.example.demo.service.ServicePartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-parts")
public class ServicePartController {

    private final ServicePartService servicePartService;

    public ServicePartController(ServicePartService servicePartService) {
        this.servicePartService = servicePartService;
    }

    @PostMapping
    public ResponseEntity<ServicePart> create(@RequestBody ServicePart part) {
        return ResponseEntity.ok(servicePartService.createPart(part));
    }
}
