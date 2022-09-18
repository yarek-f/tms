package com.autoflex.tms.dto.projectDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ProjectShortResponseDTO {
    private String id;
    private String projectName;
    private String isActive;
    private String description;
    private String releaseDate;
}
