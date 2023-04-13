package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.DTO.UbicacionDTOedit;
import com.dh.digital_booking_back.model.Ubicacion;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.repository.Implementacion.IUbicacionRepository;
import com.dh.digital_booking_back.repository.UbicacionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UbicacionService implements IUbicacionRepository {

    @Autowired
    UbicacionRepository ubicacionRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void eliminarUbicacionXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarUbicacionXId(id);
        try {
            ubicacionRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La ubicación a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Ubicacion> listarUbicaciones() throws ResourceNotFoundException {
        List<Ubicacion> lista =  ubicacionRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de ubicaciones.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Ubicacion buscarUbicacionXId(Long id) throws ResourceNotFoundException {
        Optional<Ubicacion> buscado = ubicacionRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe ubicación con id: " + id + ".");
        }
    }

    @Override
    public List<Ubicacion> listarCiudadesQueContenganString(String string) throws ResourceNotFoundException {
        List<Ubicacion> lista =  ubicacionRepository.findUbicacionByCiudadContaining(string);
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de ubicaciones.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Ubicacion registrarUbicacion(UbicacionDTO ubicacionDTO) throws BadRequestException {
        Ubicacion ubicacionAguardar = DTO2ubicacion(ubicacionDTO);
        Ubicacion ubicacionGuardada;
        try {
            ubicacionGuardada = ubicacionRepository.save(ubicacionAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return ubicacionGuardada;
    }

    @Override
    public void editarUbicacion(UbicacionDTOedit ubicacionDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            buscarUbicacionXId(ubicacionDTO.getId());
            Ubicacion ubicacion = DTO2ubicacion(ubicacionDTO);
            ubicacionRepository.save(ubicacion);
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
    public Ubicacion DTO2ubicacion(UbicacionDTO ubicacionDTO) throws BadRequestException {
        if (ubicacionDTO.getCiudad() == null || ubicacionDTO.getPais() == null || ubicacionDTO.getContinente() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }

        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setCiudad(ubicacionDTO.getCiudad());
        ubicacion.setPais(ubicacionDTO.getPais());
        ubicacion.setContinente(ubicacionDTO.getContinente());

        return ubicacion;
    }

    @Override
    public Ubicacion DTO2ubicacion(UbicacionDTOedit ubicacionDTO) throws BadRequestException {
        Ubicacion ubicacion = DTO2ubicacion(mapper.convertValue(ubicacionDTO, UbicacionDTO.class));
        if (ubicacionDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            ubicacion.setId(ubicacionDTO.getId());
        }
        return ubicacion;
    }
}

