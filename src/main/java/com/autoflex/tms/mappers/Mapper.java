package com.autoflex.tms.mappers;

import com.autoflex.tms.dto.*;
import com.autoflex.tms.dto.bugDto.CreateBugDto;
import com.autoflex.tms.dto.bugDto.GetAllBugDto;
import com.autoflex.tms.dto.projectDto.CreateProjectDto;
import com.autoflex.tms.dto.projectDto.GetAllProjectDto;
import com.autoflex.tms.dto.projectDto.ProjectShortResponseDTO;
import com.autoflex.tms.dto.taskDto.CreateTaskDto;
import com.autoflex.tms.dto.taskDto.GetAllTaskDto;
import com.autoflex.tms.dto.userDto.CreateUserDto;
import com.autoflex.tms.dto.userDto.GetAllUserDto;
import com.autoflex.tms.entities.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static GetAllTaskDto convertToGetAllTaskDto(Task task) {
        return new GetAllTaskDto(task.getId().toString(), task.getTaskName(), task.getDescription(),
                task.getDeadline().toString(), String.valueOf(task.isUrgent()),
                String.valueOf(task.isImportant()), task.getStatus().toString(),
                task.getCreated().toString(), task.getUpdated().toString());
    }

    public static CreateTaskDto convertToCreateTaskDto(Task task) {
        return new CreateTaskDto(task.getTaskName(), task.getDescription(), task.getDeadline().toString(),
                String.valueOf(task.isUrgent()), String.valueOf(task.isImportant()),
                task.getStatus().toString(), task.getCreated().toString(), task.getUpdated().toString());
    }

    public static Task convertToTask(GetAllTaskDto getAllTaskDto) {
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return new Task(Long.valueOf(getAllTaskDto.getId()), getAllTaskDto.getTaskName(), getAllTaskDto.getDescription(),
                LocalDate.parse(getAllTaskDto.getDeadline(), localDateFormatter),
                Boolean.parseBoolean(getAllTaskDto.isUrgent()), Boolean.parseBoolean(getAllTaskDto.isImportant()),
                Status.valueOf(getAllTaskDto.getStatus()), LocalDateTime.parse(getAllTaskDto.getCreated(),
                localDateTimeFormatter), LocalDateTime.parse(getAllTaskDto.getUpdated(), localDateTimeFormatter));
    }

    public static Task convertToTask(CreateTaskDto createTaskDto) {
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return new Task(createTaskDto.getTaskName(), createTaskDto.getDescription(), LocalDate.parse(createTaskDto.getDeadline(),
                localDateFormatter), Boolean.parseBoolean(createTaskDto.isUrgent()), Boolean.parseBoolean(createTaskDto.isImportant()),
                Status.valueOf(createTaskDto.getStatus()), LocalDateTime.parse(createTaskDto.getCreated(), localDateTimeFormatter),
                LocalDateTime.parse(createTaskDto.getUpdated(), localDateTimeFormatter));
    }

    public static Bug convertToBug(GetAllBugDto getAllBugDto) {
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return new Bug(Long.valueOf(getAllBugDto.getId()), getAllBugDto.getBugName(), Status.valueOf(getAllBugDto.getStatus()),
                Boolean.parseBoolean(getAllBugDto.getUrgent()), Boolean.parseBoolean(getAllBugDto.getImportant()), getAllBugDto.getDescription(),
                getAllBugDto.getDetectedVersion(), getAllBugDto.getResolvedVersion(), LocalDateTime.parse(getAllBugDto.getDetectedDate(), localDateTimeFormatter),
                LocalDateTime.parse(getAllBugDto.getResolvedDate(), localDateTimeFormatter));
    }

    public static Bug convertToBug(CreateBugDto createBugDto) {
        return new Bug(createBugDto.getBugName(), Boolean.parseBoolean(createBugDto.getUrgent()), Boolean.parseBoolean(createBugDto.getImportant()),
                createBugDto.getDescription(), createBugDto.getDetectedVersion());

    }

    public static GetAllBugDto convertToGetAllBugDto(Bug bug) {
        return new GetAllBugDto(String.valueOf(bug.getId()), bug.getBugName(), bug.getStatus().toString(), String.valueOf(bug.isUrgent()),
                String.valueOf(bug.isImportant()), bug.getDescription(), bug.getDetectedVersion(), bug.getResolvedVersion(), bug.getDetectedDate().toString(),
                bug.getResolvedDate().toString());
    }

    public static CreateBugDto convertToCreateBugDto(Bug bug) {
        return new CreateBugDto(bug.getBugName(), bug.getStatus().toString(), String.valueOf(bug.isUrgent()), String.valueOf(bug.isImportant()),
                bug.getDescription(), bug.getDetectedVersion(), bug.getDetectedDate().toString());

    }

    public static Project convertToProject(GetAllProjectDto getAllProjectDto) {
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return new Project(Long.valueOf(getAllProjectDto.getId()), getAllProjectDto.getProjectName(), Boolean.parseBoolean(getAllProjectDto.getIsActive()),
                getAllProjectDto.getDescription(), LocalDateTime.parse(getAllProjectDto.getCreated(), localDateTimeFormatter),
                LocalDateTime.parse(getAllProjectDto.getUpdated(), localDateTimeFormatter),
                LocalDate.parse(getAllProjectDto.getReleaseDate(), localDateFormatter));
    }

    public static Project convertToProject(CreateProjectDto createProjectDto) {
        DateTimeFormatter localDateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return new Project(createProjectDto.getProjectName(), Boolean.parseBoolean(createProjectDto.getIsActive()), createProjectDto.getDescription(),
                        LocalDate.parse(createProjectDto.getReleaseDate(), localDateFormatter));
    }

    public static GetAllProjectDto convertToGetAllProjectDto(Project project) {
        return new GetAllProjectDto(String.valueOf(project.getId()), project.getProjectName(), String.valueOf(project.getActive()),
                    project.getDescription(), project.getCreated() != null ? project.getCreated().toString() : null, project.getUpdated() != null ? project.getUpdated().toString():null,
                    project.getReleaseDate().toString());
    }

    public static CreateProjectDto convertToCreateProjectDto(Project project) {
        return new CreateProjectDto(project.getProjectName(), String.valueOf(project.getActive()), project.getDescription(),
                    project.getReleaseDate().toString());
    }

    public static ProjectShortResponseDTO convertToProjectShortResponseDTO(GetAllProjectDto getAllProjectDto) {
        return new ProjectShortResponseDTO(getAllProjectDto.getId(), getAllProjectDto.getProjectName(), getAllProjectDto.getIsActive(), getAllProjectDto.getDescription(), getAllProjectDto.getReleaseDate());
    }

    public static GetAllUserDto convertToGetAllUserDto(User user) {
        return new GetAllUserDto(
                user.getId().toString(),
                user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().toString(),
                String.valueOf(user.getActive()),
                user.getCreated().toString(),
                user.getUpdated().toString());
    }

    public static CreateUserDto convertToCreateUserDto(User user) {
        return new CreateUserDto(user.getFullName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole().toString(),
                String.valueOf(user.getActive()),
                user.getCreated().toString(),
                user.getUpdated().toString());
    }

    public static User convertToUser(GetAllUserDto getAllUserDto) {
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return new User(Long.valueOf(getAllUserDto.getId()),
                getAllUserDto.getFullName(),
                getAllUserDto.getEmail(),
                getAllUserDto.getPassword(),
                Role.valueOf(getAllUserDto.getRole()),
                Boolean.parseBoolean(getAllUserDto.getIsActive()),
                LocalDateTime.parse(getAllUserDto.getCreated(), localDateTimeFormatter),
                LocalDateTime.parse(getAllUserDto.getUpdated(), localDateTimeFormatter));
    }

    public static User convertToUser(CreateUserDto createUserDto) {
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return new User(createUserDto.getFullName(),
                createUserDto.getEmail(),
                createUserDto.getPassword(),
                Role.valueOf(createUserDto.getRole()),
                Boolean.parseBoolean(createUserDto.getIsActive()),
                LocalDateTime.parse(createUserDto.getCreated(), localDateTimeFormatter),
                LocalDateTime.parse(createUserDto.getUpdated(), localDateTimeFormatter));
    }

    public static Employee convertToEmployee(EmployeeDto employeeDto) {
        return new Employee(Long.valueOf(employeeDto.getId()));
    }

    public static EmployeeDto convertToEmployeeDto(Employee employee) {
        return new EmployeeDto(employee.getId().toString());
    }

    public static AttachmentDto convertToAttachmentDto(Attachment attachment){
        return new AttachmentDto(attachment.getId().toString(), attachment.getName(),
                    attachment.getCreated().toString(), attachment.getUpdated().toString());
    }

    public static Attachment convertToAttachment(AttachmentDto attachmentDto) {
        DateTimeFormatter localDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        return new Attachment(Long.valueOf(attachmentDto.getId()), attachmentDto.getName(),
                LocalDateTime.parse(attachmentDto.getCreated(), localDateTimeFormatter),
                LocalDateTime.parse(attachmentDto.getUpdated(), localDateTimeFormatter));
    }


}
