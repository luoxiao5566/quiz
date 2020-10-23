package com.twuc.shopping.api;

import com.twuc.shopping.domain.Cart;
import com.twuc.shopping.domain.Order;
import com.twuc.shopping.service.CartService;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @PostMapping("/addCart")
    public ResponseEntity addOrder (@RequestBody Cart cart) {
        cartService.addCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/getCart")
    public ResponseEntity getALLOrder () {
        List<Cart> allCart = cartService.getCart();
        return ResponseEntity.ok(allCart);
    }
}
