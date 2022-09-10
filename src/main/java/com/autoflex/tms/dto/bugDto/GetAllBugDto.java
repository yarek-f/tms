package com.autoflex.tms.dto.bugDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public final class GetAllBugDto { //response
    @NotNull
    @Positive
    private final String id;
    @NotNull(message = "bugName cannot be null")
    private final String bugName;
    @NotNull
    private final String status;
    @NotNull
    private final String urgent;
    @NotNull
    private final String important;
    @Size(max = 200, message = "Description must be between 0 and 200 characters")
    private final String description;
    @NotNull
    private final String detectedVersion;
    @NotNull
    private final String resolvedVersion;
    @PastOrPresent //fixme: ???
    private final String detectedDate;
    private final String resolvedDate;

    public GetAllBugDto(final String id, final String bugName, final String status, final String urgent, final String important, final String description, final String detectedVersion, final String resolvedVersion, final String detectedDate, final String resolvedDate) {
        this.id = id;
        this.bugName = bugName;
        this.status = status;
        this.urgent = urgent;
        this.important = important;
        this.description = description;
        this.detectedVersion = detectedVersion;
        this.resolvedVersion = resolvedVersion;
        this.detectedDate = detectedDate;
        this.resolvedDate = resolvedDate;
    }

    public String getId() {
        return id;
    }

    public String getBugName() {
        return bugName;
    }

    public String getStatus() {
        return status;
    }

    public String getUrgent() {
        return urgent;
    }

    public String getImportant() {
        return important;
    }

    public String getDescription() {
        return description;
    }

    public String getDetectedVersion() {
        return detectedVersion;
    }

    public String getResolvedVersion() {
        return resolvedVersion;
    }

    public String getDetectedDate() {
        return detectedDate;
    }

    public String getResolvedDate() {
        return resolvedDate;
    }

    @Override
    public String toString() {
        return "GetAllBugDto{" +
                "id='" + id + '\'' +
                ", bugName='" + bugName + '\'' +
                ", status='" + status + '\'' +
                ", urgent='" + urgent + '\'' +
                ", important='" + important + '\'' +
                ", description='" + description + '\'' +
                ", detectedVersion='" + detectedVersion + '\'' +
                ", resolvedVersion='" + resolvedVersion + '\'' +
                ", detectedDate='" + detectedDate + '\'' +
                ", resolvedDate='" + resolvedDate + '\'' +
                '}';
    }
}
