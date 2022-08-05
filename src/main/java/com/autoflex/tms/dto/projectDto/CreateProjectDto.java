package com.autoflex.tms.dto.projectDto;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public final class CreateProjectDto {
    @NotNull
    private final String projectName;
    @NotNull
    private final String isActive;
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private final String description;
    @FutureOrPresent
    private final String releaseDate;

    public CreateProjectDto(final String projectName, final String isActive, final String description, final String releaseDate) {
        this.projectName = projectName;
        this.isActive = isActive;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "GetAllProjectDto{" +
                ", projectName='" + projectName + '\'' +
                ", isActive='" + isActive + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
