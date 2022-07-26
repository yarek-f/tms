package com.autoflex.tms.repositories;

import com.autoflex.tms.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
