package com.example.HaibazoEcommerce.service;

import com.example.HaibazoEcommerce.entity.UsOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HaibazoEcommerce.repo.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<UsOrder> getAllOrders() {
        return orderRepository.findAll();
    }

    public UsOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    public List<UsOrder> getOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    public List<UsOrder> getOrdersByStatus(String status) {
        return orderRepository.findByOrderStatus(status);
    }

    public UsOrder createOrder(UsOrder order) {
        return orderRepository.save(order);
    }

    public UsOrder updateOrder(UsOrder order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

