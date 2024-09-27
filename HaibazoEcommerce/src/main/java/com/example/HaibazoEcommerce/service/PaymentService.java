package com.example.HaibazoEcommerce.service;

import com.example.HaibazoEcommerce.entity.Payment;
import com.example.HaibazoEcommerce.entity.UsOrder;
import com.example.HaibazoEcommerce.repo.OrderRepository;
import com.example.HaibazoEcommerce.repo.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderRepository usOrderRepository; // Khai báo UsOrderRepository

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Payment getPaymentById(Long id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> getPaymentsByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    public List<Payment> getPaymentsByMethod(String method) {
        return paymentRepository.findByPaymentMethod(method);
    }

    public Payment createPayment(Payment payment) {

        UsOrder order = usOrderRepository.findById(payment.getOrder().getId())
                .orElseThrow(() -> new RuntimeException("Order not found"));


        payment.setOrder(order);


        return paymentRepository.save(payment);
    }

    public Payment updatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }
}
