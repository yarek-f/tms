package com.autoflex.tms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;

public final class AttachmentDto {
    @NotNull
    @Positive
    private final String id;
    @NotNull
    private final String name;
    @PastOrPresent
    private final String created;
    @PastOrPresent
    private final String updated;

    public AttachmentDto(final String id, final String name, final String created, final String updated) {
        this.id = id;
        this.name = name;
        this.created = created;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "AttachmentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", created='" + created + '\'' +
                ", updated='" + updated + '\'' +
                '}';
    }
}
