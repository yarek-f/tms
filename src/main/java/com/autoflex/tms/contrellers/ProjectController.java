package com.autoflex.tms.contrellers;

import com.autoflex.tms.dto.projectDto.CreateProjectDto;
import com.autoflex.tms.dto.projectDto.ProjectShortResponseDTO;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Resource
    ProjectService projectService;

    @PostMapping("/create")
    public ProjectShortResponseDTO createProject(@Valid @RequestBody CreateProjectDto createProjectDto){
        projectService.createProject(createProjectDto);
        return Mapper.convertToProjectShortResponseDTO(projectService.getProjectByName(createProjectDto.getProjectName()));
    }

    @GetMapping("/all")
    public List<ProjectShortResponseDTO> getAll(){
        return projectService.findAll().stream()
                .map(Mapper::convertToProjectShortResponseDTO)
                .collect(Collectors.toList());
    }

}
