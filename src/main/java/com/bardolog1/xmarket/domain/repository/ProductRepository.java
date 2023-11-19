package com.bardolog1.xmarket.domain.repository;

import com.bardolog1.xmarket.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(int categoryId);
    Optional<List<Product>> getPocaExistencia(int quantity);
    Optional<Product> getProduct(int productId);
    Product saveProducto(Product product);
    void deleteProducto(int productId);
}
