package com.autoflex.tms.services;

import com.autoflex.tms.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    void createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployee(String email);
    void remove(String id);
    void update(EmployeeDto employeeDto, String id);
    List<EmployeeDto> findAll();
}
