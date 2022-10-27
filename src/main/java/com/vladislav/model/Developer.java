package com.vladislav.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "developers")
public class Developer {
    @Id
    @SequenceGenerator(name = "developer_seq", sequenceName = "developer_seq_id", allocationSize = 1)
    @GeneratedValue(generator = "developer_seq", strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "skills_developers",
        joinColumns = {@JoinColumn(name = "developer_id")},
        inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    private List<Skill> skills;
    @ManyToOne(fetch = FetchType.EAGER)
    private Specialty specialty;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public Developer() {
    }

    public Developer(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Developer(int id, String firstName, String lastName, List<Skill> skills, Specialty specialty) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.specialty = specialty;
        this.status = Status.ACTIVE;
    }

    public Developer(String firstName, String lastName, List<Skill> skills, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.specialty = specialty;
        this.status = Status.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                ", specialty=" + specialty +
                '}';
    }
}
