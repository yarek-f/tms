package com.autoflex.tms.mappers;

import com.autoflex.tms.dto.TaskDto;
import com.autoflex.tms.entities.Status;
import com.autoflex.tms.entities.Task;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static TaskDto convertToTaskDto(Task task){
        if (task.getId() != null && !task.getId().equals("")) {
            return new TaskDto(task.getId().toString(), task.getTaskName(), task.getDescription(), task.getDeadline().toString(),
                    String.valueOf(task.isUrgent()), String.valueOf(task.isImportant()), task.getStatus().toString(), task.getCreated().toString(), task.getUpdated().toString());
        } else {
            return new TaskDto(task.getTaskName(), task.getDescription(), task.getDeadline().toString(),
                    String.valueOf(task.isUrgent()), String.valueOf(task.isImportant()), task.getStatus().toString(), task.getCreated().toString(), task.getUpdated().toString());
        }
    }
    public static Task convertToTask(TaskDto taskDto){
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        if (taskDto.getId() != null && !taskDto.getId().equals("")){
            return new Task(Long.valueOf(taskDto.getId()), taskDto.getTaskName(), taskDto.getDescription(), LocalDate.parse(taskDto.getDeadline(), localDateFormatter),
                    Boolean.parseBoolean(taskDto.isUrgent()), Boolean.parseBoolean(taskDto.isImportant()), Status.valueOf(taskDto.getStatus()), LocalDateTime.parse(taskDto.getCreated(), localDateTimeFormatter), LocalDateTime.parse(taskDto.getUpdated(), localDateTimeFormatter));

        } else{
            return new Task(taskDto.getTaskName(), taskDto.getDescription(), LocalDate.parse(taskDto.getDeadline(), localDateFormatter),
                    Boolean.parseBoolean(taskDto.isUrgent()), Boolean.parseBoolean(taskDto.isImportant()), Status.valueOf(taskDto.getStatus()), LocalDateTime.parse(taskDto.getCreated(), localDateTimeFormatter), LocalDateTime.parse(taskDto.getUpdated(), localDateTimeFormatter));
        }
    }
}
