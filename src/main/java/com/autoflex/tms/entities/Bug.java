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
    private String name;

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

    public Bug(String name, boolean urgent, boolean important, String description, String detectedVersion) {
        this.name = name;
        this.urgent = urgent;
        this.important = important;
        this.description = description;
        this.detectedDate = LocalDateTime.now();
        this.detectedVersion = detectedVersion;
        this.status = Status.NEW;

    }

}
