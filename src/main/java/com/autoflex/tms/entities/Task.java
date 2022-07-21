package com.autoflex.tms.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
//todo add BUGS class √
//todo add priority √
//todo add attachment files √

@Entity
@NoArgsConstructor
@org.hibernate.annotations.Immutable
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bug> taskList;

    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Attachment> attachmentList;

    @Column(nullable = false)
    private String taskName;

    @Column(name ="task_description")
    private String description;

    @Column
    private LocalDate deadline;

    @Column
    private boolean urgent;

    @Column
    private boolean important;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_status", nullable = false)
    private Status status; //list of changed status

    @Column
    private boolean isActive;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;
}
