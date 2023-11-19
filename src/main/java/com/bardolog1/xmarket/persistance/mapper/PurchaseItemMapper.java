package com.bardolog1.xmarket.persistance.mapper;

import com.bardolog1.xmarket.domain.PurchaseItem;
import com.bardolog1.xmarket.persistance.entity.ComprasProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source="id.idProducto", target="productId"),
            @Mapping(source="cantidad", target="quantity"),
            @Mapping(source="total", target="total"),
            @Mapping(source="estado", target="active")

    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

}
