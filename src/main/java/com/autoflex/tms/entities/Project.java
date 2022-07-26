package com.autoflex.tms.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "projects")
@NoArgsConstructor
@org.hibernate.annotations.Immutable
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> taskList;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Manager manager;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private String description;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    @Column(nullable = false)
    private LocalDate releaseDate;


    public Project(String projectName, Boolean isActive, String description, LocalDate releaseDate) {
        this.projectName = projectName;
        this.isActive = isActive;
        this.description = description;
        this.releaseDate = releaseDate;
    }
}

