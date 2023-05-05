package com.project.sportyshoe.service;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.error.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    public Products saveProduct(Products product);

    public List<Products> fetchAllProducts();


    public Products fetchProductById(Long productId) throws ProductNotFoundException;

    public void deleteProducts(Long productId) throws ProductNotFoundException;

    public Products updateProducts(Long productId, Products product) throws ProductNotFoundException;

    public List<Products> fetchProductByName(String productName);

    public Products fetchProductByproductName(String productName);

    public List<Products> fetchProductByBrand(String productBrand);

    public List<Products> fetchProductByCategory(String productCategory);

    public List<Products> fetchProductByPrice(int productPrice);

    public List<Products> fetchProductByColor(String productColor);

    public List<Products> fetchProductByDate(int productStartDate, int productEndDate);

    //public List<Products> fetchLatestProduct();
}
