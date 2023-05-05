package com.project.sportyshoe.controller;

import com.project.sportyshoe.Entity.Users;
import com.project.sportyshoe.repository.UserRepository;
import com.project.sportyshoe.service.UsersService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserController {
    @Autowired
    private UsersService userService;
    private final Logger Logger =  LoggerFactory.getLogger(UserController.class);

    @GetMapping("/users")
    public List<Users> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public Users addUsers(@RequestBody Users user){
        Logger.info("Added New User");
        return userService.addUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable ("id") Long userId){
        Logger.info("Deleted the  User");
        userService.deleteUser(userId);
        return "Successfully "+userId+" is deleted";
    }
    @PutMapping("/users/{id}")

    public Users updateUserDetails(@PathVariable("id") Long userId, @RequestBody Users user){
        return userService.updateUser(userId,user);
    }

    @PutMapping("addProduct/{userid}/product/{productid}")

    public Users  assignedProductToUsers(@PathVariable("userid")Long userId,@PathVariable("productid")Long productId){
        return userService.assignProductTousers(userId,productId);
    }
}
