package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetDTO;
import com.exo1.exo1.entity.Product;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-12T16:33:29+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class ProjetMapperImpl implements ProjetMapper {

    @Override
    public ProjetDTO productToProjetDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        ProjetDTO projetDTO = new ProjetDTO();

        projetDTO.setId( product.getId() );

        return projetDTO;
    }

    @Override
    public Product projetDTOToProduct(ProjetDTO projetDTO) {
        if ( projetDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( projetDTO.getId() );

        return product;
    }
}
