package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class VerificationLog {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private LocalDateTime verifiedAt = LocalDateTime.now();
    private Boolean verifiedBySystem = true;
    private String notes;
}
