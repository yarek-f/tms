package com.autoflex.tms.services;

import com.autoflex.tms.dto.TaskDto;
import com.autoflex.tms.entities.Task;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceIml implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void createTask(TaskDto taskDto) {
        taskRepository.save(Mapper.convertToTask(taskDto));
    }

    @Override
    public List<Task> findByEmail(String email) {
        return taskRepository.findByEmployeeEmail(email);
    }

    @Override
    public void remove(String id) {
        taskRepository.deleteById(Long.valueOf(id));
    }

    @Override
    public void update(TaskDto taskDto, String id) {
        taskRepository.deleteById(Long.valueOf(id));
        taskRepository.save(Mapper.convertToTask(taskDto));
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    //todo crud methods

}
