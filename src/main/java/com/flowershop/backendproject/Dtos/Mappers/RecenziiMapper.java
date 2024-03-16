package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.RecenziiDto;
import com.flowershop.backendproject.Entity.Recenzii;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

/**
 * Clasa Mapper care realizeaza conversia intre entitatea Recenzii si RecenziiDto.
 */
public class RecenziiMapper {

    /**
     * Metoda statica pentru a converti un obiect de tip Recenzii in un obiect de tip RecenziiDto.
     *
     * @param recenzii Entitatea Recenzii care urmeaza sa fie convertita
     * @return Un obiect de tip RecenziiDto convertit din entitatea Recenzii
     */
    public static RecenziiDto toRecenziiDto(Recenzii recenzii){
        return RecenziiDto.builder()
                .id(recenzii.getId())
                .nume_utilizator(recenzii.getNume_utilizator())
                .recenzia(recenzii.getRecenzia())
                .build();
    }

    /**
     * Metoda statica pentru a converti un obiect de tip RecenziiDto in un obiect de tip Recenzii.
     *
     * @param recenziiDto RecenziiDto-ul care urmeaza sa fie convertit
     * @return Un obiect de tip Recenzii convertit din RecenziiDto
     */
    public static Recenzii toEntity(RecenziiDto recenziiDto){

        return Recenzii.builder().nume_utilizator(recenziiDto.getNume_utilizator())
                .recenzia(recenziiDto.getRecenzia())
                .build();
    }
}
