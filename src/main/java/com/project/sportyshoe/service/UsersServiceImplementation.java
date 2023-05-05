package com.project.sportyshoe.service;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.Entity.Users;
import com.project.sportyshoe.repository.ProductRepository;
import com.project.sportyshoe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UsersServiceImplementation implements UsersService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productsRepository;
    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users addUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public Users updateUser(Long userId, Users user) {
        Users userDB = userRepository.findById(userId).get();
        if (Objects.nonNull(user.getUserName()) && !"".equalsIgnoreCase(user.getUserName())) {
            userDB.setUserName(user.getUserName());
        }
        if (Objects.nonNull(user.getPassword()) && !"".equalsIgnoreCase(user.getPassword())) {
            userDB.setPassword(user.getPassword());
        }
        if (Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
            userDB.setEmail(user.getEmail());
        }
        if (Objects.nonNull(user.getPhone_number()) && !"".equalsIgnoreCase(user.getPhone_number())) {
            userDB.setPhone_number(user.getPhone_number());
        }
        userRepository.save(user);


        return user;
    }

    @Override
    public Users assignProductTousers(Long userId, Long productId) {
        List<Products> productsSet=null;
        Users user = userRepository.findById(userId).get();
        Products product = productsRepository.findById(productId).get();
        productsSet = user.getAssignedProducts();
        productsSet.add(product);
        user.setAssignedProducts(productsSet);
        return userRepository.save(user);

    }
}
