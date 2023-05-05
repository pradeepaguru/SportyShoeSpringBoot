package com.project.sportyshoe.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Products {


    @Id
    @SequenceGenerator(name="product_Sequence", sequenceName = "product_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_Sequence")
    private Long productId;
@NotBlank(message="Please Add Product Name")
@Length(max =15, min=1)
    private String productName;
    private String season;
    private String brand;




    private String category;
    private int price;
    private String color;
    private int createdDate;
    private String discount;
    private int quantity;

@JsonIgnore
 @ManyToMany(mappedBy = "assignedProducts")
  private List<Users> userSet =new ArrayList<Users>() ;

}
