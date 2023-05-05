package com.project.sportyshoe.service;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.error.ProductNotFoundException;
import com.project.sportyshoe.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductServiceTest {

    @Autowired
    private ProductService productService;

    private static ProductRepository productRepository;


    @BeforeEach
    void setUp() {
        Products products = Products.builder().
                productName("Adidas")
                .productId(1L)
                .price(100)
                .brand("pppp")
                .color("blue")
                .category("Season")
                .discount("3%")
                .quantity(5)
                .createdDate(2023-2-12).build();

        Mockito.when(productRepository.findByProductName("Adidas")).thenReturn(products);

    }

    @Test
@Disabled
    @DisplayName("Test Case for finding product anme")
    public void whenValidProductName_theProductShouldFound(){
        String productName = "Adidas";
        Products found = productService.fetchProductByproductName(productName);
        System.out.println("Expected"+ productName);
        System.out.println("Actual"+ found.getProductName());
        assertEquals(productName, found.getProductName());


    }

    @Test
    @Disabled
    @DisplayName("Test Case for finding productID")
    public void whenValidProductId_theProductShouldFound() throws ProductNotFoundException {
        Long productId= 1L;
        Products found = productService.fetchProductById(productId);
        System.out.println("Expected"+ productId);
        System.out.println("Actual"+ found.getProductName());
        assertEquals(productId, found.getProductName());




    }
}




