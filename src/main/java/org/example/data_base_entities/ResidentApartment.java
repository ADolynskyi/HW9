package org.example.data_base_entities;

import jakarta.persistence.*;

@Table(name = "resident_apartment")
@Entity
public class ResidentApartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "status")
    private String ownership;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "resident_id")
    private Resident resident;

    public long getId() {
        return id;
    }


    public Apartment getApartment() {
        return apartment;
    }

    public Resident getResident() {
        return resident;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
}
