package com.example.HaibazoEcommerce.controller;

import com.example.HaibazoEcommerce.entity.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.HaibazoEcommerce.service.CartItemService;

@RestController
@RequestMapping("/api/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping("/{cartItemId}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long cartItemId) {
        CartItem cartItem = cartItemService.getCartItemById(cartItemId);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<Void> updateCartItemQuantity(
            @PathVariable Long cartItemId,
            @RequestParam int quantity) {
        cartItemService.updateCartItemQuantity(cartItemId, quantity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

