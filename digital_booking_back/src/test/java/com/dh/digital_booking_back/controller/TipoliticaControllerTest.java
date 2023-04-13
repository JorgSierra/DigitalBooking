package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTOedit;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.service.TipoliticaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class TipoliticaControllerTest {

    @InjectMocks
    private TipoliticaController tipoliticaController;

    @Mock
    private TipoliticaService tipoliticaService;

    @Test
    public void testEliminarTipolitica() throws Exception {
        // Arrange
        Long id = 1L;

        // Act
        ResponseEntity<String> response = tipoliticaController.eliminarTipolitica(id);

        // Assert
        Mockito.verify(tipoliticaService, Mockito.times(1)).eliminarTipoliticaXId(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se eliminó el tipo de política con id: " + id, response.getBody());
    }

    @Test
    public void testListarTipoliticas() throws Exception {
        // Arrange
        Tipolitica tipolitica1 = new Tipolitica();
        Tipolitica tipolitica2 = new Tipolitica();
        List<Tipolitica> tipoliticas = Arrays.asList(tipolitica1, tipolitica2);
        Mockito.when(tipoliticaService.listarTipoliticas()).thenReturn(tipoliticas);

        // Act
        ResponseEntity<List<Tipolitica>> response = tipoliticaController.listarTipoliticas();

        // Assert
        Mockito.verify(tipoliticaService, Mockito.times(1)).listarTipoliticas();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tipoliticas, response.getBody());
    }

    @Test
    public void testBuscarCategoriaXId() throws Exception {
        // Arrange
        Long id = 1L;
        Tipolitica tipolitica = new Tipolitica();
        Mockito.when(tipoliticaService.buscarTipoliticaXId(id)).thenReturn(tipolitica);

        // Act
        ResponseEntity<Tipolitica> response = tipoliticaController.buscarCategoriaXId(id);

        // Assert
        Mockito.verify(tipoliticaService, Mockito.times(1)).buscarTipoliticaXId(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(tipolitica, response.getBody());
    }

    @Test
    public void testAgregarTipolitica() throws Exception {
        // Arrange
        TipoliticaDTO tipoliticaDTO = new TipoliticaDTO();
        Tipolitica tipolitica = new Tipolitica();
        Mockito.when(tipoliticaService.registrarTipolitica(tipoliticaDTO)).thenReturn(tipolitica);

        // Act
        ResponseEntity<Tipolitica> response = tipoliticaController.agregarTipolitica(tipoliticaDTO);

        // Assert
        Mockito.verify(tipoliticaService, Mockito.times(1)).registrarTipolitica(tipoliticaDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(tipolitica, response.getBody());
    }

    @Test
    public void testEditarTipolitica() throws Exception {
        // Arrange
        TipoliticaDTOedit tipoliticaDTOedit = new TipoliticaDTOedit();

        // Act
        ResponseEntity<?> response = tipoliticaController.editarTipolitica(tipoliticaDTOedit);

// Assert
        Mockito.verify(tipoliticaService, Mockito.times(1)).editarTipolitica(tipoliticaDTOedit);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}