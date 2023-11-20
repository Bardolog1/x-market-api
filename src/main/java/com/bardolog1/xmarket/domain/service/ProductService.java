package com.bardolog1.xmarket.domain.service;

import com.bardolog1.xmarket.domain.Product;
import com.bardolog1.xmarket.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productID){
        return productRepository.getProduct(productID);
    }

    public Optional<List<Product>> getByCategory(int categoryID){
        return productRepository.getByCategory(categoryID);
    }
    public Product saveProducto(Product product){
        return productRepository.saveProduct(product);
    }

    public boolean deleteProduct(int productId){
        return getProduct(productId).map(prod ->{
             productRepository.deleteProduct(productId);
             return true;
        }).orElse(false);
    }

}
