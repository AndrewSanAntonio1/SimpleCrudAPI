package com.project.crudapp.Services;

import com.project.crudapp.Entity.User;
import com.project.crudapp.Repository.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {
    @Autowired
    private UserRepo userRepo;

    public User saveDetails(User user) {
       return userRepo.save(user);
    }
    public User getDetailsById(int id) {
        return userRepo.findById(id).orElse(null);
    }
    public List<User> getAllDetails() {
        return userRepo.findAll();
    }
    @Transactional
    public User updateDetails(User user) {
        User existingUser = userRepo.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found!"));
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return existingUser;
    }
    public String deleteDetails(int id) {
        User existingUser = userRepo.findById(id).orElseThrow(()-> new RuntimeException("User not found!"));
        userRepo.delete(existingUser);
        return "User Deleted Successfully!";
    }
}
