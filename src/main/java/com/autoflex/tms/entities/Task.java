package com.autoflex.tms.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    public Task(String taskName, String description, Employee employee, Project project, LocalDate deadline, boolean urgent, boolean important, Status status) {
        this.taskName = taskName;
        this.description = description;
        this.employee = employee;
        this.project = project;
        this.deadline = deadline;
        this.urgent = urgent;
        this.important = important;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", description='" + description + '\'' +
                ", deadline=" + deadline +
                ", urgent=" + urgent +
                ", important=" + important +
                ", status=" + status +
                '}';
    }
}
