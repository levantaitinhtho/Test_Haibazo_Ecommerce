package com.example.HaibazoEcommerce.service;

import com.example.HaibazoEcommerce.entity.Cart;
import com.example.HaibazoEcommerce.entity.CartItem;
import com.example.HaibazoEcommerce.entity.Customer;
import com.example.HaibazoEcommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HaibazoEcommerce.repo.CartItemRepository;
import com.example.HaibazoEcommerce.repo.CartRepository;
import com.example.HaibazoEcommerce.repo.CustomerRepository;
import com.example.HaibazoEcommerce.repo.ProductRepository;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomer_Id(customerId);
    }

    public Cart addItemToCart(Long customerId, Long productId, int quantity) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Khách hàng không tồn tại"));


        Cart cart = cartRepository.findByCustomer_Id(customerId);
        if (cart == null) {
            cart = new Cart();
            cart.setCustomer(customer);
        }

        Optional<Product> productOpt = productRepository.findById(productId);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("Sản phẩm không tồn tại");
        }

        Product product = productOpt.get();
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        cart.getCartItems().add(cartItem);
        updateCartTotalPrice(cart);

        cartRepository.save(cart);
        return cart;
    }

    public Cart removeItemFromCart(Long cartItemId) {
        CartItem cartItem = cartItemRepository.findById(cartItemId)
                .orElseThrow(() -> new RuntimeException("Sản phẩm trong giỏ hàng không tồn tại"));
        Cart cart = cartItem.getCart();
        cart.getCartItems().remove(cartItem);
        cartItemRepository.delete(cartItem);

        updateCartTotalPrice(cart);
        cartRepository.save(cart);
        return cart;
    }

    private void updateCartTotalPrice(Cart cart) {
        BigDecimal totalPrice = cart.getCartItems().stream()
                .map(item -> item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        cart.setTotalPrice(totalPrice);
    }
}
