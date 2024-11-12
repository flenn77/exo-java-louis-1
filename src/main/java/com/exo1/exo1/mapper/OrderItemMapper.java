package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.OrderItemDTO;
import com.exo1.exo1.entity.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OrderItemMapper {
    OrderItemMapper INSTANCE = Mappers.getMapper(OrderItemMapper.class);

    OrderItemDTO toDTO(OrderItem orderItem);
    OrderItem toEntity(OrderItemDTO orderItemDTO);
}
