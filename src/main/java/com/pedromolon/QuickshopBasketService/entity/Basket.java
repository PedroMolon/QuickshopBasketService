package com.pedromolon.QuickshopBasketService.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pedromolon.QuickshopBasketService.entity.enums.PaymentMethod;
import com.pedromolon.QuickshopBasketService.entity.enums.Status;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "basket")
public class Basket {

    private String id;

    private Long client;

    private BigDecimal totalPrice;

    private List<Product> products;

    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private PaymentMethod paymentMethod;

    public void calculateTotalPrice() {
        this.totalPrice = products
                .stream()
                .map(product -> product.getPrice().multiply(BigDecimal.valueOf(product.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
