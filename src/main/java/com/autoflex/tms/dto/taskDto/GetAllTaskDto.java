package com.autoflex.tms.dto.taskDto;

import javax.validation.constraints.*;

public final class GetAllTaskDto {
    @NotNull
    @Positive
    private final String id;
    @NotNull
    private final String taskName;
    @Size(min = 10, max = 300, message = "Description must be between 10 and 300 characters")
    private final String description;
    @FutureOrPresent
    private final String deadline;
    @NotNull
    private final String urgent;
    @NotNull
    private final String important;
    @NotNull
    private final String status;
    @PastOrPresent
    private final String created;
    @PastOrPresent
    private final String updated;

    public GetAllTaskDto(final String id, final String taskName, final String description,
                         final String deadline, final String urgent, final String important,
                         final String status, final String created, final String updated) {
        this.id = id;
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.urgent = urgent;
        this.important = important;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public String isUrgent() {
        return urgent;
    }

    public String isImportant() {
        return important;
    }

    public String getStatus() {
        return status;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "GetAllTaskDto{" +
                "id='" + id + '\'' +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", deadline='" + deadline + '\'' +
                ", urgent='" + urgent + '\'' +
                ", important='" + important + '\'' +
                ", status='" + status + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
