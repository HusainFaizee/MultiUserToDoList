package com.app.todoapp.controller;

import com.app.todoapp.models.AppUser;
import com.app.todoapp.models.Task;
import com.app.todoapp.services.TaskService;
import com.app.todoapp.services.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
public class UserController {
    private final AppUserService appUserService;
    private final TaskService taskService;

    public UserController(AppUserService appUserService, TaskService taskService){
        this.appUserService = appUserService;
        this.taskService = taskService;

    }

    @GetMapping("/users")
    public String showUsers(Model model){
        List<AppUser> users = appUserService.getAllUsers();

        model.addAttribute("users", users);
        return "users";
    }
    @PostMapping("/users")
    public String createUser(@RequestParam String name){
        appUserService.createUser(name);
        return "redirect:/users";
    }
    @GetMapping("/users/{id}")
    public String selectUser(@PathVariable Long id, Model model){
        AppUser user = appUserService.getUserById(id);

        List<Task> tasks = taskService.getTasksByUser(id);
        model.addAttribute("user", user);
        model.addAttribute("tasks", tasks);
        model.addAttribute("today", LocalDate.now(ZoneId.of("Europe/Berlin")));
        return "user-tasks";
    }


}
