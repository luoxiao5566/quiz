package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Cart;
import com.twuc.shopping.domain.Order;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.CartPo;
import com.twuc.shopping.po.OrderPO;
import com.twuc.shopping.repository.CartRepository;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CartControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    CartRepository cartRepository;

    @Test
    public void should_add_Cart() throws Exception {
        Cart cart = Cart.builder().name("可乐").number(1).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(cart);
        mockMvc.perform(post("/addCart").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        List<CartPo> cartPos = cartRepository.findAll();
        assertNotNull(cartPos);
        assertEquals("可乐",cartPos.get(0).getName());
        assertEquals(1,cartPos.get(0).getNumber());
    }

    @Test
    public void should_get_all_cart() throws Exception {
        Cart cart = Cart.builder().name("可乐").number(1).build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(cart);
        mockMvc.perform(post("/addCart").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        mockMvc.perform(get("/getCart"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].name",is("可乐")))
                .andExpect(jsonPath("$[0].number",is(1)))
                .andExpect(status().isOk());
    }
}
