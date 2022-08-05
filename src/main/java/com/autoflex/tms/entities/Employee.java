package com.autoflex.tms.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@org.hibernate.annotations.Immutable
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id")
    private List<Task> taskList;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userData;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Position position;

    public Employee(Long id) {
        this.id = id;
    }

    public Employee(User userData) {
        this.userData = userData;
    }

//    public Employee(Long id, User userData, Position position) {
//        this.id = id;
//        this.userData = userData;
//        this.position = position;
//    }

    public Long getId() {
        return id;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public User getUserData() {
        return userData;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", userData=" + userData +
//                ", position=" + position +
                '}';
    }
}

