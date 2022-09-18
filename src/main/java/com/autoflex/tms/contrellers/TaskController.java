package com.autoflex.tms.contrellers;

import com.autoflex.tms.dto.taskDto.CreateTaskDto;
import com.autoflex.tms.dto.taskDto.GetAllTaskDto;
import com.autoflex.tms.services.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Resource
    TaskService taskService;

    @PostMapping("/create")
    public GetAllTaskDto createTask(@RequestBody CreateTaskDto createTaskDto){
        Long id = taskService.createTask(createTaskDto);
        return taskService.getById(id);
    }

    @GetMapping("/all")
    public List<GetAllTaskDto> getAll(){
        return taskService.findAll();
    }
}
