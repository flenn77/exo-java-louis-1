package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.TacheDTO;
import com.exo1.exo1.entity.OrderItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T16:33:29+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class TacheMapperImpl implements TacheMapper {

    @Override
    public TacheDTO orderItemToTacheDTO(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        TacheDTO tacheDTO = new TacheDTO();

        tacheDTO.setId( orderItem.getId() );

        return tacheDTO;
    }

    @Override
    public OrderItem tacheDTOToOrderItem(TacheDTO tacheDTO) {
        if ( tacheDTO == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( tacheDTO.getId() );

        return orderItem;
    }
}
