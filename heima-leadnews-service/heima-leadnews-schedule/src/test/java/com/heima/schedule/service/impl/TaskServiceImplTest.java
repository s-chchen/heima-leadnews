package com.heima.schedule.service.impl;

import com.heima.model.schedule.dtos.Task;
import com.heima.schedule.ScheduleApplication;
import com.heima.schedule.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest(classes = ScheduleApplication.class)
@RunWith(SpringRunner.class)
public class TaskServiceImplTest {

    @Autowired
    private TaskService taskService;

    @Test
    public void addTask() {


        Task task = new Task();
        task.setTaskType(100);
        task.setPriority(50);
        task.setParameters("task test".getBytes(StandardCharsets.UTF_8));
        task.setExecuteTime(new Date().getTime());

        long taskId = taskService.addTask(task);
        System.out.println(taskId);

    }


    @Test
    public void cancelTask() {
        boolean bool = taskService.cancelTask(1733774330682773505l);
        System.out.println(bool);
    }


    @Test
    public void poll() {
        Task poll = taskService.poll(100, 50);
        System.out.println(poll);
    }


}