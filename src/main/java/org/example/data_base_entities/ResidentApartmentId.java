package org.example.data_base_entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ResidentApartmentId implements Serializable {
    public ResidentApartmentId(){}
    @Column(name="resident_id")
    private long residentId;

    @Column(name = "apartment_id")
    private long apartmentId;

    public ResidentApartmentId(long residentId, long apartmentId) {
        this.residentId = residentId;
        this.apartmentId = apartmentId;
    }

    public long getResidentId() {
        return residentId;
    }

    public long getApartmentId() {
        return apartmentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResidentApartmentId that = (ResidentApartmentId) o;
        return residentId == that.residentId && apartmentId == that.apartmentId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentId, apartmentId);
    }
}
