package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String vin;

    private String make;
    private String model;

    private Long ownerId;

    private Boolean active = true;

    @OneToMany(mappedBy = "vehicle")
    private List<ServiceEntry> serviceEntries;

    // Getters & Setters
    public Long getId() { return id; }
    public String getVin() { return vin; }
    public String getMake() { return make; }
    public String getModel() { return model; }
    public Long getOwnerId() { return ownerId; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setVin(String vin) { this.vin = vin; }
    public void setMake(String make) { this.make = make; }
    public void setModel(String model) { this.model = model; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
    public void setActive(Boolean active) { this.active = active; }
}
