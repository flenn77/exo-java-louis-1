package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetDTO;
import com.exo1.exo1.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjetMapper {
    ProjetDTO productToProjetDTO(Product product);
    Product projetDTOToProduct(ProjetDTO projetDTO);
}
