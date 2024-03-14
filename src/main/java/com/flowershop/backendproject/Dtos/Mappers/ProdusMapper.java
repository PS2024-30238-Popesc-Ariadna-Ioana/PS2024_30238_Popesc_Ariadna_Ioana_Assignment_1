package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.ProdusDto;
import com.flowershop.backendproject.Entity.Produs;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class ProdusMapper {
    public static ProdusDto toProdusDto(Produs produs) {

        return ProdusDto.builder()
                        .id(produs.getId())
                        .nume(produs.getNume())
                        .pret(produs.getPret())
                        .sezon(produs.getSezon())
                        .stoc(produs.getStoc())
                        .build();
    }

    public static Produs toEntity(ProdusDto produsDto) {

        return  Produs.builder().nume(produsDto.getNume())
                                .pret(produsDto.getPret())
                                .sezon(produsDto.getSezon())
                                .stoc(produsDto.getStoc())
                                .build();
    }
}
