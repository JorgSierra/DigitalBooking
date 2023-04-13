package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.DTO.UbicacionDTOedit;
import com.dh.digital_booking_back.model.Ubicacion;
import java.util.List;

public interface IUbicacionRepository {

    void eliminarUbicacionXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Ubicacion> listarUbicaciones() throws ResourceNotFoundException;

    Ubicacion buscarUbicacionXId(Long id) throws ResourceNotFoundException;

    List<Ubicacion> listarCiudadesQueContenganString(String string) throws ResourceNotFoundException;

    Ubicacion registrarUbicacion(UbicacionDTO ubicacionDTO) throws BadRequestException;

    void editarUbicacion(UbicacionDTOedit ubicacionDTO) throws ResourceNotFoundException, BadRequestException;

    Ubicacion DTO2ubicacion(UbicacionDTO ubicacionDTO) throws BadRequestException;

    Ubicacion DTO2ubicacion(UbicacionDTOedit ubicacionDTO) throws BadRequestException;

}
