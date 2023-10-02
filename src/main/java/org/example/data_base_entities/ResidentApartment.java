package org.example.data_base_entities;

import jakarta.persistence.*;

@Table(name = "resident_apartment")
@Entity
public class ResidentApartment {

    @EmbeddedId
    private ResidentApartmentId ResidentApartmentId;

    @Column(name="status")
    private String ownership;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "apartment_id")
    Apartment apartment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    Resident resident;

    public org.example.data_base_entities.ResidentApartmentId getResidentApartmentId() {
        return ResidentApartmentId;
    }

    public void setResidentApartmentId(org.example.data_base_entities.ResidentApartmentId residentApartmentId) {
        ResidentApartmentId = residentApartmentId;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }
}
