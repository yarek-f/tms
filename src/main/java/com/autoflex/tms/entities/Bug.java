package com.autoflex.tms.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bug_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private Task task;

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

}
