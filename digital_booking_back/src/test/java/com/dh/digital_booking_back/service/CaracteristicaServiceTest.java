package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Caracteristica;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTO;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTOedit;
import com.dh.digital_booking_back.repository.CaracteristicaRepository;
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

public class CaracteristicaServiceTest {

    @Mock
    private CaracteristicaRepository caracteristicaRepository;

    @InjectMocks
    private CaracteristicaService caracteristicaService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEliminarCaracteristicaXId() throws ResourceNotFoundException, BadRequestException {
        // Given
        Long id = 1L;
        doNothing().when(caracteristicaRepository).deleteById(id);
        when(caracteristicaRepository.findById(id)).thenReturn(Optional.of(new Caracteristica()));

        // When
        caracteristicaService.eliminarCaracteristicaXId(id);

        // Then
        verify(caracteristicaRepository, times(1)).deleteById(id);
    }

    @Test
    public void testEliminarCaracteristicaXIdConExcepcion() throws ResourceNotFoundException {
        // Given
        Long id = 1L;
        when(caracteristicaRepository.findById(id)).thenReturn(Optional.empty());

        // When and Then
        assertThrows(ResourceNotFoundException.class, () -> caracteristicaService.eliminarCaracteristicaXId(id));
        verify(caracteristicaRepository, times(0)).deleteById(any());
    }

    @Test
    public void testListarCaracteristicas() throws ResourceNotFoundException {
        // Given
        List<Caracteristica> lista = new ArrayList<>();
        lista.add(new Caracteristica());
        when(caracteristicaRepository.findAll()).thenReturn(lista);

        // When
        List<Caracteristica> result = caracteristicaService.listarCaracteristicas();

        // Then
        assertNotNull(result);
        assertEquals(lista.size(), result.size());
        verify(caracteristicaRepository, times(1)).findAll();
    }

    @Test
    public void testListarCaracteristicasConExcepcion() throws ResourceNotFoundException {
        // Given
        when(caracteristicaRepository.findAll()).thenReturn(new ArrayList<>());

        // When and Then
        assertThrows(ResourceNotFoundException.class, () -> caracteristicaService.listarCaracteristicas());
        verify(caracteristicaRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarCaracteristicaXId() throws ResourceNotFoundException {
        // Given
        Long id = 1L;
        when(caracteristicaRepository.findById(id)).thenReturn(Optional.of(new Caracteristica()));

        // When
        Caracteristica result = caracteristicaService.buscarCaracteristicaXId(id);

        // Then
        assertNotNull(result);
        verify(caracteristicaRepository, times(1)).findById(id);
    }
    @Test
    public void testBuscarCaracteristicaXIdConExcepcion() throws ResourceNotFoundException {
        // Given
        Long id = 1L;
        when(caracteristicaRepository.findById(id)).thenReturn(Optional.empty());

        // When
        // Then
        assertThrows(ResourceNotFoundException.class, () -> caracteristicaService.buscarCaracteristicaXId(id));
        verify(caracteristicaRepository, times(1)).findById(id);
    }

    @Test
    public void testCrearCaracteristica() throws BadRequestException {
        // Given
        CaracteristicaDTO dto = new CaracteristicaDTO();
        dto.setNombre("Nombre de caracteristica");
        dto.setIcono("icono");

        Caracteristica caracteristica = new Caracteristica();
        caracteristica.setId(1L);
        caracteristica.setNombre(dto.getNombre());
        caracteristica.setIcono("icono");
        caracteristica.setProductos(null);
        when(caracteristicaRepository.save(any(Caracteristica.class))).thenReturn(caracteristica);

        // When
        Caracteristica result = caracteristicaService.registrarCaracteristica(dto);

        // Then
        assertNotNull(result);
        assertEquals(caracteristica.getId(), result.getId());
        assertEquals(caracteristica.getNombre(), result.getNombre());
        verify(caracteristicaRepository, times(1)).save(any(Caracteristica.class));
    }




}
