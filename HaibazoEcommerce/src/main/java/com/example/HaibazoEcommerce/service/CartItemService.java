package com.example.HaibazoEcommerce.service;

import com.example.HaibazoEcommerce.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HaibazoEcommerce.repo.CartItemRepository;

@Service
public class CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    public CartItem getCartItemById(Long cartItemId) {
        return cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm trong giỏ hàng không tồn tại"));
    }

    public void updateCartItemQuantity(Long cartItemId, int quantity) {
        CartItem cartItem = getCartItemById(cartItemId);
        cartItem.setQuantity(quantity);
        cartItemRepository.save(cartItem);
    }
}

