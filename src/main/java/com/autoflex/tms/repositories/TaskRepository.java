package com.autoflex.tms.repositories;

import com.autoflex.tms.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    @Query(value = "select * FROM " +
                    "task ts inner join employee em  on ts.employee_id = em.employee_id  " +
                    "inner join `user` us on em.user_id = us.user_id " +
                    "where us.email = ?1 ", nativeQuery = true)
    List<Task> findTasksByEmployeeEmail(String email);

}
