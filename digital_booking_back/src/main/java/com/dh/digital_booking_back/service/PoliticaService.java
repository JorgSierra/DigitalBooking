package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.DTO.PoliticaDTOedit;
import com.dh.digital_booking_back.model.Politica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.repository.Implementacion.IPoliticaRepository;
import com.dh.digital_booking_back.repository.PoliticaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoliticaService implements IPoliticaRepository {

    @Autowired
    PoliticaRepository politicaRepository;

    @Autowired
    TipoliticaService tipoliticaService;

    @Autowired
    ObjectMapper mapper;

    public void eliminarPoliticaXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarPoliticaXId(id);
        try {
            politicaRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La política a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Politica> listarPoliticas() throws ResourceNotFoundException{
        List<Politica> lista = politicaRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de políticas.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Politica buscarPoliticaXId(Long id) throws ResourceNotFoundException {
        Optional<Politica> buscado = politicaRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe política con id: " + id + ".");
        }
    }

    @Override
    public Politica registrarPolitica(PoliticaDTO politicaDTO) throws ResourceNotFoundException, BadRequestException {
        Politica politicaAguardar = DTO2politica(politicaDTO);
        Politica politicaGuardada;
        try {
            politicaGuardada = politicaRepository.save(politicaAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return politicaGuardada;
    }

    @Override
    public void editarPolitica(PoliticaDTOedit politicaDTO)throws ResourceNotFoundException, BadRequestException {
        try {
            buscarPoliticaXId(politicaDTO.getId());
            Politica politica = DTO2politica(politicaDTO);
            politicaRepository.save(politica);
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
    public Politica DTO2politica(PoliticaDTO politicaDTO) throws ResourceNotFoundException, BadRequestException {
        if (politicaDTO.getTitulo() == null || politicaDTO.getDescripcion() == null || politicaDTO.getTipolitica() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        Politica politica = new Politica();
        politica.setTitulo(politicaDTO.getTitulo());
        politica.setDescripcion(politicaDTO.getDescripcion());

        Tipolitica tipoliticaBuscado = tipoliticaService.buscarTipoliticaXId(politicaDTO.getTipolitica());
        politica.setTipolitica(tipoliticaBuscado);

        return politica;
    }

    @Override
    public Politica DTO2politica(PoliticaDTOedit politicaDTO) throws ResourceNotFoundException, BadRequestException {
        Politica politica = DTO2politica(mapper.convertValue(politicaDTO, PoliticaDTO.class));
        if (politicaDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            politica.setId(politicaDTO.getId());
        }
        return politica;
    }
}


