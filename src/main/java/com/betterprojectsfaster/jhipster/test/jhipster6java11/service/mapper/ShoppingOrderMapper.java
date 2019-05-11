package com.betterprojectsfaster.jhipster.test.jhipster6java11.service.mapper;

import com.betterprojectsfaster.jhipster.test.jhipster6java11.domain.ShoppingOrder;
import com.betterprojectsfaster.jhipster.test.jhipster6java11.service.dto.ShoppingOrderDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity {@link ShoppingOrder} and its DTO {@link ShoppingOrderDTO}.
 */
@Mapper(componentModel = "spring", uses = { UserMapper.class })
public interface ShoppingOrderMapper extends EntityMapper<ShoppingOrderDTO, ShoppingOrder>
{

    @Mapping(source = "buyer.id", target = "buyerId")
    @Mapping(source = "buyer.login", target = "buyerLogin")
    ShoppingOrderDTO toDto(ShoppingOrder shoppingOrder);

    @Mapping(target = "orders", ignore = true)
    @Mapping(source = "buyerId", target = "buyer")
    @Mapping(target = "shipment", ignore = true)
    @Mapping(target = "removeOrders", ignore = true)
    ShoppingOrder toEntity(ShoppingOrderDTO shoppingOrderDTO);

    default ShoppingOrder fromId(Long id)
    {
        if (id == null)
        {
            return null;
        }
        ShoppingOrder shoppingOrder = new ShoppingOrder();
        shoppingOrder.setId(id);
        return shoppingOrder;
    }
}
