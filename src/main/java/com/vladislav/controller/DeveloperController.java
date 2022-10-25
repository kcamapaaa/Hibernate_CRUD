package com.vladislav.controller;

import com.vladislav.model.Developer;
import com.vladislav.service.DeveloperService;

import java.util.List;

public class DeveloperController {
    private final DeveloperService developerService = new DeveloperService();

    public Developer getDeveloperById(int id) {
        return developerService.getDeveloperById(id);
    }

    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    public Developer addNewDeveloper(Developer developer) {
        return developerService.addNewDeveloper(developer);
    }

    public Developer updateDeveloper(Developer developer) {
        return developerService.updateDeveloper(developer);
    }

    public boolean deleteDeveloperById(int id) {
        return developerService.deleteDeveloperById(id);
    }
}
