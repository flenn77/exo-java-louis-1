package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TacheDTO;
import com.exo1.exo1.entity.OrderItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TacheMapper {
    TacheDTO orderItemToTacheDTO(OrderItem orderItem);
    OrderItem tacheDTOToOrderItem(TacheDTO tacheDTO);
}
