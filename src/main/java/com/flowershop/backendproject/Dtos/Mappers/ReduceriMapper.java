package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.RecenziiDto;
import com.flowershop.backendproject.Dtos.ReduceriDto;
import com.flowershop.backendproject.Entity.Reduceri;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReduceriMapper {
    public static ReduceriDto toReduceriDto(Reduceri reduceri){
        return ReduceriDto.builder()
                .id(reduceri.getId())
                .nume(reduceri.getNume())
                .perioada(reduceri.getPerioada())
                .procent(reduceri.getProcent())
                .build();
    }

    public static Reduceri toEntity(ReduceriDto reduceriDto){

        return Reduceri.builder().nume(reduceriDto.getNume())
                                 .perioada(reduceriDto.getPerioada())
                                 .procent(reduceriDto.getProcent())
                                 .build();
    }
}
