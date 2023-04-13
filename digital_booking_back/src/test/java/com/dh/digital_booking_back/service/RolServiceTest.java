package com.dh.digital_booking_back.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.RolDTO;
import com.dh.digital_booking_back.model.DTO.RolDTOedit;
import com.dh.digital_booking_back.model.Rol;
import com.dh.digital_booking_back.repository.RolRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RolServiceTest {

    @Mock
    private RolRepository rolRepository;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private RolService rolService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void buscarRolXId_RolExistente_RolRetornado() throws ResourceNotFoundException {
        // Arrange
        Long id = 1L;
        Rol rol = new Rol();
        rol.setId(id);
        rol.setNombre("nombreRol");
        when(rolRepository.findById(id)).thenReturn(Optional.of(rol));

        // Act
        Rol resultado = rolService.buscarRolXId(id);

        // Assert
        assertNotNull(resultado);
        assertEquals(id, resultado.getId());
        assertEquals(rol.getNombre(), resultado.getNombre());
    }

    @Test
    public void buscarRolXId_RolNoExistente_ExcepcionLanzada() {
        // Arrange
        Long id = 1L;
        when(rolRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> {
            rolService.buscarRolXId(id);
        });
    }


    @Test
    public void eliminarRolXId_RolExists_RolDeleted() throws ResourceNotFoundException, BadRequestException {
        // Arrange
        Long id = 1L;
        Rol rol = new Rol();
        rol.setId(id);
        when(rolRepository.findById(id)).thenReturn(Optional.of(rol));

        // Act
        rolService.eliminarRolXId(id);

        // Assert
        verify(rolRepository, times(1)).deleteById(id);
    }

    @Test
    public void eliminarRolXId_RolDoesNotExist_ResourceNotFoundExceptionThrown() {
        // Arrange
        Long id = 1L;
        when(rolRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> rolService.eliminarRolXId(id));
    }

    @Test
    public void eliminarRolXId_RolIsReferenced_BadRequestExceptionThrown() throws ResourceNotFoundException, BadRequestException {
        // Arrange
        Long id = 1L;
        Rol rol = new Rol();
        rol.setId(id);
        when(rolRepository.findById(id)).thenReturn(Optional.of(rol));
        doThrow(new RuntimeException()).when(rolRepository).deleteById(id);

        // Act & Assert
        assertThrows(BadRequestException.class, () -> rolService.eliminarRolXId(id));
    }

    @Test
    public void listarRoles_RolesExist_ReturnsListOfRoles() throws ResourceNotFoundException {
        // Arrange
        List<Rol> lista = new ArrayList<>();
        lista.add(new Rol());
        when(rolRepository.findAll()).thenReturn(lista);

        // Act
        List<Rol> result = rolService.listarRoles();

        // Assert
        assertEquals(lista, result);
    }

    @Test
    public void listarRoles_NoRolesExist_ResourceNotFoundExceptionThrown() {
        // Arrange
        when(rolRepository.findAll()).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> rolService.listarRoles());
    }

    // Tests for the rest of the methods in RolService go here
}
