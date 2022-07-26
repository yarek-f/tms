package com.autoflex.tms.services;

import com.autoflex.tms.entities.Employee;
import com.autoflex.tms.entities.Task;
import com.autoflex.tms.repositories.EmployeeRepository;
import com.autoflex.tms.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    //todo crud methods

}
