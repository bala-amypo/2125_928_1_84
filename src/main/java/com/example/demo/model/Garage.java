package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "garages")
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String garageName;

    private String address;

    private Boolean active = true;

    @OneToMany(mappedBy = "garage")
    private List<ServiceEntry> serviceEntries;

    // Getters & Setters
    public Long getId() { return id; }
    public String getGarageName() { return garageName; }
    public String getAddress() { return address; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setGarageName(String garageName) { this.garageName = garageName; }
    public void setAddress(String address) { this.address = address; }
    public void setActive(Boolean active) { this.active = active; }
}
