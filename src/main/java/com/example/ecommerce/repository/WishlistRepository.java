package com.example.ecommerce.repository;

import com.example.ecommerce.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    // Custom method to find wishlist items by productId
    List<Wishlist> findByProductId(Long productId);

    // Custom method to delete a product from the wishlist by productId
    void deleteByProductId(Long productId);
}
