package com.autoflex.tms.repositories;

import com.autoflex.tms.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
//    Employee getByEmployeeData_Email(String email);
    Employee getByUserDataEmail(String email);
    Employee readByUserData_Email(String email);
    void removeByUserData_Email(String email);
}
