package org.example.data_base_entities;


import jakarta.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "buildings")
@Entity

public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long building_id;


    private String name;
    private String street;
    private int number;

    @OneToMany(mappedBy ="building", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Apartment> apartment =  new ArrayList<>();

    public List<Apartment> getApartment() {
        return apartment;
    }

    public long getBuilding_id(){
        return building_id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
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
