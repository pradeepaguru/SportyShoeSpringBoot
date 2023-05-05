package com.project.sportyshoe.repository;

import com.project.sportyshoe.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query("SELECT p FROM Products p WHERE productName= ?1")
   public List<Products> findByName(String productName);

    @Query("SELECT p FROM Products p WHERE brand= ?1")
    public List<Products> findByBrand(String productBrand);
    @Query("SELECT p FROM Products p WHERE category= ?1")
    public List<Products> findByCategory(String productCategory);

    @Query("SELECT p FROM Products p WHERE price= ?1")
    public List<Products> findByPrice(int productPrice);
    @Query("SELECT p FROM Products p WHERE color= ?1")
    public List<Products> findByColor(String productColor);
    @Query("SELECT p FROM Products p where createdDate between ?1 and ?2")
    public List<Products> findByDate(int productStartDate, int productEndDate);

    public Products findByProductName(String productName);
//@Query("SELECT p.productId, p.productName, p.brand, p.category,p.color,p.price,p.quantity,p.discount,p.season,p.createdDate\n" +
//        "FROM Products p\n" +
//        "WHERE p.createdDate=(\n" +
//        "SELECT MAX(p.createdDate) FROM Products )")
 //public List<Products> fetchLatestProduct();
}
