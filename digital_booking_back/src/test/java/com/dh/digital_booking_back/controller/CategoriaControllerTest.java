package com.dh.digital_booking_back.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.service.CategoriaService;

@ExtendWith(MockitoExtension.class)
public class CategoriaControllerTest {

    @Mock
    private CategoriaService categoriaService;

    @InjectMocks
    private CategoriaController categoriaController;



    @Test
    public void testEliminarCategoria() throws ResourceNotFoundException, BadRequestException {
        // Given
        Long idCategoria = 1L;

        // When
        ResponseEntity<String> response = categoriaController.eliminarCategoria(idCategoria);

        // Then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se eliminó la categoría con id: " + idCategoria , response.getBody());
        verify(categoriaService).eliminarCategoriaXId(eq(idCategoria));
    }
}
