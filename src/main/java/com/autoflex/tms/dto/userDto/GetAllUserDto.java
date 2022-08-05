package com.autoflex.tms.dto.userDto;

import javax.validation.constraints.*;

public final class GetAllUserDto {
    @NotNull
    @Positive
    private final String id;
    @NotNull
    private final String fullName;
    @Email
    private final String email;
    @Pattern(regexp = "((?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).{6,20})")
    private final String password;
    @NotNull
    private final String role;
    @NotNull
    private final String isActive;
    @PastOrPresent
    private final String created;
    @PastOrPresent
    private final String updated;

    public GetAllUserDto(final String id, final String fullName, final String email,
                         final String password, final String role, final String isActive,
                         final String created, final String updated) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
        this.created = created;
        this.updated = updated;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getCreated() {
        return created;
    }

    public String getUpdated() {
        return updated;
    }

    @Override
    public String toString() {
        return "GetAllUserDto{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", isActive=" + isActive +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
