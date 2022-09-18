package com.autoflex.tms.services;

import com.autoflex.tms.dto.taskDto.CreateTaskDto;
import com.autoflex.tms.dto.taskDto.GetAllTaskDto;

import java.util.List;

public interface TaskService {
    Long createTask(CreateTaskDto createTaskDto);
    GetAllTaskDto getById(Long id);
    List<GetAllTaskDto> findTasksByEmail(String email);
    void remove(String id);
    void update(CreateTaskDto createTaskDto, String id);
    List<GetAllTaskDto> findAll();
}
