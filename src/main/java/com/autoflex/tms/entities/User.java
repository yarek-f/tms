package com.autoflex.tms.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne
    @JoinColumn(name = "manager_id", nullable = false)
    private Manager manager;

//    @Column(columnDefinition = "boolean default true")
    @Column
    private Boolean isActive;

//    @Column(columnDefinition = "timestamp default now()")
    @Column
    private LocalDateTime created;

//    @Column(columnDefinition = "timestamp default now()")
    @Column
    private LocalDateTime updated;
}

