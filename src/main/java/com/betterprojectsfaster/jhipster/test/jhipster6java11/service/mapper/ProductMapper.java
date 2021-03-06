package com.betterprojectsfaster.jhipster.test.jhipster6java11.service.mapper;

import com.betterprojectsfaster.jhipster.test.jhipster6java11.domain.*;
import com.betterprojectsfaster.jhipster.test.jhipster6java11.service.dto.ProductDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Product} and its DTO {@link ProductDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper extends EntityMapper<ProductDTO, Product> {


    @Mapping(target = "orders", ignore = true)
    Product toEntity(ProductDTO productDTO);

    default Product fromId(Long id) {
        if (id == null) {
            return null;
        }
        Product product = new Product();
        product.setId(id);
        return product;
    }
}
