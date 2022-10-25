package com.vladislav.controller;

import com.vladislav.model.Skill;
import com.vladislav.service.SkillService;

import java.util.List;

public class SkillController {
    private final SkillService skillService = new SkillService();

    public Skill getSkillById(int id) {
        return skillService.getSkillById(id);
    }

    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    public Skill addNewSkill(Skill skill) {
        return skillService.addNewSkill(skill);
    }

    public Skill updateSkill(Skill skill) {
        return skillService.updateSkill(skill);
    }

    public boolean deleteSkillById(int id) {
        return skillService.deleteSkillById(id);
    }
}
