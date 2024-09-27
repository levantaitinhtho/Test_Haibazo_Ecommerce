package com.example.HaibazoEcommerce.repo;
import com.example.HaibazoEcommerce.entity.UsOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<UsOrder, Long> {
    List<UsOrder> findByCustomerId(Long customerId);
    List<UsOrder> findByOrderStatus(String orderStatus);
}


