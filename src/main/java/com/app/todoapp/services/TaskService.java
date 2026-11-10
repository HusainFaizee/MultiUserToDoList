package com.app.todoapp.services;

import com.app.todoapp.models.Task;
import com.app.todoapp.respository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

//so spring boot knows that this is a service, enables injection of constructor during runtime
@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }
}
