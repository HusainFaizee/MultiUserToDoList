package com.app.todoapp.services;

import com.app.todoapp.models.AppUser;
import com.app.todoapp.respository.AppUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private final AppUserRepository appUserRepository;


    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getAllUsers(){
        return appUserRepository.findAll();
    }

    public AppUser createUser(String name){
        AppUser user = new AppUser();
        user.setName(name);

        return appUserRepository.save(user);
    }

    public AppUser getUserById(Long id){
        return appUserRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid User id"));
    }
}
