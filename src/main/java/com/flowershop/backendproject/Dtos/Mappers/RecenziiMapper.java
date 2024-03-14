package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.RecenziiDto;
import com.flowershop.backendproject.Entity.Recenzii;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RecenziiMapper {
    public static RecenziiDto toRecenziiDto(Recenzii recenzii){
        return RecenziiDto.builder()
                .id(recenzii.getId())
                .nume_utilizator(recenzii.getNume_utilizator())
                .recenzia(recenzii.getRecenzia())
                .build();
    }

    public static Recenzii toEntity(RecenziiDto recenziiDto){

        return Recenzii.builder().nume_utilizator(recenziiDto.getNume_utilizator())
                                 .recenzia(recenziiDto.getRecenzia())
                                 .build();
    }
}
