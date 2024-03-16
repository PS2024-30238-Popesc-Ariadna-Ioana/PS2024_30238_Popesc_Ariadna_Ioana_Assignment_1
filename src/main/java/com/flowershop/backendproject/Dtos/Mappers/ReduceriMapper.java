package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.RecenziiDto;
import com.flowershop.backendproject.Dtos.ReduceriDto;
import com.flowershop.backendproject.Entity.Reduceri;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/**
 * Clasa Mapper care realizeaza conversia intre entitatea Reduceri si ReduceriDto.
 */
public class ReduceriMapper {

    /**
     * Metoda statica pentru a converti un obiect de tip Reduceri in un obiect de tip ReduceriDto.
     *
     * @param reduceri Entitatea Reduceri care urmeaza sa fie convertita
     * @return Un obiect de tip ReduceriDto convertit din entitatea Reduceri
     */
    public static ReduceriDto toReduceriDto(Reduceri reduceri){
        return ReduceriDto.builder()
                .id(reduceri.getId())
                .nume(reduceri.getNume())
                .perioada(reduceri.getPerioada())
                .procent(reduceri.getProcent())
                .build();
    }

    /**
     * Metoda statica pentru a converti un obiect de tip ReduceriDto in un obiect de tip Reduceri.
     *
     * @param reduceriDto ReduceriDto-ul care urmeaza sa fie convertit
     * @return Un obiect de tip Reduceri convertit din ReduceriDto
     */
    public static Reduceri toEntity(ReduceriDto reduceriDto){

        return Reduceri.builder().nume(reduceriDto.getNume())
                .perioada(reduceriDto.getPerioada())
                .procent(reduceriDto.getProcent())
                .build();
    }
}
