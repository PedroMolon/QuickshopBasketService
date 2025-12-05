package com.pedromolon.QuickshopBasketService.client.response;

import java.io.Serializable;
import java.math.BigDecimal;

public record PlatziProductResponse(
        String id,
        String title,
        BigDecimal price
) implements Serializable {}
