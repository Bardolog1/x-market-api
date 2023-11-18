package com.bardolog1.xmarket.persistance;

import com.bardolog1.xmarket.persistance.crud.ProductoCrudRepository;
import com.bardolog1.xmarket.persistance.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {
    private ProductoCrudRepository  productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto>getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getPocaExistencia(int cantidadMinima){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadMinima, true);
    }

}
