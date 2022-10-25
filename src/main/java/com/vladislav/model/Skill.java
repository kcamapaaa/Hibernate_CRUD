package com.vladislav.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
public class Skill {
    @Id
    @SequenceGenerator(name = "skill_seq", sequenceName = "skill_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "skill_seq")
    private int id;
    private String name;
    @ManyToMany(mappedBy = "skills")
    private List<Developer> developers;

    public Skill(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill() {
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

    public List<Developer> getDevelopers() {
        return developers;
    }

    public void setDevelopers(List<Developer> developers) {
        this.developers = developers;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
