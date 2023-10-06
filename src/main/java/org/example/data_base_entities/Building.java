package org.example.data_base_entities;


import jakarta.persistence.*;



import java.util.ArrayList;
import java.util.List;

@Table(name = "buildings")
@Entity

public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private long buildingId;


    private String name;
    private String street;
    private int number;

    @OneToMany(mappedBy = "building", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Apartment> apartment = new ArrayList<>();

    public List<Apartment> getApartment() {
        return apartment;
    }

    public long getBuildingId() {
        return buildingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
