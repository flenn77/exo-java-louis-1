package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.ProjetDTO;
import com.exo1.exo1.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProjetMapper {
    ProjetMapper INSTANCE = Mappers.getMapper(ProjetMapper.class);

    ProjetDTO toDTO(Product product);
    Product toEntity(ProjetDTO projetDTO);
}
