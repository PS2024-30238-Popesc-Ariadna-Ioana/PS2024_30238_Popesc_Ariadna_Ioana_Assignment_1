package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.CategorieDto;
import com.flowershop.backendproject.Entity.Categorie;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/**
 * Clasa Mapper care realizeaza conversia intre entitatea Categorie si CategorieDto.
 */
public class CategorieMapper {

    /**
     * Metoda statica pentru a converti un obiect de tip Categorie in un obiect de tip CategorieDto.
     *
     * @param categorie Entitatea Categorie care urmeaza sa fie convertita
     * @return Un obiect de tip CategorieDto convertit din entitatea Categorie
     */
    public static CategorieDto toCategorieDto(Categorie categorie) {

        return CategorieDto.builder()
                .id(categorie.getId())
                .nume(categorie.getNume())
                .build();
    }

    /**
     * Metoda statica pentru a converti un obiect de tip CategorieDto in un obiect de tip Categorie.
     *
     * @param categorieDto CategorieDto-ul care urmeaza sa fie convertit
     * @return Un obiect de tip Categorie convertit din CategorieDto
     */
    public static Categorie toEntity(CategorieDto categorieDto) {

        return  Categorie.builder().nume(categorieDto.getNume())
                .build();
    }
}
