package com.autoflex.tms.repositories;

import com.autoflex.tms.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "SELECT * FROM USERS u WHERE u.status = 1")
    List<Task> findByEmployeeEmail(String email);
}
