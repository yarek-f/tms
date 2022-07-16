package com.autoflex.tms.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manager_id")
    private Long id;

    @OneToMany(mappedBy = "manager")
    private List<Employee> employeeList;

    @Column(name = "user_data")
    private User managerData;



//    @Column(nullable = false)
//    private String fullName;
//
//    @Column(nullable = false, unique = true)
//    private String email;
//
//    @Column(nullable = false)
//    private String password;
//
////    @Column(columnDefinition = "boolean default true")
//    @Column
//    private Boolean isActive;
//
////    @Column(columnDefinition = "timestamp default now()")
//    @Column
//    private LocalDateTime created;
//
////    @Column(columnDefinition = "timestamp default now()")
//    @Column
//    private LocalDateTime updated;
}

