package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.OrderItemDTO;
import com.exo1.exo1.entity.OrderItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T16:33:29+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class OrderItemMapperImpl implements OrderItemMapper {

    @Override
    public OrderItemDTO toDTO(OrderItem orderItem) {
        if ( orderItem == null ) {
            return null;
        }

        OrderItemDTO orderItemDTO = new OrderItemDTO();

        orderItemDTO.setId( orderItem.getId() );
        orderItemDTO.setQuantity( orderItem.getQuantity() );
        orderItemDTO.setPrice( orderItem.getPrice() );

        return orderItemDTO;
    }

    @Override
    public OrderItem toEntity(OrderItemDTO orderItemDTO) {
        if ( orderItemDTO == null ) {
            return null;
        }

        OrderItem orderItem = new OrderItem();

        orderItem.setId( orderItemDTO.getId() );
        orderItem.setQuantity( orderItemDTO.getQuantity() );
        orderItem.setPrice( orderItemDTO.getPrice() );

        return orderItem;
    }
}
