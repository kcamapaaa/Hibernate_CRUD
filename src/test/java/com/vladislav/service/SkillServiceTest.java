package com.vladislav.service;

import com.vladislav.model.Skill;
import com.vladislav.repository.SkillRepository;
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
class SkillServiceTest {
    @Mock
    private SkillRepository skillRepository;
    @InjectMocks
    private SkillService skillService;
    private Skill skill;

    @BeforeEach
    void setUp() {
        skill = new Skill("Coding");
    }

    @Test
    public void shouldReturnSkillById() {
        when(skillRepository.getById(anyInt())).thenReturn(skill);

        Skill skillById = skillService.getSkillById(1);

        assertThat(skillById).isNotNull().isEqualTo(skill);
    }

    @Test
    public void shouldReturnNull() {
        when(skillRepository.getById(anyInt())).thenReturn(null);

        Skill skillById = skillService.getSkillById(10);

        assertNull(skillById);
    }

    @Test
    public void shouldReturnSkillsList() {
        when(skillRepository.getAll()).thenReturn(List.of(skill));

        List<Skill> allSkills = skillService.getAllSkills();

        assertThat(allSkills).isNotNull().contains(skill);
    }

    @Test
    public void shouldReturnEmptyList() {
        when(skillRepository.getAll()).thenReturn(List.of());

        List<Skill> allSkills = skillService.getAllSkills();

        assertThat(allSkills).isEmpty();
    }

    @Test
    public void shouldReturnSkill() {
        when(skillRepository.save(skill)).thenReturn(skill);

        Skill newSkill = skillService.addNewSkill(skill);

        assertThat(newSkill).isNotNull().isEqualTo(skill);
    }

    @Test
    public void shouldReturnSkillIfUpdated() {
        when(skillRepository.update(skill)).thenReturn(skill);

        Skill result = skillService.updateSkill(skill);

        assertThat(result).isEqualTo(skill);
    }

    @Test
    public void shouldReturnNullIfNotUpdated() {
        when(skillRepository.update(skill)).thenReturn(null);

        Skill result = skillService.updateSkill(skill);

        assertNull(result);
    }

    @Test
    public void shouldReturnTrueIfDeleted() {
        when(skillRepository.deleteById(anyInt())).thenReturn(true);

        boolean result = skillService.deleteSkillById(1);

        assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfNotDeleted() {
        when(skillRepository.deleteById(anyInt())).thenReturn(false);

        boolean result = skillService.deleteSkillById(1);

        assertFalse(result);
    }

}