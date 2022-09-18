package com.autoflex.tms;

import com.autoflex.tms.entities.*;
import com.autoflex.tms.mappers.Mapper;
import com.autoflex.tms.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalDateTime;

//import java.time.LocalDate;
//import java.time.LocalDateTime;

@SpringBootApplication
public class TmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TmsApplication.class, args);
    }

    @Bean()
    CommandLineRunner init(TaskService taskService, BugService bugService, ProjectService projectService) {
        return args -> {

//
//            Bug firstB = new Bug("smell code", true, true, "pzdc", "777");
//            Bug secondB = new Bug("smell code2", false, true, "pzdc2", "777");
//            Bug secondBB = new Bug("smell code2", true, true, "pzdc2", "777");
//            Bug thirdB = new Bug("smell code3", true, false, "pzdc3", "779");
//
//            bugRepository.save(firstB);
//            bugRepository.save(secondB);
//            bugRepository.save(secondBB);
//            bugRepository.save(thirdB);
            //Project project = new Project("TMS", manager, true, "project description", LocalDate.of(2022, 11, 11));
            Project project = new Project("TMS", true, "project description", LocalDate.of(2022, 11, 11));
            Project project2 = new Project("Hybris Lab", false, "project description 2", LocalDate.of(2022, 8, 30));
            projectService.createProject(Mapper.convertToCreateProjectDto(project));
            projectService.createProject(Mapper.convertToCreateProjectDto(project2));
//            managerService.createManager(manager); fixme: doesn't create
//
//            Employee employee = new Employee(project, manager, new User("Spunch Bob", "bob@gmail.com", "123456", Role.EMPLOYEE));
//            Employee employee2 = new Employee(project, manager, new User("Ann", "ann@gmail.com", "123456", Role.EMPLOYEE));
//            employeeRepository.save(employee);
//            employeeRepository.save(employee2);
//            todo
            Task task = new Task("first task", "description", LocalDate.of(2022, 9, 3),
                    false, true, Status.NEW, LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0));
            Task task2 = new Task("second task", "description 2", LocalDate.of(2022, 7, 31),
                    true, true, Status.NEW, LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0));
            Task task3 = new Task("third task", "description 3", LocalDate.of(2022, 7, 31),
                    true, true, Status.NEW, LocalDateTime.now().withNano(0), LocalDateTime.now().withNano(0));


            Long a = taskService.createTask(Mapper.convertToCreateTaskDto(task));
            System.out.println("Long id \'a\' = " + a);
            a = taskService.createTask(Mapper.convertToCreateTaskDto(task2));
            System.out.println("Long id \'a\' = " + a);
            a = taskService.createTask(Mapper.convertToCreateTaskDto(task3));
            System.out.println("Long id \'a\' = " + a);
//            bugService.createBug(Mapper.convertToGetAllBugDto(firstB));
//            bugService.createBug(Mapper.convertToGetAllBugDto(secondB));
//          todo
// //           List<Task> list  = taskRepository.findTasksByEmployeeEmail("ann@gmail.com");
////            List<Task> list  = taskRepository.findAll();
//            for (Task t : list){
//                System.out.println(t);
//            }

        };
    }

}
