package com.autoflex.tms.dto.userDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

public final class CreateUserDto {
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

    public CreateUserDto(final String fullName, final String email, final String password,
                   final String role, final String isActive, final String created,
                   final String updated) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isActive = isActive;
        this.created = created;
        this.updated = updated;
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
