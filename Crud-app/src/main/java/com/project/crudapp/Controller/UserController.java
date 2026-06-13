package com.project.crudapp.Controller;

import com.project.crudapp.Entity.User;
import com.project.crudapp.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    @PostMapping("/addUser")
    public String postUser(@RequestBody User user){
        userServices.saveDetails(user);
        return "User added successfully!";
    }
    @GetMapping("/getAllUser")
    public List<User> getAllUser() {
        return userServices.getAllDetails();
    }
    @GetMapping("/getAllUserByID/{id}")
    public User getUserById(@PathVariable int id) {
        return userServices.getDetailsById(id);
    }
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        userServices.updateDetails(user);
        return "User Updated Successfully!";
    }
    @DeleteMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable int id) {
        return userServices.deleteDetails(id);
    }
}
