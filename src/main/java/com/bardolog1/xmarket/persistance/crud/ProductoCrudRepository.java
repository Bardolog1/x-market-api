package com.bardolog1.xmarket.persistance.crud;

import com.bardolog1.xmarket.persistance.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {


    /* ==================  Query Methods  ================== */
    /* Deben cumplir con la estructura correcta en su definición
     *   *Para buscar por y ordenar:
     *      - TipoRetorno findBy{1}OrderBy{2}{3}(tipoParam nomParam);
     *       donde {1} : es donde debe ir el atributo que tomaremos para buscar, a tener
     *       en cuenta que se debe respetar el CamelCase de la declaración, por encima del
     *       camelCase definido para el atributo, Ejemplo:
     *
     *       *  Buscar por idCategoria, para este seria:
     *           List<Producto> findByIdCategoria(int idCategoria);
     *
     *          {2} : el atributo "columna" porlña cual queremos ordenar, respetando el
     *                CamelCase de la declaración
     *          {3} : se coloca si va a ser ordenante Ascendente (Asc) o desendente (Des)
     */

    /* ==================  Query Nativos  ================== */
    /*
    *  En los casos de querer usar sentenciaqs SQL Nativas se pueden implementar
    * en la forma:
    *
    *   - Usando la anotación @Query
    *      *Se debe pasar como parametro de la anotacion el value que es la sentencia SQL
    *      *Se debe indicar que es un query nativo en los parametros de la anotacion
    *
    *       Estructura anotacion:
    *
    *       @Query(value ="{query sql}", nativeQuery=true)
    *
    *       Ejemplo:
    *
    *       @Query(value ="SELECT * FROM productos WHERE id_categoria = ?", nativeQuery=true)
    *        List<Producto> findByIdCategoria(int idCategoria);
    *
    * */

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    // otro ejemplo del uso de CRUDRepository, donde se usa el nombre del metodo de la interface para indicar la consulta que requerimos
    //en esta indicamos que debe buscar cuando la cantidad de stock sea menor que y que el estado sea true
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);


}
