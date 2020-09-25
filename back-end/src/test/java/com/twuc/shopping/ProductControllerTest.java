package com.twuc.shopping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.domain.Order;
import com.twuc.shopping.domain.Product;
import com.twuc.shopping.po.ProductPO;
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
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ProductRepository productRepository;

    @Test
    public void should_add_product() throws  Exception{
        Product product = Product.builder().
                imgURL("F:/TWU-C/img/apple.png").
                price(100).proName("apple").unit("个").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/pd/addPro").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        List<ProductPO> productPOS = productRepository.findAll();
        assertNotNull(productPOS);
        assertEquals(1,productPOS.size());
        assertEquals("F:/TWU-C/img/apple.png",productPOS.get(0).getImgURL());
        assertEquals(100,productPOS.get(0).getPrice());
        assertEquals("apple",productPOS.get(0).getProName());
        assertEquals(1,productPOS.get(0).getId());
        assertEquals("个",productPOS.get(0).getUnit());
    }

    @Test
    public void should_get_all_product() throws Exception {
        Product product = Product.builder().
                imgURL("F:/TWU-C/img/apple.png").
                price(100).proName("apple").unit("个").build();
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(product);
        mockMvc.perform(post("/pd/addPro").content(jsonString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
        mockMvc.perform(get("/pd/getPro"))
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].proName",is("apple")))
                .andExpect(jsonPath("$[0].imgURL",is("F:/TWU-C/img/apple.png")))
                .andExpect(jsonPath("$[0].price",is(100)))
                .andExpect(jsonPath("$[0].unit",is("个")))
                .andExpect(status().isOk());
    }
}
