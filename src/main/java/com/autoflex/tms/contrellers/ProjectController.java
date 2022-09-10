package com.autoflex.tms.contrellers;

import com.autoflex.tms.dto.projectDto.CreateProjectDto;
import com.autoflex.tms.dto.projectDto.ProjectShortResponseDTO;
import com.autoflex.tms.services.ProjectService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Resource
    ProjectService projectService;

    @PostMapping("/create")
    public ProjectShortResponseDTO createProject(@RequestBody CreateProjectDto createProjectDto){
        return new ProjectShortResponseDTO();
    }
}
