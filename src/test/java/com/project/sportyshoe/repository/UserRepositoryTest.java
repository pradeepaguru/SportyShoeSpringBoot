package com.project.sportyshoe.repository;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.Entity.Users;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository us;
@Test
    public void saveUsers(){
        Products p = Products.builder().productName("ooo").
                price(89).color("Blue").
                brand("Adidas").category("Rely").createdDate(9)
                .quantity(9).discount("9%").season("Rainy").build();

       Users u = Users.builder().userName("Deepa").email("deepa@wsx.com").phone_number("877777777").products(p).password("09900900").build();
       us.save(u);
    }
@Test
    public void getUsers(){

    List<Users> u = us.findAll();
    System.out.println(u);


    }

}