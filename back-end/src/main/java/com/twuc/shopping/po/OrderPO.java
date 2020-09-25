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
@Table(name = "my_order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderPO {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int price;
    private int number;
    private String unit;
}
