package com.project.sportyshoe.controller;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.error.ProductNotFoundException;
import com.project.sportyshoe.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productservice;

    private final Logger Logger = LoggerFactory.getLogger(ProductController.class);
    @PostMapping("/products")
        public Products addProducts(@Valid @RequestBody Products product){
      Logger.info("Added  new Products to the system");
            return productservice.saveProduct(product);
        }

    @GetMapping("/products")
        public List<Products> fetchAllProducts(){
          return productservice.fetchAllProducts();
        }

    @GetMapping("/products/{id}")
    public Products fetchProductById(@PathVariable("id") Long productId) throws ProductNotFoundException {
        return productservice.fetchProductById(productId);
    }
    @DeleteMapping("/products/{id}")
    public String deleteProduct(@PathVariable ("id") Long productId) throws ProductNotFoundException {
        productservice.deleteProducts(productId);
        return "Product Id " +productId + " is Successfully Deleted";

    }

    @GetMapping("/products/name/{name}")
    public List<Products> fetchProductByName(@PathVariable("name") String productName){
        return productservice.fetchProductByName(productName);
    }

    @GetMapping("/products/productName/{name}")
    public Products fetchProductByProductName(@PathVariable("name") String productName){
        return productservice.fetchProductByproductName(productName);
    }

    @GetMapping("/products/brand/{brand}")
    public List<Products> fetchProductByBrand(@PathVariable("brand") String productBrand){
        return productservice.fetchProductByBrand(productBrand);
    }

    @GetMapping("/products/category/{category}")
    public List<Products> fetchProductByCategory(@PathVariable("category") String productCategory){
        return productservice.fetchProductByCategory(productCategory);
    }

    @GetMapping("/products/price/{price}")
    public List<Products> fetchProductByPrice(@PathVariable("price") int productPrice){
        return productservice.fetchProductByPrice(productPrice);
    }

    @GetMapping("/products/color/{color}")
    public List<Products> fetchProductByColor(@PathVariable("color") String productColor){
        return productservice.fetchProductByColor(productColor);
    }

    @GetMapping("/products/date/{date1}/{date2}")
    public List<Products> fetchProductByDate(@PathVariable("date1") int productStartDate , @PathVariable("date2") int productEndDate){
        return productservice.fetchProductByDate( productStartDate,productEndDate);
    }

//    @GetMapping("/products/latest")
//    public List<Products> fetchLatestProduct(){
//        return productservice.fetchLatestProduct();
//    }

    @PutMapping("/products/{id}")
    public Products updateProducts(@PathVariable("id") Long productId,@RequestBody Products product) throws ProductNotFoundException {

    return productservice.updateProducts(productId,product);

    }



}
