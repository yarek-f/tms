package com.autoflex.tms.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @OneToMany(mappedBy = "employee")
    private List<Task> taskList;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(columnDefinition = "boolean default true")
//    @Column
    private Boolean isActive;

//    @Column(columnDefinition = "timestamp default now()")
    @Column
    private LocalDateTime created;

//    @Column(columnDefinition = "timestamp default now()")
    @Column
    private LocalDateTime updated;
}

