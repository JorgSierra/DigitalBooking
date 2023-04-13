package com.dh.digital_booking_back.service;

import static org.mockito.Mockito.*;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.ImagenDTO;
import com.dh.digital_booking_back.model.DTO.ImagenDTOedit;
import com.dh.digital_booking_back.model.Imagen;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.repository.ImagenRepository;
import com.dh.digital_booking_back.service.ImagenService;
import com.dh.digital_booking_back.service.ProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.ImagenDTO;
import com.dh.digital_booking_back.model.DTO.ImagenDTOedit;
import com.dh.digital_booking_back.model.Imagen;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.repository.ImagenRepository;
import com.dh.digital_booking_back.service.ImagenService;
import com.dh.digital_booking_back.service.ProductoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class ImagenServiceTest {

    private ImagenService imagenService;

    @Mock
    private ImagenRepository imagenRepository;

    @Mock
    private ProductoService productoService;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        imagenService = new ImagenService();
        imagenService.imagenRepository = imagenRepository;
        imagenService.productoService = productoService;
        imagenService.mapper = objectMapper;
    }

    @Test
    public void eliminarImagenXId_IdValido_ImagenEliminada() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        Imagen imagen = new Imagen();
        imagen.setId(id);

        when(imagenRepository.findById(id)).thenReturn(Optional.of(imagen));

        imagenService.eliminarImagenXId(id);

        verify(imagenRepository, times(1)).findById(id);
        verify(imagenRepository, times(1)).deleteById(id);
    }

    @Test
    public void eliminarImagenXId_IdInvalido_ResourceNotFoundException() {
        Long id = 1L;

        when(imagenRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> imagenService.eliminarImagenXId(id));

        verify(imagenRepository, times(1)).findById(id);
        verify(imagenRepository, never()).deleteById(any());
    }

    @Test
    public void listarImagenes_ListaVacia_ResourceNotFoundException() {
        List<Imagen> lista = new ArrayList<>();

        when(imagenRepository.findAll()).thenReturn(lista);

        assertThrows(ResourceNotFoundException.class, () -> imagenService.listarImagenes());

        verify(imagenRepository, times(1)).findAll();
    }

    @Test
    public void listarImagenes_ListaNoVacia_ListaRetornada() throws ResourceNotFoundException {
        List<Imagen> lista = new ArrayList<>();
        Imagen imagen = new Imagen();
        lista.add(imagen);

        when(imagenRepository.findAll()).thenReturn(lista);

        List<Imagen> result = imagenService.listarImagenes();

        assertEquals(lista, result);

        verify(imagenRepository, times(1)).findAll();
    }

    @Test
    public void buscarImagenXId_IdValido_ImagenRetornada() throws ResourceNotFoundException {
        Long id = 1L;
        Imagen imagen = new Imagen();
        imagen.setId(id);

        when(imagenRepository.findById(id)).thenReturn(Optional.of(imagen));

        Imagen result = imagenService.buscarImagenXId(id);

        assertEquals(imagen, result);
        verify(imagenRepository, times(1)).findById(id);
    }

    @Test
    public void buscarImagenXId_IdInvalido_ResourceNotFoundException() {
        Long id = 1L;

        when(imagenRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> imagenService.buscarImagenXId(id));

        verify(imagenRepository, times(1)).findById(id);
    }










}

