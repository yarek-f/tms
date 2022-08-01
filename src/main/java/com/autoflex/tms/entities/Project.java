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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Task> taskList;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Employee> employeeList;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private List<Manager> managers;

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

