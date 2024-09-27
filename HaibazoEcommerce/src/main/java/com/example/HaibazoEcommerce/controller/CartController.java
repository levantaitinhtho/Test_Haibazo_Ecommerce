package com.example.HaibazoEcommerce.controller;

import com.example.HaibazoEcommerce.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.HaibazoEcommerce.service.CartService;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{customerId}")
    public ResponseEntity<Cart> getCartByCustomerId(@PathVariable Long customerId) {
        Cart cart = cartService.getCartByCustomerId(customerId);
        return cart != null ? new ResponseEntity<>(cart, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{customerId}/items/{productId}")
    public ResponseEntity<Cart> addItemToCart(
            @PathVariable Long customerId,
            @PathVariable Long productId,
            @RequestParam int quantity) {
        Cart cart = cartService.addItemToCart(customerId, productId, quantity);
        return new ResponseEntity<>(cart, HttpStatus.CREATED);
    }

    @DeleteMapping("/items/{cartItemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long cartItemId) {
        Cart cart = cartService.removeItemFromCart(cartItemId);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}

