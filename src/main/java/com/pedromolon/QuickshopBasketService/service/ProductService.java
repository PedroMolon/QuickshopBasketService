package com.pedromolon.QuickshopBasketService.service;

import com.pedromolon.QuickshopBasketService.client.PlatzStoreClient;
import com.pedromolon.QuickshopBasketService.client.response.PlatziProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final PlatzStoreClient platzStoreClient;

    public ProductService(PlatzStoreClient platzStoreClient) {
        this.platzStoreClient = platzStoreClient;
    }

    @Cacheable(value = "products")
    public List<PlatziProductResponse> getAllProducts() {
        log.info("Getting all products from PlatzStoreClient");
        return platzStoreClient.getAllProducts();
    }

    @Cacheable(value = "product" , key = "#id")
    public PlatziProductResponse getProductById(Long id) {
        log.info("Getting product with id {} from PlatzStoreClient", id);
        return platzStoreClient.getProductById(id);
    }

}
