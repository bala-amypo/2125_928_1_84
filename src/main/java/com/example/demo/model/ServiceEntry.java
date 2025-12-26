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
    public Integer getOdometerReading() { return odometerReading; }
}
