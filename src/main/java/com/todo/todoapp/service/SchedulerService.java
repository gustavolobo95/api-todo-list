package com.todo.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {

    @Autowired
    private TaskAlertService service;

    @Scheduled(cron = "0 49 0 * * ?")
    public void sendAlert() {
        service.run();
    }
}
