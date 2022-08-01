package com.autoflex.tms.services;

import com.autoflex.tms.entities.Employee;

public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee getEmployee(String email);
    void updateEmployee(Employee employee, String email);
    void deleteEmployee(String email);
}
