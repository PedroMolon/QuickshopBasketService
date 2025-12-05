package com.pedromolon.QuickshopBasketService.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    private String id;
    private String title;
    private BigDecimal price;
    private Integer quantity;

}
