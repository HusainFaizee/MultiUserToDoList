package com.app.todoapp.controller;

import com.app.todoapp.models.AppUser;
import com.app.todoapp.services.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private final AppUserService appUserService;

    public UserController(AppUserService appUserService){
        this.appUserService = appUserService;
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
        model.addAttribute("user", user);
        return "user-tasks";
    }


}
