package com.example.ecommerce.service;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.ProductVariant;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ProductVariantRepository;
import com.example.ecommerce.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    public List<Cart> getCart() {
        return cartRepository.findAll();
    }

    public Cart addToCart(Long variantId, int quantity) {
        ProductVariant variant = productVariantRepository.findById(variantId)
                .orElseThrow(() -> new ResourceNotFoundException("Product Variant not found"));

        Cart cart = new Cart();
        cart.setProductVariant(variant);
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public void removeFromCart(Long id) {
        cartRepository.deleteById(id);
    }

    public void updateCart(Long id, int quantity) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cart item not found"));
        cart.setQuantity(quantity);
        cartRepository.save(cart);
    }
}
