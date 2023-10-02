package org.example.data_base_entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "osbb")
@Entity
public class Osbb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id")
    Resident resident;

    @OneToMany(mappedBy = "osbb", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ResidentRole> residentRole =new ArrayList<>();

    public long getId() {
        return id;
    }


    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
}
