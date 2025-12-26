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
}
