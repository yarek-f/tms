package com.autoflex.tms.dto.projectDto;

import javax.validation.constraints.*;

public final class GetAllProjectDto {
    @NotNull
    @Positive
    private final String id;
    @NotNull
    private final String projectName;
    @NotNull
    private final String isActive;
    @Size(min = 10, max = 500, message = "Description must be between 10 and 500 characters")
    private final String description;
    @PastOrPresent
    private final String created;
    @PastOrPresent
    private final String updated;
    @FutureOrPresent
    private final String releaseDate;

    public GetAllProjectDto(final String id, final String projectName, final String isActive, final String description, final String created, final String updated, final String releaseDate) {
        this.id = id;
        this.projectName = projectName;
        this.isActive = isActive;
        this.description = description;
        this.created = created;
        this.updated = updated;
        this.releaseDate = releaseDate;
    }

    public String getId() {
        return id;
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

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "GetAllProjectDto{" +
                "id='" + id + '\'' +
                ", projectName='" + projectName + '\'' +
                ", isActive='" + isActive + '\'' +
                ", description='" + description + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
