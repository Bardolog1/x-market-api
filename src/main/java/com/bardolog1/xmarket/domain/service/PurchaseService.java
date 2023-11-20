package com.bardolog1.xmarket.domain.service;

import com.bardolog1.xmarket.domain.Purchase;
import com.bardolog1.xmarket.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {


    @Autowired
    private PurchaseRepository purchaseRepository;



    public List<Purchase> getAll(){
        return  purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId){
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase savePurchase(Purchase purchase){
        return purchaseRepository.savePurchase(purchase);

    }



}
