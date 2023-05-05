package com.project.sportyshoe.service;

import org.springframework.stereotype.Service;
import com.project.sportyshoe.Entity.Users;

import java.util.List;


public interface UsersService {
    public List<Users> getAllUsers();

    public Users addUser(Users user);

    public void deleteUser(Long userId);

    public Users updateUser(Long userId, Users user);

    public Users assignProductTousers(Long userId, Long productId);
}
