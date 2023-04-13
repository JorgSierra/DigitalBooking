package com.dh.digital_booking_back.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.model.Usuario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Like;
import com.dh.digital_booking_back.service.LikeService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LikeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private LikeService likeService;

    @InjectMocks
    private LikeController likeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(likeController).build();
    }

    @Test
    public void eliminarLike_IdExistente_DebeRetornar200() throws Exception {
        Long id = 1L;
        doNothing().when(likeService).eliminarLikeXId(id);

        mockMvc.perform(delete("/api/likes/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().string("Se eliminó el like con id: " + id));

        verify(likeService).eliminarLikeXId(id);
    }
    /*
    @Test
    void listarLikesXUsuarioTest() throws ResourceNotFoundException {
        List<Like> likes = new ArrayList<>();
        Producto producto =new Producto();
        Usuario usuario =new Usuario();
        Producto producto2 =new Producto();
        Usuario usuario2 =new Usuario();
        Producto producto3 =new Producto();
        Usuario usuario3 =new Usuario();
        likes.add(new Like(1L, producto, usuario));
        likes.add(new Like(2L, producto2, usuario2));
        likes.add(new Like(3L, producto3, usuario3));

        when(likeService.listarLikesXUsuario(1L)).thenReturn(likes);

        ResponseEntity<List<Like>> response = likeController.listarLikesXUsuario(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(likes, response.getBody());
    }

     */
    @Test
    void buscarLikeXIdTest() throws ResourceNotFoundException {
        Producto producto =new Producto();
        Usuario usuario =new Usuario();
        Like like = new Like(1L, producto, usuario);

        when(likeService.buscarLikeXId(1L)).thenReturn(like);

        ResponseEntity<Like> response = likeController.buscarLikeXId(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(like, response.getBody());
    }
    @Test
    void listarLikesTest() throws ResourceNotFoundException {
        List<Like> likes = new ArrayList<>();
        Producto producto =new Producto();
        Usuario usuario =new Usuario();
        Producto producto2 =new Producto();
        Usuario usuario2 =new Usuario();
        Producto producto3 =new Producto();
        Usuario usuario3 =new Usuario();
        likes.add(new Like(1L, producto, usuario));
        likes.add(new Like(2L, producto2, usuario2));
        likes.add(new Like(3L, producto3, usuario3));

        when(likeService.listarLikes()).thenReturn(likes);

        ResponseEntity<List<Like>> response = likeController.listarLikes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(likes, response.getBody());
    }
    @Test
    void listarLikesXProductoTest() throws ResourceNotFoundException {
        List<Like> likes = new ArrayList<>();
        Producto producto =new Producto();
        Usuario usuario =new Usuario();
        Producto producto2 =new Producto();
        Usuario usuario2 =new Usuario();
        Producto producto3 =new Producto();
        Usuario usuario3 =new Usuario();
        likes.add(new Like(1L, producto, usuario));
        likes.add(new Like(2L, producto2, usuario2));
        likes.add(new Like(3L, producto3, usuario3));

        when(likeService.listarLikesXProducto(1L)).thenReturn(likes);

        ResponseEntity<List<Like>> response = likeController.listarLikesXProducto(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(likes, response.getBody());
    }
    @Test
    void eliminarLikeTest() throws BadRequestException, ResourceNotFoundException {
        Long likeId = 1L;

        ResponseEntity<String> response = likeController.eliminarLike(likeId);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se eliminó el like con id: " + likeId, response.getBody());
    }
    }

