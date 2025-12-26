// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.util.List;

// @Entity
// @Table(
//     name = "garages",
//     uniqueConstraints = @UniqueConstraint(columnNames = "garageName")
// )
// public class Garage {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String garageName;

//     private String address;
//     private String contactNumber;

//     private Boolean active = true;

//     @OneToMany(mappedBy = "garage")
//     private List<ServiceEntry> serviceEntries;

//     public Garage() {
//     }

//     public Garage(String garageName, String address, String contactNumber, Boolean active) {
//         this.garageName = garageName;
//         this.address = address;
//         this.contactNumber = contactNumber;
//         this.active = active;
//     }

//     public Long getId() { return id; }
//     public String getGarageName() { return garageName; }
//     public String getAddress() { return address; }
//     public String getContactNumber() { return contactNumber; }
//     public Boolean getActive() { return active; }

//     public void setGarageName(String garageName) { this.garageName = garageName; }
//     public void setAddress(String address) { this.address = address; }
//     public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
//     public void setActive(Boolean active) { this.active = active; }
// }

package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    public void setId(long id) {
        this.id = id;
    }
}