package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vin;
    private Boolean active = true;

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
}
