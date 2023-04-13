package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.DTO.PoliticaDTOedit;
import com.dh.digital_booking_back.model.Politica;

import java.util.List;

public interface IPoliticaRepository {

    void eliminarPoliticaXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Politica> listarPoliticas() throws ResourceNotFoundException;

    Politica buscarPoliticaXId(Long id) throws ResourceNotFoundException;

    Politica registrarPolitica(PoliticaDTO politicaDTO) throws BadRequestException, ResourceNotFoundException;

    void editarPolitica(PoliticaDTOedit politicaDTO) throws ResourceNotFoundException, BadRequestException;

    Politica DTO2politica(PoliticaDTO politicaDTO) throws ResourceNotFoundException, BadRequestException;

    Politica DTO2politica(PoliticaDTOedit politicaDTO) throws ResourceNotFoundException, BadRequestException;
}
