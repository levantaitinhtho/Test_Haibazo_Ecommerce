package com.example.HaibazoEcommerce.repo;

import com.example.HaibazoEcommerce.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProductId(Long productId);
    List<Review> findByCustomerId(Long customerId);
    List<Review> findByRating(int rating);
}

