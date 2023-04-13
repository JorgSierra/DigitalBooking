package com.dh.digital_booking_back.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.dh.digital_booking_back.controller.PoliticaController;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.Politica;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.service.PoliticaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
public class PoliticaControllerTest {

    @Mock
    private PoliticaService politicaService;

    @InjectMocks
    private PoliticaController politicaController;

    // test para el método listarPoliticas
    @Test
    public void testListarPoliticas() throws ResourceNotFoundException {
        Tipolitica tipolitica = new Tipolitica(1L,"nombre",null);
        Politica politica1 = new Politica(1L,"titulo","descripcion",null,tipolitica);
        Politica politica2 = new Politica(2L,"titulo","descripcion2",null,tipolitica);
        List<Politica> listaPoliticas = Arrays.asList(politica1, politica2);

        when(politicaService.listarPoliticas()).thenReturn(listaPoliticas);

        ResponseEntity<List<Politica>> response = politicaController.listarPoliticas();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaPoliticas, response.getBody());
    }

    // test para el método buscarPolitica
    @Test
    public void testBuscarPolitica() throws ResourceNotFoundException {
        Tipolitica tipolitica = new Tipolitica(1L,"nombre",null);

        Long politicaId = 1L;
        Politica politica = new Politica(1L,"titulo","descripcion",null,tipolitica);

        when(politicaService.buscarPoliticaXId(politicaId)).thenReturn(politica);

        ResponseEntity<Politica> response = politicaController.buscarPolitica(politicaId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(politica, response.getBody());
    }

    // test para el método agregarPolitica
    @Test
    public void testAgregarPolitica() throws BadRequestException, ResourceNotFoundException {
        PoliticaDTO politicaDTO = new PoliticaDTO("titulo","descripcion",null);
        Mockito.when(politicaService.registrarPolitica(politicaDTO)).thenReturn(new Politica());

        ResponseEntity<?> response = politicaController.agregarPolitica(politicaDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }


    @Test
    public void testEliminarPolitica() throws ResourceNotFoundException, BadRequestException {
        Long politicaId = 1L;
        doNothing().when(politicaService).eliminarPoliticaXId(politicaId);

        ResponseEntity<String> response = politicaController.eliminarPolitica(politicaId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se eliminó la política con id: " + politicaId , response.getBody());
    }

}

