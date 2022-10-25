package com.vladislav.service;

import com.vladislav.model.Specialty;
import com.vladislav.repository.SpecialtyRepository;
import com.vladislav.repository.hibernate.HiberSpecialtyRepository;

import java.util.List;

public class SpecialtyService {
    private final SpecialtyRepository specialtyRepository;

    public SpecialtyService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    public SpecialtyService() {
        specialtyRepository = new HiberSpecialtyRepository();
    }

    public Specialty getSpecialtyById(int id) {
        return specialtyRepository.getById(id);
    }

    public List<Specialty> getAllSpecialties() {
        return specialtyRepository.getAll();
    }

    public Specialty addNewSpecialty(Specialty specialty) {
        return specialtyRepository.save(specialty);
    }

    public Specialty updateSpecialty(Specialty specialty) {
        return specialtyRepository.update(specialty);
    }

    public boolean deleteSpecialtyById(int id) {
        return specialtyRepository.deleteById(id);
    }
}
