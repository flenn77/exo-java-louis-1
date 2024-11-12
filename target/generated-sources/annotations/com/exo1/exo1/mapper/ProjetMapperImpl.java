package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetDTO;
import com.exo1.exo1.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T16:07:46+0100",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class ProjetMapperImpl implements ProjetMapper {

    @Override
    public ProjetDTO toDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProjetDTO projetDTO = new ProjetDTO();

        projetDTO.setId( product.getId() );

        return projetDTO;
    }

    @Override
    public Product toEntity(ProjetDTO projetDTO) {
        if ( projetDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( projetDTO.getId() );

        return product;
    }
}
