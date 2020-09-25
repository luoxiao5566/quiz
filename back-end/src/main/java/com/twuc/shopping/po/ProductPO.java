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
    private String price;
    @NotNull
    private String imgURL;
}
