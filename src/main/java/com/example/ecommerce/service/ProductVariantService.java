package com.example.ecommerce.service;
import org.springframework.cache.annotation.Cacheable;
import com.example.ecommerce.model.ProductVariant;
import com.example.ecommerce.repository.ProductVariantRepository;
import com.example.ecommerce.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ProductVariantService {
    @Autowired
    private ProductVariantRepository productVariantRepository;
    public ProductVariant getDefaultVariant(Long productId) {
        return productVariantRepository.findByProductId(productId)
                .stream()
                .min(Comparator.comparingDouble(ProductVariant::getPrice))
                .orElseThrow(() -> new ResourceNotFoundException("No variants found for product ID: " + productId));
    }
}
