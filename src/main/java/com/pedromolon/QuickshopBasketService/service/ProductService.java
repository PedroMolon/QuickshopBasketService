package com.pedromolon.QuickshopBasketService.service;

import com.pedromolon.QuickshopBasketService.client.PlatzStoreClient;
import com.pedromolon.QuickshopBasketService.client.response.PlatziProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final PlatzStoreClient platzStoreClient;

    public ProductService(PlatzStoreClient platzStoreClient) {
        this.platzStoreClient = platzStoreClient;
    }

    public List<PlatziProductResponse> getAllProducts() {
        return platzStoreClient.getAllProducts();
    }

    public PlatziProductResponse getProductById(Long id) {
        return platzStoreClient.getProductById(id);
    }

}
