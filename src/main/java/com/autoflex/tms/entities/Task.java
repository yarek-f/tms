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

    @OneToMany(cascade = CascadeType.ALL) //fixme: delete it
    @JoinColumn(name = "task_id")
    private List<Bug> bugList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
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
    private Status status; //todo: list of changed status

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    public Task(String taskName, String description, LocalDate deadline, boolean urgent, boolean important, Status status) {
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.urgent = urgent;
        this.important = important;
        this.status = status;
    }

    public Task(Long id, String taskName, String description, LocalDate deadline, boolean urgent, boolean important, Status status, LocalDateTime created, LocalDateTime updated) {
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

    public Task(String taskName, String description, LocalDate deadline, boolean urgent, boolean important, Status status, LocalDateTime created, LocalDateTime updated) {
        this.taskName = taskName;
        this.description = description;
        this.deadline = deadline;
        this.urgent = urgent;
        this.important = important;
        this.status = status;
        this.created = created;
        this.updated = updated;
    }

    public Long getId() {
        return id;
    }

    public List<Bug> getBugList() {
        return bugList;
    }

    public List<Attachment> getAttachmentList() {
        return attachmentList;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public boolean isImportant() {
        return important;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getUpdated() {
        return updated;
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
