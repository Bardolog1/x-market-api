package com.bardolog1.xmarket.persistance;

import com.bardolog1.xmarket.domain.Purchase;
import com.bardolog1.xmarket.domain.repository.PurchaseRepository;
import com.bardolog1.xmarket.persistance.crud.CompraCrudRepository;
import com.bardolog1.xmarket.persistance.entity.Compra;
import com.bardolog1.xmarket.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId).map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase savePurchase(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(p -> p.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
