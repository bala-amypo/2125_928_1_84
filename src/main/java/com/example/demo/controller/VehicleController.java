// package com.example.demo.controller;

// import com.example.demo.model.Vehicle;
// import com.example.demo.service.VehicleService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/vehicles")
// public class VehicleController {

//     private final VehicleService vehicleService;

//     public VehicleController(VehicleService vehicleService) {
//         this.vehicleService = vehicleService;
//     }

//     @PostMapping
//     public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
//         return ResponseEntity.ok(vehicleService.createVehicle(vehicle));
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Vehicle> getVehicle(@PathVariable Long id) {
//         return ResponseEntity.ok(vehicleService.getVehicleById(id));
//     }

//     @GetMapping("/owner/{ownerId}")
//     public ResponseEntity<List<Vehicle>> getVehiclesByOwner(@PathVariable Long ownerId) {
//         return ResponseEntity.ok(vehicleService.getVehiclesByOwner(ownerId));
//     }

//     @PostMapping("/{id}/deactivate")
//     public ResponseEntity<Void> deactivate(@PathVariable Long id) {
//         vehicleService.deactivateVehicle(id);
//         return ResponseEntity.ok().build();
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.Vehicle;
import com.example.demo.service.VehicleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@Tag(name = "Vehicle Controller")
@SecurityRequirement(name = "bearerAuth")
public class VehicleController {

    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<Vehicle> register(@RequestBody Vehicle vehicle) {
        return ResponseEntity.ok(vehicleService.createVehicle(vehicle));
    }

    // GET /{id}
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
        return ResponseEntity.ok(vehicleService.getVehicleById(id));
    }

    // GET /vin/{vin}
    @GetMapping("/vin/{vin}")
    public ResponseEntity<Vehicle> getByVin(@PathVariable String vin) {
        return ResponseEntity.ok(vehicleService.getVehicleByVin(vin));
    }

    // GET /owner/{ownerId}
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<List<Vehicle>> getByOwner(@PathVariable Long ownerId) {
        return ResponseEntity.ok(vehicleService.getVehiclesByOwner(ownerId));
    }

    // PUT /{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        vehicleService.deactivateVehicle(id);
        return ResponseEntity.ok().build();
    }
}
