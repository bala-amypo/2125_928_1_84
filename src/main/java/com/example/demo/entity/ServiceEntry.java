package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class ServiceEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vehicle vehicle;

    private Date serviceDate;
    private Integer odometerReading;

    public Date getServiceDate() { return serviceDate; }
    public Vehicle getVehicle() { return vehicle; }
    public Integer getOdometerReading() { return odometerReading; }
}
