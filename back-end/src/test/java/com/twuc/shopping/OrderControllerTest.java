package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Order;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.po.ProductPO;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    OrderRepository orderRepository;

    @Test
    public void should_add_order() throws Exception {
        Order order = Order.builder().name("可乐").number(2).price(1).unit("瓶").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/od/addOrder").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        List<OrderPO> orderPOS = orderRepository.findAll();
        assertNotNull(orderPOS);
        assertEquals(1,orderPOS.size());
        assertEquals("可乐",orderPOS.get(0).getName());
        assertEquals(1,orderPOS.get(0).getPrice());
        assertEquals(2,orderPOS.get(0).getNumber());
        assertEquals(1,orderPOS.get(0).getId());
        assertEquals("瓶",orderPOS.get(0).getUnit());
    }

    @Test
    public void should_get_all_order() throws Exception {
        Order order = Order.builder().name("可乐").number(2).price(1).unit("瓶").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(order);
        mockMvc.perform(post("/od/addOrder").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/od/getOrder"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].name",is("可乐")))
                .andExpect(jsonPath("$[0].number",is(2)))
                .andExpect(jsonPath("$[0].price",is(1)))
                .andExpect(jsonPath("$[0].unit",is("瓶")))
                .andExpect(status().isOk());
    }
}
