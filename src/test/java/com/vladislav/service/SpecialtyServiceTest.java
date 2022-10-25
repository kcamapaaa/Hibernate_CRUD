package com.vladislav.service;

import com.vladislav.model.Specialty;
import com.vladislav.repository.SpecialtyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)

public class SpecialtyServiceTest {
    @Mock
    private SpecialtyRepository specialtyRepository;
    @InjectMocks
    private SpecialtyService specialtyService;
    Specialty checkSpecialty;

    @BeforeEach
    public void setUp() {
        checkSpecialty = new Specialty("Java Developer");
    }

    @Test
    public void shouldReturnSpecialtyIfFound() {
        when(specialtyRepository.getById(anyInt())).thenReturn(checkSpecialty);

        Specialty specialtyById = specialtyRepository.getById(1);

        assertThat(specialtyById).isNotNull().isEqualTo(checkSpecialty);
    }

    @Test
    public void shouldReturnNull() {
        when(specialtyRepository.getById(anyInt())).thenReturn(null);

        Specialty specialty = specialtyRepository.getById(1);

        assertNull(specialty);
    }

    @Test
    public void shouldReturnListOfSpecialties() {
        when(specialtyRepository.getAll()).thenReturn(List.of(checkSpecialty));

        List<Specialty> specialtyList = specialtyRepository.getAll();

        assertThat(specialtyList).contains(checkSpecialty);
    }

    @Test
    public void shouldReturnEmptyList() {
        when(specialtyRepository.getAll()).thenReturn(List.of());

        List<Specialty> specialtyList = specialtyRepository.getAll();

        assertThat(specialtyList).isEmpty();
    }

    @Test
    public void shouldReturnSpecialty() {
        when(specialtyRepository.save(checkSpecialty)).thenReturn(checkSpecialty);

        Specialty specialty = specialtyRepository.save(checkSpecialty);

        assertThat(specialty).isNotNull().isEqualTo(checkSpecialty);
    }

    @Test
    public void shouldReturnSpecialtyIfUpdated() {
        when(specialtyRepository.update(checkSpecialty)).thenReturn(checkSpecialty);

        Specialty specialty = specialtyRepository.update(checkSpecialty);

        assertThat(specialty).isEqualTo(specialty);
    }

    @Test
    public void shouldReturnNullIfNotUpdated() {
        when(specialtyRepository.update(checkSpecialty)).thenReturn(null);

        Specialty specialty = specialtyRepository.update(checkSpecialty);

        assertNull(specialty);
    }

    @Test
    public void shouldReturnTrueIfDeleted() {
        when(specialtyRepository.deleteById(anyInt())).thenReturn(true);

        boolean check = specialtyRepository.deleteById(1);

        assertTrue(check);
    }

    @Test
    public void shouldReturnFalseIfDeleted() {
        when(specialtyRepository.deleteById(anyInt())).thenReturn(false);

        boolean check = specialtyRepository.deleteById(1);

        assertFalse(check);
    }



















}
