package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Garage garage;

    private String serviceType;
    private LocalDate serviceDate;
    private Integer odometerReading;

    public Long getId() { return id; }
    public Vehicle getVehicle() { return vehicle; }
    public Garage getGarage() { return garage; }
    public String getServiceType() { return serviceType; }
    public LocalDate getServiceDate() { return serviceDate; }
    public Integer getOdometerReading() { return odometerReading; }

    public void setId(Long id) { this.id = id; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setGarage(Garage garage) { this.garage = garage; }
    public void setServiceType(String serviceType) { this.serviceType = serviceType; }
    public void setServiceDate(LocalDate serviceDate) { this.serviceDate = serviceDate; }
    public void setOdometerReading(Integer odometerReading) { this.odometerReading = odometerReading; }
}
