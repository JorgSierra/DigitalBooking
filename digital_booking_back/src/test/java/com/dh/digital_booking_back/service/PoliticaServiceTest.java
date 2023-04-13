package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.DTO.PoliticaDTOedit;
import com.dh.digital_booking_back.model.Politica;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.repository.PoliticaRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class PoliticaServiceTest {

    @Mock
    private PoliticaRepository politicaRepository;

    @Mock
    private TipoliticaService tipoliticaService;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private PoliticaService politicaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void eliminarPoliticaXId_successful() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        Politica politica = new Politica();
        politica.setId(id);

        when(politicaRepository.findById(id)).thenReturn(Optional.of(politica));

        politicaService.eliminarPoliticaXId(id);

        verify(politicaRepository, times(1)).deleteById(id);
    }

    @Test
    void eliminarPoliticaXId_notFound() {
        Long id = 1L;

        when(politicaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> politicaService.eliminarPoliticaXId(id));

        verify(politicaRepository, never()).deleteById(anyLong());
    }

    @Test
    void eliminarPoliticaXId_referenced() {
        Long id = 1L;

        when(politicaRepository.findById(id)).thenReturn(Optional.of(new Politica()));
        doThrow(new RuntimeException()).when(politicaRepository).deleteById(id);

        assertThrows(BadRequestException.class, () -> politicaService.eliminarPoliticaXId(id));

        verify(politicaRepository, times(1)).findById(id);
        verify(politicaRepository, times(1)).deleteById(id);
    }

    @Test
    void listarPoliticas_successful() throws ResourceNotFoundException {
        List<Politica> politicas = new ArrayList<>();
        politicas.add(new Politica());

        when(politicaRepository.findAll()).thenReturn(politicas);

        List<Politica> result = politicaService.listarPoliticas();

        assertEquals(politicas, result);
    }

    @Test
    void listarPoliticas_notFound() {
        when(politicaRepository.findAll()).thenReturn(new ArrayList<>());

        assertThrows(ResourceNotFoundException.class, () -> politicaService.listarPoliticas());
    }

    @Test
    void buscarPoliticaXId_successful() throws ResourceNotFoundException {
        Long id = 1L;
        Politica politica = new Politica();
        politica.setId(id);

        when(politicaRepository.findById(id)).thenReturn(Optional.of(politica));

        Politica result = politicaService.buscarPoliticaXId(id);

        assertEquals(politica, result);
    }

    @Test
    void buscarPoliticaXId_notFound() {
        Long id    = 1L;

        when(politicaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> politicaService.buscarPoliticaXId(id));
    }





    @Test
    void crearPolitica_badRequest() throws ResourceNotFoundException {
        PoliticaDTO politicaDTO = new PoliticaDTO();

        politicaDTO.setDescripcion("Descripcion de la politica 1");
        politicaDTO.setTipolitica(1L);

        when(tipoliticaService.buscarTipoliticaXId(politicaDTO.getTipolitica())).thenThrow(new ResourceNotFoundException("no"));

        assertThrows(BadRequestException.class, () -> politicaService.registrarPolitica(politicaDTO));
    }


    @Test
    void editarPolitica_notFound() {
        Long id = 1L;
        PoliticaDTOedit politicaDTOedit = new PoliticaDTOedit();

        when(politicaRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> politicaService.editarPolitica( politicaDTOedit));
    }

    @Test
    void crearPolitica_tipoliticaNotFound() throws ResourceNotFoundException {
        PoliticaDTO politicaDTO = new PoliticaDTO();
        politicaDTO.setDescripcion("Descripcion de prueba");
        politicaDTO.setTipolitica(1L);

        when(tipoliticaService.buscarTipoliticaXId(politicaDTO.getTipolitica())).thenThrow(ResourceNotFoundException.class);

        assertThrows(BadRequestException.class, () -> politicaService.registrarPolitica(politicaDTO));
    }

    @Test
    void crearPolitica_invalidFields() {
        PoliticaDTO politicaDTO = new PoliticaDTO();
        politicaDTO.setTitulo("");
        politicaDTO.setDescripcion("Descripcion de prueba");


        assertThrows(BadRequestException.class, () -> politicaService.registrarPolitica(politicaDTO));
    }




}
