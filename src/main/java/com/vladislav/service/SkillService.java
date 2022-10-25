package com.vladislav.service;

import com.vladislav.model.Skill;
import com.vladislav.repository.SkillRepository;
import com.vladislav.repository.hibernate.HiberSkillRepository;

import java.util.List;

public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService() {
        skillRepository = new HiberSkillRepository();
    }

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill getSkillById(int id) {
        return skillRepository.getById(id);
    }

    public List<Skill> getAllSkills() {
        return skillRepository.getAll();
    }

    public Skill addNewSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill updateSkill(Skill skill) {
        return skillRepository.update(skill);
    }

    public boolean deleteSkillById(int id) {
        return skillRepository.deleteById(id);
    }
}
