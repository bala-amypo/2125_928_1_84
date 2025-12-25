package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "service_parts")
public class ServicePart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private ServiceEntry serviceEntry;

    private String partName;
    private String partNumber;
    private BigDecimal cost;
    private Integer quantity;

    public ServicePart() {
    }

    public ServicePart(
            ServiceEntry serviceEntry,
            String partName,
            String partNumber,
            BigDecimal cost,
            Integer quantity) {

        this.serviceEntry = serviceEntry;
        this.partName = partName;
        this.partNumber = partNumber;
        this.cost = cost;
        this.quantity = quantity;
    }

    public Long getId() { return id; }
    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public String getPartName() { return partName; }
    public String getPartNumber() { return partNumber; }
    public BigDecimal getCost() { return cost; }
    public Integer getQuantity() { return quantity; }

    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
    public void setPartName(String partName) { this.partName = partName; }
    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
