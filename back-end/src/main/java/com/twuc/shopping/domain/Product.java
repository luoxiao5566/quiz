package com.twuc.shopping.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull
    private String proName;
    @NotNull
    private int price;
    @NotNull
    private String unit;
    @NotNull
    private String imgURL;
    private int id;

}
