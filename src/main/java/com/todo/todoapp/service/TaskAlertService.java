package com.todo.todoapp.service;

import com.todo.todoapp.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TaskAlertService implements Runnable {

    @Autowired
    EmailSenderService emailSenderService;

    @Autowired
    TaskService taskService;

    @Override
    public void run() {
        List<Task> taskList = taskService.listarTasks();

        List<Task> tasksToAlert = taskList.stream()
                .filter(task -> task.getDate().minusDays(1).isEqual(now()))
                .toList();

        for (Task task: tasksToAlert
             ) {
            String email = task.getUser().getEmail();
            String subject = "Alert for task: " + task.getTitle();
            String message = task.getDescription();

            emailSenderService.sendEmail(email, subject, message);
        }

    }

    LocalDate now() {return LocalDate.now();}

}
