package com.example.ecommerce.controller;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public List<Cart> getCart() {
        return cartService.getCart();
    }

    @PostMapping("/{variantId}")
    public Cart addToCart(@PathVariable Long variantId, @RequestParam int quantity) {
        return cartService.addToCart(variantId, quantity);
    }

    @PutMapping("/{id}")
    public void updateCart(@PathVariable Long id, @RequestParam int quantity) {
        cartService.updateCart(id, quantity);
    }

    @DeleteMapping("/{id}")
    public void removeFromCart(@PathVariable Long id) {
        cartService.removeFromCart(id);
    }
}
