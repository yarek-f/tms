package com.autoflex.tms.services;

import com.autoflex.tms.dto.projectDto.CreateProjectDto;
import com.autoflex.tms.dto.projectDto.GetAllProjectDto;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.repositories.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createProject(CreateProjectDto createProjectDto) {
        projectRepository.save(Mapper.convertToProject(createProjectDto));
    }

    @Override
    public GetAllProjectDto getProjectByName(String name) {
        return Mapper.convertToGetAllProjectDto(projectRepository.findByProjectName(name));
    }

    @Override
    public void removeByName(String name) {
        projectRepository.deleteByProjectName(name);
    }

    @Override
    public void update(CreateProjectDto createProjectDto, String name) {
        projectRepository.deleteByProjectName(name);
        projectRepository.save(Mapper.convertToProject(createProjectDto));
    }

    @Override
    public List<GetAllProjectDto> findAll() {
        return projectRepository.findAll().stream()
                .map(Mapper::convertToGetAllProjectDto)
                .collect(Collectors.toList());
    }
}
