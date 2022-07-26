package com.autoflex.tms.services;

import com.autoflex.tms.entities.Project;
import com.autoflex.tms.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProject(Project project) {
        projectRepository.save(project);
    }
}
