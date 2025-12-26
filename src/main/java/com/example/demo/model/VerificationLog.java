package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "verification_logs")
public class VerificationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ServiceEntry serviceEntry;

    private LocalDateTime verifiedAt = LocalDateTime.now();
    private Boolean verifiedBySystem = true;
    private String notes;

    public VerificationLog() {}

    // getters & setters
}
