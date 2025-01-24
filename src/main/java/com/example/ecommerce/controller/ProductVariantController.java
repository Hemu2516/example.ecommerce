package com.example.ecommerce.controller;

import com.example.ecommerce.model.ProductVariant;
import com.example.ecommerce.service.ProductVariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product-variants")
public class ProductVariantController {
    @Autowired
    private ProductVariantService productVariantService;

    @GetMapping("/{productId}")
    public ProductVariant getDefaultVariant(@PathVariable Long productId) {
        return productVariantService.getDefaultVariant(productId);
    }
}
