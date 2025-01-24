package com.example.ecommerce.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data // Ensure Lombok generates getters and setters
public class ProductVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sku;
    private String name;
    private double price; // Ensure this field exists
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String imageUrl1;
    private String imageUrl2;
    private String imageUrl3;

    // If not using Lombok, manually add getter
    public double getPrice() {
        return price;
    }
}
