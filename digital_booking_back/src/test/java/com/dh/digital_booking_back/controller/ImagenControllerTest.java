package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.ImagenDTO;
import com.dh.digital_booking_back.model.DTO.ImagenDTOedit;
import com.dh.digital_booking_back.model.Imagen;
import com.dh.digital_booking_back.service.ImagenService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ImagenControllerTest {

    @InjectMocks
    private ImagenController imagenController;

    @Mock
    private ImagenService imagenService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void eliminarImagenTest() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;

        ResponseEntity<String> response = imagenController.eliminarImagen(id);

        verify(imagenService, times(1)).eliminarImagenXId(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void listarImagenesTest() throws ResourceNotFoundException {
        List<Imagen> imagenes = new ArrayList<>();
        imagenes.add(new Imagen());

        when(imagenService.listarImagenes()).thenReturn(imagenes);

        ResponseEntity<List<Imagen>> response = imagenController.listarImagenes();

        verify(imagenService, times(1)).listarImagenes();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(imagenes, response.getBody());
    }

    @Test
    public void buscarImagenTest() throws ResourceNotFoundException {
        Long id = 1L;

        Imagen imagen = new Imagen();
        imagen.setId(id);

        when(imagenService.buscarImagenXId(id)).thenReturn(imagen);

        ResponseEntity<Imagen> response = imagenController.buscarImagen(id);

        verify(imagenService, times(1)).buscarImagenXId(id);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(id, response.getBody().getId());
    }

    @Test
    public void agregarImagenTest() throws ResourceNotFoundException, BadRequestException {
        ImagenDTO imagenDTO = new ImagenDTO();

        Imagen imagen = new Imagen();

        when(imagenService.registrarImagen(imagenDTO)).thenReturn(imagen);

        ResponseEntity<Imagen> response = imagenController.agregarImagen(imagenDTO);

        verify(imagenService, times(1)).registrarImagen(imagenDTO);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(imagen, response.getBody());
    }

    @Test
    public void editarImagenTest() throws ResourceNotFoundException, BadRequestException {
        ImagenDTOedit imagenDTOedit = new ImagenDTOedit();

        ResponseEntity<?> response = imagenController.editarImagen(imagenDTOedit);

        verify(imagenService, times(1)).editarImagen(imagenDTOedit);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

}
