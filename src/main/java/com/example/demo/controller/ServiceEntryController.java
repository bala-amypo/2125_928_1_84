// package com.example.demo.controller;

// import com.example.demo.model.ServiceEntry;
// import com.example.demo.service.ServiceEntryService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/service-entries")
// public class ServiceEntryController {

//     private final ServiceEntryService serviceEntryService;

//     public ServiceEntryController(ServiceEntryService serviceEntryService) {
//         this.serviceEntryService = serviceEntryService;
//     }

//     @PostMapping
//     public ResponseEntity<ServiceEntry> create(@RequestBody ServiceEntry entry) {
//         return ResponseEntity.ok(serviceEntryService.createServiceEntry(entry));
//     }

//     @GetMapping("/vehicle/{vehicleId}")
//     public ResponseEntity<List<ServiceEntry>> getByVehicle(@PathVariable Long vehicleId) {
//         return ResponseEntity.ok(serviceEntryService.getEntriesForVehicle(vehicleId));
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.ServiceEntry;
import com.example.demo.service.ServiceEntryService;
import io.swagger.v3.oas.annotations.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/service-entries")
@Tag(name = "Service Entry Controller")
@SecurityRequirement(name = "bearerAuth")
public class ServiceEntryController {

    private final ServiceEntryService serviceEntryService;

    public ServiceEntryController(ServiceEntryService serviceEntryService) {
        this.serviceEntryService = serviceEntryService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<ServiceEntry> create(@RequestBody ServiceEntry entry) {
        return ResponseEntity.ok(serviceEntryService.createServiceEntry(entry));
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntry> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serviceEntryService.getEntriesForVehicle(id).get(0));
    }

    // GET /vehicle/{vehicleId}
    @GetMapping("/vehicle/{vehicleId}")
    public ResponseEntity<List<ServiceEntry>> getByVehicle(@PathVariable Long vehicleId) {
        return ResponseEntity.ok(serviceEntryService.getEntriesForVehicle(vehicleId));
    }

    // GET /garage/{garageId}
    @GetMapping("/garage/{garageId}")
    public ResponseEntity<List<ServiceEntry>> getByGarage(@PathVariable Long garageId) {
        return ResponseEntity.ok(
                serviceEntryService.getEntriesForVehicle(garageId)
        );
    }
}
