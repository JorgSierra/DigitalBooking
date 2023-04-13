package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.Caracteristica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTO;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTOedit;
import com.dh.digital_booking_back.repository.CaracteristicaRepository;
import com.dh.digital_booking_back.repository.Implementacion.ICaracteristicasRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaracteristicaService implements ICaracteristicasRepository {

    @Autowired
    CaracteristicaRepository caracteristicaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void eliminarCaracteristicaXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarCaracteristicaXId(id);
        try {
            caracteristicaRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La característica a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Caracteristica> listarCaracteristicas() throws ResourceNotFoundException{
        List<Caracteristica> lista =  caracteristicaRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de características.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Caracteristica buscarCaracteristicaXId(Long id) throws ResourceNotFoundException {
        Optional<Caracteristica> buscado = caracteristicaRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe característica con id: " + id + ".");
        }
    }

    @Override
    public Caracteristica registrarCaracteristica(CaracteristicaDTO caracteristicaDTO) throws BadRequestException {
        Caracteristica caracteristicaAguardar = DTO2caracteristica(caracteristicaDTO);
        Caracteristica caracteristicaGuardada;
        try {
            caracteristicaGuardada = caracteristicaRepository.save(caracteristicaAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return caracteristicaGuardada;
    }

    @Override
    public void editarCaracteristica(CaracteristicaDTOedit caracteristicaDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            buscarCaracteristicaXId(caracteristicaDTO.getId());
            Caracteristica caracteristica = DTO2caracteristica(caracteristicaDTO);
            caracteristicaRepository.save(caracteristica);
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
    public Caracteristica DTO2caracteristica(CaracteristicaDTO caracteristicaDTO) throws BadRequestException {
        if (caracteristicaDTO.getNombre() == null || caracteristicaDTO.getIcono() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setNombre(caracteristicaDTO.getNombre());
        caracteristica.setIcono(caracteristicaDTO.getIcono());

        return caracteristica;
    }

    @Override
    public Caracteristica DTO2caracteristica(CaracteristicaDTOedit caracteristicaDTO) throws BadRequestException {
        Caracteristica caracteristica = DTO2caracteristica(mapper.convertValue(caracteristicaDTO, CaracteristicaDTO.class));
        if (caracteristicaDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            caracteristica.setId(caracteristicaDTO.getId());
        }
        return caracteristica;
    }
}
