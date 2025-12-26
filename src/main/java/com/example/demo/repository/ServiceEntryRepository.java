package com.example.demo.repository;

import com.example.demo.model.ServiceEntry;
import com.example.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface ServiceEntryRepository extends JpaRepository<ServiceEntry, Long> {
    
    // Fixes the error in ServiceEntryServiceImpl:[49,17]
    Optional<ServiceEntry> findTopByVehicleOrderByOdometerReadingDesc(Vehicle vehicle);
    
    // Fixes the error in ServiceEntryServiceImpl:[79,38]
    List<ServiceEntry> findByVehicleId(Long vehicleId);

    // Keep the other custom queries from the previous step if they are used in tests
}