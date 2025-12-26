// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(
//     name = "vehicles",
//     uniqueConstraints = @UniqueConstraint(columnNames = "vin")
// )
// public class Vehicle {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String vin;

//     private String make;
//     private String model;
//     private Integer year;

//     @Column(nullable = false)
//     private Long ownerId;

//     private Boolean active = true;

//     private LocalDateTime createdAt = LocalDateTime.now();

//     @OneToMany(mappedBy = "vehicle")
//     private List<ServiceEntry> serviceEntries;

//     public Vehicle() {
//     }

//     public Vehicle(String vin, String make, String model, Integer year, Long ownerId, Boolean active) {
//         this.vin = vin;
//         this.make = make;
//         this.model = model;
//         this.year = year;
//         this.ownerId = ownerId;
//         this.active = active;
//     }

//     public Long getId() { return id; }
//     public String getVin() { return vin; }
//     public String getMake() { return make; }
//     public String getModel() { return model; }
//     public Integer getYear() { return year; }
//     public Long getOwnerId() { return ownerId; }
//     public Boolean getActive() { return active; }
//     public LocalDateTime getCreatedAt() { return createdAt; }

//     public void setVin(String vin) { this.vin = vin; }
//     public void setMake(String make) { this.make = make; }
//     public void setModel(String model) { this.model = model; }
//     public void setYear(Integer year) { this.year = year; }
//     public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
//     public void setActive(Boolean active) { this.active = active; }
// }

// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Data;

// @Entity
// @Data
// public class Vehicle {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
//     private String make;
//     private String model;
//     private String licensePlate;

//     // The test requires this specifically
//     public void setId(long id) {
//         this.id = id;
//     }
// }

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String make;
    private String model;
    private String licensePlate;
    private String vin;       // Fixes getVin() error
    private Boolean active;   // Fixes getActive() and setActive() errors

    public void setId(long id) { this.id = id; }
}