package com.pedromolon.QuickshopBasketService.controller;

import com.pedromolon.QuickshopBasketService.dto.request.BasketRequest;
import com.pedromolon.QuickshopBasketService.dto.request.PaymentRequest;
import com.pedromolon.QuickshopBasketService.entity.Basket;
import com.pedromolon.QuickshopBasketService.entity.enums.PaymentMethod;
import com.pedromolon.QuickshopBasketService.service.BasketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Basket> getBasketById(@PathVariable String id) {
        return ResponseEntity.ok(basketService.getBasketId(id));
    }

    @PostMapping
    public ResponseEntity<Basket> createBasket(@RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(basketService.createBasket(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Basket> updateBasket(@PathVariable String id, @RequestBody BasketRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(basketService.updateBasket(id, request));
    }

    @PutMapping("/{id}/payment")
    public ResponseEntity<Basket> payBasket(@PathVariable String id, @RequestBody PaymentRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(basketService.payBasket(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBasket(@PathVariable String id) {
        basketService.deleteBasket(id);
        return ResponseEntity.noContent().build();
    }

}
