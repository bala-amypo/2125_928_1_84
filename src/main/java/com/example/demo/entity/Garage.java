package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Garage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String garageName;
    private String address;
    private String contactNumber;
    private Boolean active = true;

    public String getGarageName() { return garageName; }
    public String getAddress() { return address; }
    public String getContactNumber() { return contactNumber; }

    public void setAddress(String address) { this.address = address; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    public void setActive(Boolean active) { this.active = active; }
}
