package com.autoflex.tms.services;

import com.autoflex.tms.dto.taskDto.CreateTaskDto;
import com.autoflex.tms.dto.taskDto.GetAllTaskDto;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceIml implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(CreateTaskDto createTaskDto) {
        taskRepository.save(Mapper.convertToTask(createTaskDto));
    }

    @Override
    public List<GetAllTaskDto> findTasksByEmail(String email) {
        return taskRepository.findTasksByEmployeeEmail(email).stream()
                .map(Mapper::convertToGetAllTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public void remove(String id) {
        taskRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void update(CreateTaskDto createTaskDto, String id) {
        taskRepository.deleteById(Long.valueOf(id));
        taskRepository.save(Mapper.convertToTask(createTaskDto));
    }

    @Override
    public List<GetAllTaskDto> findAll() {
        return taskRepository.findAll().stream()
                .map(Mapper::convertToGetAllTaskDto)
                .collect(Collectors.toList());
    }
}
