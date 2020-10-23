package com.twuc.shopping.api;

import com.twuc.shopping.domain.Order;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/od/addOrder")
    public ResponseEntity addOrder (@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/od/getOrder")
    public ResponseEntity getALLOrder () {
        List<Order> allOrder = orderService.getAllOrder();
        return ResponseEntity.ok(allOrder);
    }

}
