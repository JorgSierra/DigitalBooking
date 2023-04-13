package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.RolDTO;
import com.dh.digital_booking_back.model.DTO.RolDTOedit;
import com.dh.digital_booking_back.model.Rol;
import java.util.List;

public interface IRolRepository {

    void eliminarRolXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Rol> listarRoles() throws ResourceNotFoundException;

    Rol buscarRolXId(Long id) throws ResourceNotFoundException;

    Rol registrarRol(RolDTO rolDTO) throws BadRequestException;

    void editarRol(RolDTOedit rolDTO) throws ResourceNotFoundException, BadRequestException;

    Rol DTO2rol(RolDTO rolDTO) throws BadRequestException;

    Rol DTO2rol(RolDTOedit rolDTO) throws BadRequestException;

}
