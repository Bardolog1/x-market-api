package com.bardolog1.xmarket.domain.repository;

import com.bardolog1.xmarket.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepositoryy {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);

    Purchase savePurchase(Purchase purchase);

}
