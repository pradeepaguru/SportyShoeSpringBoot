package com.project.sportyshoe.controller;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.error.ProductNotFoundException;
import com.project.sportyshoe.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ProductService productService;

    private Products product;



    @BeforeEach
    void setUp() {

        product = Products.builder().
                productName("Adidas")
                .productId(1L)
                .price(100)
                .brand("purple")
                .color("blue")
                .category("Season")
                .discount("3%")
                .quantity(5)
                .createdDate(2023-2-12).build();
    }

    @Test
    @DisplayName("Save Product unit test")
    void addProducts() throws Exception {
        Products inputProduct = Products.builder().
                productName("Nike")
                .productId(2L)
                .price(200)
                .brand("pink")
                .color("rose")
                .category("Season")
                .discount("3%")
                .quantity(5)
                .createdDate(2023-2-12).build();

        Mockito.when(productService.saveProduct(inputProduct)).thenReturn(product);

        mockMvc.perform(post("/products").contentType(MediaType.APPLICATION_JSON).content(" {\"productName\": \"Nike\",\n" +
                "        \"season\": \"abi\",\n" +
                "        \"brand\": \"Nike\",\n" +
                "        \"category\": \"Season\",\n" +
                "        \"price\": 200,\n" +
                "        \"color\": \"Green\",\n" +
                "        \"cratedDate\": \"03-03-2023\",\n" +
                "        \"discount\": \"3%\",\n" +
                "        \"quantity\": 5\n" +
                "  }")).andExpect(status().isOk());

    }

    @Test
    void fetchProductById() throws Exception {
        Mockito.when(productService.fetchProductById(1L)).thenReturn(product);

        mockMvc.perform(get("products/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).
                andExpect((ResultMatcher) jsonPath("$.productName").value(product.getProductName()));

    }
}