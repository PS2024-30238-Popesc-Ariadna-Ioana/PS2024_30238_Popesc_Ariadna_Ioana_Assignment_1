package com.flowershop.backendproject.Services;

import com.flowershop.backendproject.Dtos.Mappers.RecenziiMapper;
import com.flowershop.backendproject.Dtos.RecenziiDto;
import com.flowershop.backendproject.Entity.Recenzii;
import com.flowershop.backendproject.Repositories.RecenziiRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecenziiService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecenziiService.class);
    private final RecenziiRepository recenziiRepository;

    @Autowired
    public RecenziiService(RecenziiRepository recenziiRepository) {
        this.recenziiRepository = recenziiRepository;
    }

    public List<RecenziiDto> getRecenzii() {
        List<Recenzii> recenziiList = recenziiRepository.findAll();
        return recenziiList.stream()
                .map(RecenziiMapper::toRecenziiDto)
                .collect(Collectors.toList());
    }

    public RecenziiDto findRecenziiById(Long id) throws Exception {
        Optional<Recenzii> recenziiOptional = recenziiRepository.findById(id);
        if (!recenziiOptional.isPresent()) {
            LOGGER.error("The review with id {} not found in the database", id);
            throw new Exception("The review with id: " + id + " not found");
        }
        return RecenziiMapper.toRecenziiDto(recenziiOptional.get());
    }

    public Long insert(RecenziiDto recenziiDto) {
        Recenzii recenzii = RecenziiMapper.toEntity(recenziiDto);
        recenzii = recenziiRepository.save(recenzii);
        LOGGER.debug("The review with id {} inserted into the database", recenzii.getId());
        return recenzii.getId();
    }

    public RecenziiDto update(Long id, RecenziiDto recenziiDto) throws Exception {
        Optional<Recenzii> recenziiOptional = recenziiRepository.findById(id);
        if (recenziiOptional.isPresent()) {
            Recenzii recenzii = recenziiOptional.get();
            recenzii.setNume_utilizator(recenziiDto.getNume_utilizator());
            recenzii.setRecenzia(recenziiDto.getRecenzia());
            Recenzii modifRecenzii = recenziiRepository.save(recenzii);
            LOGGER.debug("The review with id {} updated", id);
            return RecenziiMapper.toRecenziiDto(modifRecenzii);
        } else {
            LOGGER.error("The review with id {} not found in the database", id);
            throw new Exception("The review with id: " + id + " not found");
        }
    }

    public void delete(Long id) throws Exception {
        Optional<Recenzii> optionalRecenzii = recenziiRepository.findById(id);
        if (optionalRecenzii.isPresent()) {
            recenziiRepository.deleteById(id);
            LOGGER.debug("The review with id {} deleted", id);
        } else {
            LOGGER.error("The review with id {} not found in the database", id);
            throw new Exception("The review with id: " + id + " not found");
        }
    }
}
