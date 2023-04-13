package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Caracteristica;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTO;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTOedit;
import java.util.List;

public interface ICaracteristicasRepository {

    void eliminarCaracteristicaXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Caracteristica> listarCaracteristicas() throws ResourceNotFoundException;

    Caracteristica buscarCaracteristicaXId(Long id) throws ResourceNotFoundException;

    Caracteristica registrarCaracteristica(CaracteristicaDTO caracteristicaDTO) throws BadRequestException;

    void editarCaracteristica(CaracteristicaDTOedit caracteristicaDTO) throws ResourceNotFoundException, BadRequestException;

    Caracteristica DTO2caracteristica(CaracteristicaDTO caracteristicaDTO) throws BadRequestException;

    Caracteristica DTO2caracteristica(CaracteristicaDTOedit caracteristicaDTO) throws BadRequestException;

}
