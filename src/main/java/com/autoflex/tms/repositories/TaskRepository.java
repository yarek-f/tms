package com.autoflex.tms.repositories;

import com.autoflex.tms.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "select * FROM " +
                    "((task inner join employee on task.employee_id = employee.employee_id) " +
                    "inner join user on employee.user_id = user.user_id) " +
                    "where user.email = ?1 ", nativeQuery = true)
    List<Task> findByEmployeeEmail(String email);

}
