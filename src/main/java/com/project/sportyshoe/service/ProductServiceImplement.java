package com.project.sportyshoe.service;

import com.project.sportyshoe.Entity.Products;
import com.project.sportyshoe.controller.ProductController;
import com.project.sportyshoe.error.ProductNotFoundException;
import com.project.sportyshoe.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService{
    @Autowired
private ProductRepository productrepository;

    private final Logger Logger = LoggerFactory.getLogger(ProductController.class);


    @Override
    public Products saveProduct(Products product) {

        Logger.debug("Added to the service");
    return productrepository.save(product);
    }

    @Override
    public List<Products> fetchAllProducts() {
        return productrepository.findAll();
    }

    @Override
    public Products fetchProductById(Long productId) throws ProductNotFoundException {
        Optional<Products> product = productrepository.findById(productId);
        if (!product.isPresent()) {

            throw new ProductNotFoundException("Product Not Found");
        }
        return  product.get();


       // return productrepository.findById(productId).get();
    }

    @Override
    public void deleteProducts(Long productId) throws ProductNotFoundException {
        Optional<Products> product = productrepository.findById(productId);
        if (!product.isPresent()) {

            throw new ProductNotFoundException("Product Not Found");
        }

         productrepository.deleteById(productId);

    }

    @Override
    public Products updateProducts(Long productId, Products product) throws ProductNotFoundException {
        Optional<Products> products = productrepository.findById(productId);
        if (!products.isPresent()) {

            throw new ProductNotFoundException("Product Not Found");
        }
        Products dbProduct = products.get();
        if (Objects.nonNull(product.getProductName()) && !"".equalsIgnoreCase(product.getProductName())) {
            dbProduct.setProductName(product.getProductName());
        }
        if (Objects.nonNull(product.getSeason()) && !"".equalsIgnoreCase(product.getSeason())) {
            dbProduct.setSeason(product.getSeason());
        }
        if (Objects.nonNull(product.getBrand()) && !"".equalsIgnoreCase(product.getBrand())) {
            dbProduct.setBrand(product.getBrand());
        }
        if (Objects.nonNull(product.getColor()) && !"".equalsIgnoreCase(product.getColor())) {
            dbProduct.setColor(product.getColor());
        }
        if (Objects.nonNull(product.getCategory()) && !"".equalsIgnoreCase(product.getCategory())) {
            dbProduct.setCategory(product.getCategory());
        }

        if (Objects.nonNull(product.getCreatedDate())) {
            dbProduct.setCreatedDate(product.getCreatedDate());
        }

        if (Objects.nonNull(product.getPrice())) {
            dbProduct.setPrice(product.getPrice());
        }
        if (Objects.nonNull(product.getDiscount()) && !"".equalsIgnoreCase(product.getDiscount())) {
            dbProduct.setDiscount(product.getDiscount());
        }
        if (Objects.nonNull(product.getQuantity())) {
            dbProduct.setQuantity(product.getQuantity());
        }
        return productrepository.save(dbProduct);



    }

    @Override
    public List<Products> fetchProductByName(String productName) {
        return productrepository.findByName(productName);
    }


    @Override
    public Products fetchProductByproductName(String productName) {
        return productrepository.findByProductName(productName);
    }

    @Override
    public List<Products> fetchProductByBrand(String productBrand) {
        return  productrepository.findByBrand(productBrand);
    }

    @Override
    public List<Products> fetchProductByCategory(String productCategory) {
        return  productrepository.findByCategory(productCategory);
    }

    @Override
    public List<Products> fetchProductByPrice(int productPrice) {
        return  productrepository.findByPrice(productPrice);
    }

    @Override
    public List<Products> fetchProductByColor(String productColor) {
        return  productrepository.findByColor(productColor);
    }

    @Override
    public List<Products> fetchProductByDate(int productStartDate, int productEndDate) {
        return productrepository.findByDate(productStartDate, productEndDate);
    }

//    @Override
//    public List<Products> fetchLatestProduct() {
//        return productrepository.fetchLatestProduct();
//    }


}
