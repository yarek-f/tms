package com.autoflex.tms.services;

import com.autoflex.tms.dto.TaskDto;
import com.autoflex.tms.entities.Task;

import java.util.List;

public interface TaskService {
    void createTask(TaskDto taskDto);
    List<Task> findByEmail(String email);
    void remove(String id);
    void update(TaskDto taskDto, String id);
    List<Task> findAll();
}
