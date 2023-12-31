package org.example.data_base_entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "residents")
@Entity
public class Resident {
    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<ResidentApartment> residentApartment = new ArrayList<>();
    @OneToMany(mappedBy = "resident", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Osbb> osbb = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "resident_id")
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "family_name")
    private String familyName;
    private String phone;
    private String email;
    @Column(name = "car")
    private boolean driveInPermission;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDriveInPermission() {
        return driveInPermission;
    }

    public void setDriveInPermission(boolean driveInPermission) {
        this.driveInPermission = driveInPermission;
    }

    public List<Osbb> getOsbb() {
        return osbb;
    }
}
