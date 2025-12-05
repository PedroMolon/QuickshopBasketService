package com.pedromolon.QuickshopBasketService.dto.request;

import java.util.List;

public record BasketRequest(
        Long clientId,
        List<ProductRequest> products
) {}
