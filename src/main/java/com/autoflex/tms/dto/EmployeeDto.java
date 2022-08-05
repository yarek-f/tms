package com.autoflex.tms.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public final class EmployeeDto {
    @NotNull
    @Positive
    private final String id;

    public EmployeeDto(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
