package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "vin"))
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String vin;

    private String make;
    private String model;
    private Integer year;
    private Long ownerId;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    public Long getId() { return id; }
    public String getVin() { return vin; }
    public Boolean getActive() { return active; }
    public Long getOwnerId() { return ownerId; }

    public void setVin(String vin) { this.vin = vin; }
    public void setActive(Boolean active) { this.active = active; }
}
