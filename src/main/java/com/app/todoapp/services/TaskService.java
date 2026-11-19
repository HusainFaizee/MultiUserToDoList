package com.app.todoapp.services;

import com.app.todoapp.models.AppUser;
import com.app.todoapp.models.Task;
import com.app.todoapp.respository.AppUserRepository;
import com.app.todoapp.respository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//so spring boot knows that this is a service, enables injection of constructor during runtime
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final AppUserRepository appUserRepository;

    public TaskService(TaskRepository taskRepository,AppUserRepository appUserRepository) {
        this.taskRepository = taskRepository;
        this.appUserRepository = appUserRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        if(task.isCompleted()){
            task.setCompleted(false);
            task.setCompletedAt(null);
        } else{
            task.setCompleted(true);
            task.setCompletedAt(LocalDateTime.now());
        }
        taskRepository.save(task);
    }

    public List<Task> getTasksByUser(Long userId){
        return taskRepository.findByUserId(userId);
    }

    public void addTask(String title, Long userId){
        AppUser user = appUserRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Task task = new Task();
        task.setTitle(title);
        task.setUser(user);
        taskRepository.save(task);
    }



}
