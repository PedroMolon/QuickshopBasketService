package com.pedromolon.QuickshopBasketService.repository;

import com.pedromolon.QuickshopBasketService.entity.Basket;
import com.pedromolon.QuickshopBasketService.entity.enums.Status;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BasketRepository extends MongoRepository<Basket, String> {
    Optional<Basket> findByClientAndStatus(Long clientId, Status status);
}
