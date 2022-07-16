package com.autoflex.tms.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(nullable = false)
    private String projectName;

    @OneToMany
    private List<Task> taskList;

    //todo add list employee
    @OneToMany
    private List<Employee> employeeList;

    @Column(nullable = false)
    private Boolean isActive;

    @Column(nullable = false)
    private String description;

//    @Column(columnDefinition = "timestamp default now()")
    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    @Column(nullable = false)
    private LocalDate releaseDate;

}

