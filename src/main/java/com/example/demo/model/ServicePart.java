package com.example.demo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ServicePart {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private String partName;
    private Integer quantity;
    private BigDecimal cost;

    public Long getId() { return id; }
    public ServiceEntry getServiceEntry() { return serviceEntry; }
    public String getPartName() { return partName; }
    public Integer getQuantity() { return quantity; }

    public void setId(Long id) { this.id = id; }
    public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
    public void setPartName(String partName) { this.partName = partName; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public void setCost(BigDecimal cost) { this.cost = cost; }
}
