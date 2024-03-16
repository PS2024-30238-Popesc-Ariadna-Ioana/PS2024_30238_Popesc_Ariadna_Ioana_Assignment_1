package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.ProdusDto;
import com.flowershop.backendproject.Entity.Produs;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/**
 * Clasa Mapper care realizeaza conversia intre entitatea Produs si ProdusDto.
 */
public class ProdusMapper {

    /**
     * Metoda statica pentru a converti un obiect de tip Produs in un obiect de tip ProdusDto.
     *
     * @param produs Entitatea Produs care urmeaza sa fie convertita
     * @return Un obiect de tip ProdusDto convertit din entitatea Produs
     */
    public static ProdusDto toProdusDto(Produs produs) {

        return ProdusDto.builder()
                .id(produs.getId())
                .nume(produs.getNume())
                .pret(produs.getPret())
                .sezon(produs.getSezon())
                .stoc(produs.getStoc())
                .build();
    }

    /**
     * Metoda statica pentru a converti un obiect de tip ProdusDto in un obiect de tip Produs.
     *
     * @param produsDto ProdusDto-ul care urmeaza sa fie convertit
     * @return Un obiect de tip Produs convertit din ProdusDto
     */
    public static Produs toEntity(ProdusDto produsDto) {

        return  Produs.builder().nume(produsDto.getNume())
                .pret(produsDto.getPret())
                .sezon(produsDto.getSezon())
                .stoc(produsDto.getStoc())
                .build();
    }
}
