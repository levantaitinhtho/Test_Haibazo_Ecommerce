package com.example.HaibazoEcommerce.repo;

import com.example.HaibazoEcommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByParentCategoryId(Long parentCategoryId);
    List<Category> findByNameContainingIgnoreCase(String name);
}
