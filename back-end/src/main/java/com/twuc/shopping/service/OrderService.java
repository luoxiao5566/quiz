package com.twuc.shopping.service;


import com.twuc.shopping.domain.Order;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order) {
        OrderPO orderPO = OrderPO.builder()
                .name(order.getName())
                .price(order.getPrice())
                .number(order.getNumber())
                .unit(order.getUnit()).build();
        orderRepository.save(orderPO);
    }

    public List<Order> getAllOrder() {
        List<OrderPO> orderPOS = orderRepository.findAll();
        List<Order> orders = new ArrayList<>();
        for (OrderPO orderPO : orderPOS) {
            Order order = Order.builder().name(orderPO.getName())
                    .price(orderPO.getPrice())
                    .number(orderPO.getNumber())
                    .unit(orderPO.getUnit()).id(orderPO.getId()).build();
            orders.add(order);
        }
        return orders;
    }
}
