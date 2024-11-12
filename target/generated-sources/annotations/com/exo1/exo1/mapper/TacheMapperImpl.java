package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TacheDTO;
import com.exo1.exo1.entity.OrderItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T16:07:46+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class TacheMapperImpl implements TacheMapper {

    @Override
    public TacheDTO toDTO(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        TacheDTO tacheDTO = new TacheDTO();

        tacheDTO.setId( orderItem.getId() );

        return tacheDTO;
    }

    @Override
    public OrderItem toEntity(TacheDTO tacheDTO) {
        if ( tacheDTO == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( tacheDTO.getId() );

        return orderItem;
    }
}
