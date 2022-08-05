package com.autoflex.tms.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@org.hibernate.annotations.Immutable
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bug_id")
    private Long id;

    @Column
    private String bugName;

    @Enumerated(EnumType.STRING)
    @Column
    private Status status;

    @Column
    private boolean urgent;

    @Column
    private boolean important;

    @Column
    private String description;

    @Column
    private String detectedVersion;

    @Column
    private String resolvedVersion;

    @Column
    private LocalDateTime detectedDate;

    @Column
    private LocalDateTime resolvedDate;

    public Bug(String bugName, boolean urgent, boolean important, String description, String detectedVersion) {
        this.bugName = bugName;
        this.urgent = urgent;
        this.important = important;
        this.description = description;
        this.detectedDate = LocalDateTime.now();
        this.detectedVersion = detectedVersion;
        this.status = Status.NEW;
    }

    public Bug(Long id, String bugName, Status status, boolean urgent, boolean important, String description, String detectedVersion, String resolvedVersion, LocalDateTime detectedDate, LocalDateTime resolvedDate) {
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

    public Long getId() {
        return id;
    }

    public String getBugName() {
        return bugName;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isImportant() {
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

    public LocalDateTime getDetectedDate() {
        return detectedDate;
    }

    public LocalDateTime getResolvedDate() {
        return resolvedDate;
    }
}
