package com.pedromolon.QuickshopBasketService.dto.request;

import com.pedromolon.QuickshopBasketService.entity.enums.PaymentMethod;

public record PaymentRequest(
        PaymentMethod method
) {}
