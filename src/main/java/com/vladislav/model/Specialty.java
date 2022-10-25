package com.vladislav.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "specialties")
public class Specialty {
    @Id
    @SequenceGenerator(name = "specialty_seq", sequenceName = "specialty_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialty_seq")
    private int id;
    private String name;
    @OneToMany(mappedBy = "specialty")
    private List<Developer> developer;

    public Specialty(String name) {
        this.name = name;
    }

    public Specialty(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Specialty() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
