package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.CategorieDto;
import com.flowershop.backendproject.Entity.Categorie;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategorieMapper {
    public static CategorieDto toCategorieDto(Categorie categorie) {

        return CategorieDto.builder()
                .id(categorie.getId())
                .nume(categorie.getNume())
                .build();
    }

    public static Categorie toEntity(CategorieDto categorieDto) {

        return  Categorie.builder().nume(categorieDto.getNume())
                                   .build();
    }
}
