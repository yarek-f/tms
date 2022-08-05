package com.autoflex.tms.services;

import com.autoflex.tms.dto.EmployeeDto;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceIml implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void createEmployee(EmployeeDto employeeDto) {
        employeeRepository.save(Mapper.convertToEmployee(employeeDto));
    }

    @Override
    public EmployeeDto getEmployee(String email) {
        return Mapper.convertToEmployeeDto(employeeRepository.getByUserDataEmail(email));
    }

    @Override
    public void remove(String id) {
        employeeRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void update(EmployeeDto employeeDto, String id) {
        employeeRepository.deleteById(Long.valueOf(id));
        employeeRepository.save(Mapper.convertToEmployee(employeeDto));
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(Mapper::convertToEmployeeDto)
                .collect(Collectors.toList());
    }
}
