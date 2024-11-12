package com.exo1.exo1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.exo1.exo1.dto.TacheDTO;
import com.exo1.exo1.entity.OrderItem;

@Mapper(componentModel = "spring")
public interface TacheMapper {
    TacheDTO toDTO(OrderItem orderItem);
    OrderItem toEntity(TacheDTO tacheDTO);
}
