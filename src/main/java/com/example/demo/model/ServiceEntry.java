package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "service_entries")
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Vehicle vehicle;

    @ManyToOne(optional = false)
    private Garage garage;

    private String serviceType;

    private LocalDate serviceDate;

    private Integer odometerReading;

    private String description;

    private LocalDateTime recordedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "serviceEntry")
    private List<ServicePart> parts;

    public ServiceEntry() {
    }

    public ServiceEntry(
            Vehicle vehicle,
            Garage garage,
            String serviceType,
            LocalDate serviceDate,
            Integer odometerReading,
            String description) {

        this.vehicle = vehicle;
        this.garage = garage;
        this.serviceType = serviceType;
        this.serviceDate = serviceDate;
        this.odometerReading = odometerReading;
        this.description = description;
    }

    public Long getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public Garage getGarage() { return garage; }
    public String getServiceType() { return serviceType; }
    public LocalDate getServiceDate() { return serviceDate; }
    public Integer getOdometerReading() { return odometerReading; }
    public String getDescription() { return description; }
    public LocalDateTime getRecordedAt() { return recordedAt; }

    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setGarage(Garage garage) { this.garage = garage; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }
    public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }
    public void setDescription(String description) { this.description = description; }
}
