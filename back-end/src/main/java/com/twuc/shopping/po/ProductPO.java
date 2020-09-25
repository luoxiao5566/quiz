package com.twuc.shopping.po;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPO {
    @Id
    @GeneratedValue
    private int id;
    @NotNull
    private String proName;
    @NotNull
    private double price;
    @NotNull
    private String unit;
    @NotNull
    private String imgURL;
}
