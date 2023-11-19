package com.bardolog1.xmarket.persistance;

import com.bardolog1.xmarket.domain.Product;
import com.bardolog1.xmarket.domain.repository.ProductRepository;
import com.bardolog1.xmarket.persistance.crud.ProductoCrudRepository;
import com.bardolog1.xmarket.persistance.entity.Producto;
import com.bardolog1.xmarket.persistance.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {
    private ProductoCrudRepository  productoCrudRepository;
    private ProductMapper mapper;


    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos =  productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getPocaExistencia(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity, true);
        return productos.map(products-> mapper.toProducts(products));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(produ -> mapper.toProduct(produ));
    }

    @Override
    public Product saveProducto(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }




    @Override
    public void deleteProducto(int idProducto){
        productoCrudRepository.deleteById(idProducto);

    }

}
