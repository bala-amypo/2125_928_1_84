// package com.example.demo.controller;

// import com.example.demo.model.Garage;
// import com.example.demo.service.GarageService;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/garages")
// public class GarageController {

//     private final GarageService garageService;

//     public GarageController(GarageService garageService) {
//         this.garageService = garageService;
//     }

//     @PostMapping
//     public ResponseEntity<Garage> createGarage(@RequestBody Garage garage) {
//         return ResponseEntity.ok(garageService.createGarage(garage));
//     }
// }


package com.example.demo.controller;

import com.example.demo.model.Garage;
import com.example.demo.service.GarageService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/garages")
@Tag(name = "Garage Controller")
@SecurityRequirement(name = "bearerAuth")
public class GarageController {

    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    // POST /
    @PostMapping
    public ResponseEntity<Garage> create(@RequestBody Garage garage) {
        return ResponseEntity.ok(garageService.createGarage(garage));
    }

    // PUT /{id}
    @PutMapping("/{id}")
    public ResponseEntity<Garage> update(@PathVariable Long id,
                                         @RequestBody Garage garage) {
        garage.setId(id);
        return ResponseEntity.ok(garageService.createGarage(garage));
    }

    // PUT /{id}/deactivate
    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Void> deactivate(@PathVariable Long id) {
        Garage g = garageService.createGarage(new Garage());
        g.setActive(false);
        return ResponseEntity.ok().build();
    }
}
