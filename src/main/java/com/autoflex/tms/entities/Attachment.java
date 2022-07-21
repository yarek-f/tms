package com.autoflex.tms.entities;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@org.hibernate.annotations.Immutable
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attachment_id")
    private Long id;

    @Column(nullable = false)
    private String name;

//    private File file; todo ??? created column in bd

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;
}

