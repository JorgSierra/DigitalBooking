package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.RolDTO;
import com.dh.digital_booking_back.model.DTO.RolDTOedit;
import com.dh.digital_booking_back.model.Rol;
import com.dh.digital_booking_back.repository.Implementacion.IRolRepository;
import com.dh.digital_booking_back.repository.RolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService implements IRolRepository {

    @Autowired
    RolRepository rolRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void eliminarRolXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarRolXId(id);
        try {
            rolRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("El rol a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Rol> listarRoles() throws ResourceNotFoundException{
        List<Rol> lista =  rolRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de roles.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Rol buscarRolXId(Long id) throws ResourceNotFoundException {
        Optional<Rol> buscado = rolRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe rol con id: " + id + ".");
        }
    }

    @Override
    public Rol registrarRol(RolDTO rolDTO) throws BadRequestException {
        Rol rolAguardar = DTO2rol(rolDTO);
        Rol rolGuardado;
        try {
            rolGuardado = rolRepository.save(rolAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return rolGuardado;
    }

    @Override
    public void editarRol(RolDTOedit rolDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            buscarRolXId(rolDTO.getId());
            Rol rol = DTO2rol(rolDTO);
            rolRepository.save(rol);
        }
        catch (Exception e){
            if (e.getClass() == ResourceNotFoundException.class){
                throw new ResourceNotFoundException(e.getMessage());
            }
            else {
                throw new BadRequestException("El request recibido no tiene el formato correcto.");
            }
        }
    }

    @Override
    public Rol DTO2rol(RolDTO rolDTO) throws BadRequestException {
        if (rolDTO.getNombre() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }

        Rol rol = new Rol();
        rol.setNombre(rolDTO.getNombre());

        return rol;
    }

    @Override
    public Rol DTO2rol(RolDTOedit rolDTO) throws BadRequestException {
        Rol rol = DTO2rol(mapper.convertValue(rolDTO, RolDTO.class));
        if (rolDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            rol.setId(rolDTO.getId());
        }
        return rol;
    }
}
