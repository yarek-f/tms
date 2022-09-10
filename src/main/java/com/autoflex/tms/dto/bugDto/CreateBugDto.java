package com.autoflex.tms.dto.bugDto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

public final class CreateBugDto { //request
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
    @PastOrPresent //fixme: ???
    private final String detectedDate;

    public CreateBugDto(final String bugName, final String status, final String urgent, final String important, final String description, final String detectedVersion, final String detectedDate) {
        this.bugName = bugName;
        this.status = status;
        this.urgent = urgent;
        this.important = important;
        this.description = description;
        this.detectedVersion = detectedVersion;
        this.detectedDate = detectedDate;
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

    public String getDetectedDate() {
        return detectedDate;
    }


    @Override
    public String toString() {
        return "GetAllBugDto{" +
                ", bugName='" + bugName + '\'' +
                ", status='" + status + '\'' +
                ", urgent='" + urgent + '\'' +
                ", important='" + important + '\'' +
                ", description='" + description + '\'' +
                ", detectedVersion='" + detectedVersion + '\'' +
                ", detectedDate='" + detectedDate + '\'' +
                '}';
    }
}
