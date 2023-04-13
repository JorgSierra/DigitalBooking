package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTOedit;
import com.dh.digital_booking_back.model.Tipolitica;

import java.util.List;

public interface ITipoliticaRepository {

    void eliminarTipoliticaXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Tipolitica> listarTipoliticas() throws ResourceNotFoundException;

    Tipolitica buscarTipoliticaXId(Long id) throws ResourceNotFoundException;

    Tipolitica registrarTipolitica(TipoliticaDTO tipoliticaDTO) throws BadRequestException;

    void editarTipolitica(TipoliticaDTOedit tipolitica) throws BadRequestException, ResourceNotFoundException;

    Tipolitica DTO2tipolitica(TipoliticaDTO tipoliticaDTO) throws BadRequestException;

    Tipolitica DTO2tipolitica(TipoliticaDTOedit tipoliticaDTO) throws BadRequestException;
}