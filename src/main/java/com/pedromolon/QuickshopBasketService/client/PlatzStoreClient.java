package com.pedromolon.QuickshopBasketService.client;

import com.pedromolon.QuickshopBasketService.client.response.PlatziProductResponse;
import com.pedromolon.QuickshopBasketService.exceptions.CustomErrorDecoder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PlatziStoreClient", url = "${basket.client.platzi}", configuration = {CustomErrorDecoder.class})
public interface PlatzStoreClient {

    @GetMapping("/products")
    public List<PlatziProductResponse> getAllProducts();

    @GetMapping("/products/{id}")
    public PlatziProductResponse getProductById(@PathVariable Long id);

}
