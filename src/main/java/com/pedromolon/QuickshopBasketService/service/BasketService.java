package com.pedromolon.QuickshopBasketService.service;

import com.pedromolon.QuickshopBasketService.client.response.PlatziProductResponse;
import com.pedromolon.QuickshopBasketService.dto.request.BasketRequest;
import com.pedromolon.QuickshopBasketService.entity.Basket;
import com.pedromolon.QuickshopBasketService.entity.Product;
import com.pedromolon.QuickshopBasketService.entity.enums.Status;
import com.pedromolon.QuickshopBasketService.repository.BasketRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final ProductService productService;

    public Basket getBasketId(String id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Basket not found"));
    }

    public BasketService(BasketRepository basketRepository, ProductService productService) {
        this.basketRepository = basketRepository;
        this.productService = productService;
    }

    public Basket createBasket(BasketRequest request) {
        basketRepository.findByClientAndStatus(request.clientId(), Status.OPEN)
            .ifPresent(basket -> {
                throw new IllegalArgumentException("There is already an open basket for this client");
            });

        List<Product> productList = new ArrayList<>();
        request.products().forEach(product -> {
            PlatziProductResponse response = productService.getProductById(product.id());
            productList.add(Product.builder()
                    .id(response.id())
                    .title(response.title())
                    .price(response.price())
                    .quantity(product.quantity())
                    .build());
        });

        Basket basket = Basket.builder()
                .client(request.clientId())
                .status(Status.OPEN)
                .products(productList)
                .build();

        basket.calculateTotalPrice();
        return basketRepository.save(basket);
    }

}
