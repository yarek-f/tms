package com.autoflex.tms.repositories;

import com.autoflex.tms.entities.Employee;
import com.autoflex.tms.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee readByUserData_Email(String email);
    void removeByUserData_Email(String email);
//    void queryByUserData_EmailAndUserData(String email, User userData);
}
