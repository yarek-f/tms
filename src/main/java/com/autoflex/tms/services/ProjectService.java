package com.autoflex.tms.services;

import com.autoflex.tms.dto.projectDto.CreateProjectDto;
import com.autoflex.tms.dto.projectDto.GetAllProjectDto;

import java.util.List;

public interface ProjectService {
    void createProject(CreateProjectDto createProjectDto);
    GetAllProjectDto getProjectByName(String name);
    void removeByName(String name);
    void update(CreateProjectDto createProjectDto, String name);
    List<GetAllProjectDto> findAll();
}
