package com.twuc.shopping.service;

import com.twuc.shopping.domain.Cart;
import com.twuc.shopping.domain.Order;
import com.twuc.shopping.po.CartPo;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.CartRepository;

import java.util.ArrayList;
import java.util.List;

public class CartService {
    final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addCart(Cart cart) {
        CartPo cartPo = CartPo.builder().name(cart.getName()).number(cart.getNumber()).build();
        cartRepository.save(cartPo);
    }

    public List<Cart> getCart() {
        List<CartPo> cartPos = cartRepository.findAll();
        List<Cart> carts = new ArrayList<>();
        for (CartPo cartPo : cartPos) {
            Cart cart = Cart.builder().name(cartPo.getName())
                    .number(cartPo.getNumber())
                    .build();
            carts.add(cart);
        }
        return carts;
    }
}
