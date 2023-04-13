package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTOedit;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.repository.Implementacion.ITipoliticaRepository;
import com.dh.digital_booking_back.repository.TipoliticaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoliticaService implements ITipoliticaRepository {

    @Autowired
    TipoliticaRepository tipoliticaRepository;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void eliminarTipoliticaXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarTipoliticaXId(id);
        try {
            tipoliticaRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La tipolitica a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Tipolitica> listarTipoliticas() throws ResourceNotFoundException {
        List<Tipolitica> lista =  tipoliticaRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de tipoliticas.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Tipolitica buscarTipoliticaXId(Long id) throws ResourceNotFoundException {
        Optional<Tipolitica> buscado = tipoliticaRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe tipolitica con id: " + id + ".");
        }
    }

    @Override
    public Tipolitica registrarTipolitica(TipoliticaDTO tipoliticaDTO) throws BadRequestException {
        Tipolitica tipoliticaAguardar = DTO2tipolitica(tipoliticaDTO);
        Tipolitica tipoliticaGuardada;
        try {
            tipoliticaGuardada = tipoliticaRepository.save(tipoliticaAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return tipoliticaGuardada;
    }

    @Override
    public void editarTipolitica(TipoliticaDTOedit tipoliticaDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            buscarTipoliticaXId(tipoliticaDTO.getId());
            Tipolitica tipolitica = DTO2tipolitica(tipoliticaDTO);
            tipoliticaRepository.save(tipolitica);
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
    public Tipolitica DTO2tipolitica(TipoliticaDTO tipoliticaDTO) throws BadRequestException {
        if (tipoliticaDTO.getNombre() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }

        Tipolitica tipolitica = new Tipolitica();
        tipolitica.setNombre(tipoliticaDTO.getNombre());

        return tipolitica;
    }

    @Override
    public Tipolitica DTO2tipolitica(TipoliticaDTOedit tipoliticaDTO) throws BadRequestException {
        Tipolitica tipolitica = DTO2tipolitica(mapper.convertValue(tipoliticaDTO, TipoliticaDTO.class));
        if (tipoliticaDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            tipolitica.setId(tipoliticaDTO.getId());
        }
        return tipolitica;
    }
}


