package com.project.sportyshoe.repository;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.Entity.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class ProductRepositoryTest {
@Autowired
    private ProductRepository productRepository;

    //private TestEntityManager testEntityManager;


    }

    //@BeforeEach
//    void setUp() {
//        Products products = Products.builder().
//                productName("Adidas")
//                .productId(1L)
//                .price(100)
//                .brand("pppp")
//                .color("blue")
//                .category("Season")
//                .discount("3%")
//                .quantity(5)
//                .createdDate(2023-2-12).build();
//
//        testEntityManager.persist(products);
//    }
//    @Test
//    public void whenFindByID_thenReturnProduct(){
//
//        Products p = productRepository.findById(1L).get();
//        assertEquals(p.getProductName(), "Adidas");



