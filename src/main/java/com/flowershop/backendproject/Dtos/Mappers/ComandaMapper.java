package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.ComandaDto;
import com.flowershop.backendproject.Entity.Comanda;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ComandaMapper {
    public static ComandaDto toComandaDto(Comanda comanda) {

        return ComandaDto.builder()
                .id(comanda.getId())
                .numar_comanda(comanda.getNumar_comanda())
                .suma(comanda.getSuma())
                //.id_user(comanda.getUser().getId())
                .build();
    }

    public static Comanda toEntity(ComandaDto comandaDto) {

        return  Comanda.builder().numar_comanda(comandaDto.getNumar_comanda())
                                 .suma(comandaDto.getSuma())
                                 .build();
    }
}
