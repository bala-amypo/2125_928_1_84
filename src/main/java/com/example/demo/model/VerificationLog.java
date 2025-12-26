// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "verification_logs")
// public class VerificationLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @ManyToOne(optional = false)
//     private ServiceEntry serviceEntry;

//     private LocalDateTime verifiedAt = LocalDateTime.now();

//     private Boolean verifiedBySystem = true;

//     private String notes;

//     public VerificationLog() {
//     }

//     public VerificationLog(ServiceEntry serviceEntry, String notes) {
//         this.serviceEntry = serviceEntry;
//         this.notes = notes;
//     }

//     public Long getId() { return id; }
//     public ServiceEntry getServiceEntry() { return serviceEntry; }
//     public LocalDateTime getVerifiedAt() { return verifiedAt; }
//     public Boolean getVerifiedBySystem() { return verifiedBySystem; }
//     public String getNotes() { return notes; }

//     public void setServiceEntry(ServiceEntry serviceEntry) { this.serviceEntry = serviceEntry; }
//     public void setNotes(String notes) { this.notes = notes; }
// }

// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;
// import java.time.LocalDateTime;

// @Entity
// @Data
// public class VerificationLog {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private LocalDateTime verifiedAt;

//     public void setId(long id) {
//         this.id = id;
//     }

//     public void setVerifiedAt(LocalDateTime verifiedAt) {
//         this.verifiedAt = verifiedAt;
//     }
// }


package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class VerificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private ServiceEntry serviceEntry; // Fixes getServiceEntry() and setServiceEntry() errors
    
    private LocalDateTime verifiedAt;

    public void setId(long id) { this.id = id; }
    public void setVerifiedAt(LocalDateTime verifiedAt) { this.verifiedAt = verifiedAt; }
}