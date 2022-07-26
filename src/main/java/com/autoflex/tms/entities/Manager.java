package com.autoflex.tms.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@org.hibernate.annotations.Immutable
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Employee> employeeList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User managerData;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    private Project project;

    public Manager(User managerData, Project project) {
        this.managerData = managerData;
        this.project = project;
    }
}

