package com.twuc.shopping.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @NotNull
    private String proName;
    @NotNull
    private String price;
    @NotNull
    private int id;
    @NotNull
    private String imgURL;
}
