package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.ComandaDto;
import com.flowershop.backendproject.Entity.Comanda;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/**
 * Clasa Mapper care realizeaza conversia intre entitatea Comanda si ComandaDto.
 */
public class ComandaMapper {

    /**
     * Metoda statica pentru a converti un obiect de tip Comanda in un obiect de tip ComandaDto.
     *
     * @param comanda Entitatea Comanda care urmeaza sa fie convertita
     * @return Un obiect de tip ComandaDto convertit din entitatea Comanda
     */
    public static ComandaDto toComandaDto(Comanda comanda) {

        return ComandaDto.builder()
                .id(comanda.getId())
                .numar_comanda(comanda.getNumar_comanda())
                .suma(comanda.getSuma())
                //.id_user(comanda.getUser().getId())
                .build();
    }

    /**
     * Metoda statica pentru a converti un obiect de tip ComandaDto in un obiect de tip Comanda.
     *
     * @param comandaDto ComandaDto-ul care urmeaza sa fie convertit
     * @return Un obiect de tip Comanda convertit din ComandaDto
     */
    public static Comanda toEntity(ComandaDto comandaDto) {

        return  Comanda.builder().numar_comanda(comandaDto.getNumar_comanda())
                .suma(comandaDto.getSuma())
                .build();
    }
}
