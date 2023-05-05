package com.project.sportyshoe.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@ToString(exclude = "products")
public class Users {

    @Id
    @SequenceGenerator(name="user_Sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_Sequence")
    @OrderBy
    private Long  userID;
    private String userName;
    private String password;
    private String email;
    private String phone_number;


//@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//@JoinColumn(name = "product_id", referencedColumnName = "productId")

@ManyToMany
@JoinTable(name ="product_order", joinColumns = @JoinColumn(name = "userid"),inverseJoinColumns = @JoinColumn(name="product_id"))

    private List<Products> assignedProducts = new ArrayList<Products>();

}
