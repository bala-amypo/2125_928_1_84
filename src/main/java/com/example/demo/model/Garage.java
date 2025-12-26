package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "garageName"))
public class Garage {

    @Id
    @GeneratedValue
    private Long id;

    private String garageName;
    private String address;
    private Boolean active = true;

    public Long getId() { return id; }
    public String getGarageName() { return garageName; }
    public Boolean getActive() { return active; }

    public void setActive(Boolean active) { this.active = active; }
}
