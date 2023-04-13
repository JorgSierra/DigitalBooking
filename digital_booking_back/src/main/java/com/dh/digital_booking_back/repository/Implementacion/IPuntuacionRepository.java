package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ExistException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.PuntuacionDTO;
import com.dh.digital_booking_back.model.DTO.PuntuacionDTOedit;
import com.dh.digital_booking_back.model.Puntuacion;
import java.util.List;

public interface IPuntuacionRepository {

    void eliminarPuntuacionXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Puntuacion> listarPuntuaciones() throws ResourceNotFoundException;

    List<Puntuacion> listarPuntuacionXProductoId(Long id) throws ResourceNotFoundException;

    List<Puntuacion> listarPuntuacionXUsuarioId(Long id) throws ResourceNotFoundException;

    Puntuacion buscarPuntuacionXId(Long id) throws ResourceNotFoundException;

    Puntuacion registrarEditarPuntuacion(PuntuacionDTO puntuacionDTO) throws BadRequestException, ResourceNotFoundException;

    Puntuacion DTO2puntuacion(PuntuacionDTO puntuacionDTO) throws ResourceNotFoundException, BadRequestException;

}
