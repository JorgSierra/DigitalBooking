package com.dh.digital_booking_back.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Usuario;
import com.dh.digital_booking_back.service.UsuarioService;

@ExtendWith(MockitoExtension.class)
public class UsuarioControllerTest {

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private UsuarioController usuarioController;

    @Test
    public void shouldReturnListOfUsers() throws ResourceNotFoundException {
        List<Usuario> userList = Arrays.asList(new Usuario(), new Usuario(), new Usuario());
        when(usuarioService.listarUsuarios()).thenReturn(userList);

        ResponseEntity<List<Usuario>> responseEntity = usuarioController.listarUsuarios();

        assertEquals(userList, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    /*
    @Test
    public void shouldAddUser() throws ResourceNotFoundException, BadRequestException, UserExistException {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setEmail("juan@gmail.com");
        usuario.setPassword("pass123");
        usuarioDTO.setNombre("Juan");
        usuarioDTO.setEmail("juan@gmail.com");
        usuarioDTO.setPassword("pass123");
        when(usuarioService.registrarUsuario(usuarioDTO)).thenReturn(usuario);

        ResponseEntity<Usuario> responseEntity = usuarioController.agregarUsuario(usuarioDTO);

        assertEquals(usuario, responseEntity.getBody());
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    public void shouldFindUserById() throws ResourceNotFoundException {
        Long userId = 1L;
        Usuario user = new Usuario();
        user.setId(userId);
        when(usuarioService.buscarUsuarioXId(userId)).thenReturn(user);

        ResponseEntity<Usuario> responseEntity = usuarioController.buscarUsuarioXId(userId);

        assertEquals(user, responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    
     */



}
