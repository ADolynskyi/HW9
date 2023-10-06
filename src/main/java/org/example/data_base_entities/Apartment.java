package org.example.data_base_entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "apartments")
@Entity
public class Apartment {
    @OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<ResidentApartment> residentApartment = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "apartment_id")
    private long id;
    private int area;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building_id")
    private Building building;

    public List<ResidentApartment> getResidentApartments() {
        return residentApartment;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
