package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.RolDTO;
import com.dh.digital_booking_back.model.DTO.RolDTOedit;
import com.dh.digital_booking_back.model.Rol;
import com.dh.digital_booking_back.model.Usuario;
import com.dh.digital_booking_back.service.RolService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;

public class RolControllerTest {

    @InjectMocks
    private RolController rolController;

    @Mock
    private RolService rolService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEliminarRol() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        ResponseEntity<String> response = rolController.eliminarRol(id);
        verify(rolService, times(1)).eliminarRolXId(id);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testListarRoles() throws ResourceNotFoundException {
        List<Rol> roles = new ArrayList<>();
        Rol rol = new Rol(1L,"ADMIN",null);
        Rol rol2 = new Rol(2L,"USER",null);
        roles.add(0,rol);
        roles.add(1,rol2);
        when(rolService.listarRoles()).thenReturn(roles);
        ResponseEntity<List<Rol>> response = rolController.listarRoles();
        verify(rolService, times(1)).listarRoles();
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(2, response.getBody().size());
    }

    @Test
    public void testBuscarRolXId() throws ResourceNotFoundException {
        Long id = 1L;

        Rol rol = new Rol(1L,"ADMIN",null);
        when(rolService.buscarRolXId(id)).thenReturn(rol);
        ResponseEntity<Rol> response = rolController.buscarRolXId(id);
        verify(rolService, times(1)).buscarRolXId(id);
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals("ADMIN", response.getBody().getNombre());
    }

    @Test
    public void testAgregarRol() throws ResourceNotFoundException, BadRequestException {
        RolDTO rolDTO = new RolDTO("admin");
        Rol rol = new Rol(1L,"ADMIN",null);
        when(rolService.registrarRol(rolDTO)).thenReturn(rol);
        ResponseEntity<Rol> response = rolController.agregarRol(rolDTO);
        verify(rolService, times(1)).registrarRol(rolDTO);
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("ADMIN", response.getBody().getNombre());
    }

    @Test
    public void testEditarRol() throws ResourceNotFoundException, BadRequestException {
        RolDTOedit rolDTOedit = new RolDTOedit(1L, "admin");
        rolController.editarRol(rolDTOedit);
        verify(rolService, times(1)).editarRol(rolDTOedit);
        ResponseEntity<?> response = rolController.editarRol(rolDTOedit);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
