package com.dh.digital_booking_back.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.LikeDTO;
import com.dh.digital_booking_back.model.Like;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.model.Usuario;
import com.dh.digital_booking_back.repository.LikeRepository;
import com.dh.digital_booking_back.service.LikeService;
import com.dh.digital_booking_back.service.ProductoService;
import com.dh.digital_booking_back.service.UsuarioService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;



@RunWith(MockitoJUnitRunner.class)
public class LikeServiceTest {

    @Mock
    private LikeRepository likeRepository;

    @Mock
    private ProductoService productoService;

    @Mock
    private UsuarioService usuarioService;

    @InjectMocks
    private LikeService likeService;

    @Test
    public void testEliminarLikeXId() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        Like like = new Like();
        when(likeRepository.findById(id)).thenReturn(Optional.of(like));
        doNothing().when(likeRepository).deleteById(id);

        likeService.eliminarLikeXId(id);

        verify(likeRepository, times(1)).findById(id);
        verify(likeRepository, times(1)).deleteById(id);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testEliminarLikeXIdNotFound() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        when(likeRepository.findById(id)).thenReturn(Optional.empty());

        likeService.eliminarLikeXId(id);

        verify(likeRepository, times(1)).findById(id);
        verify(likeRepository, never()).deleteById(id);
    }

    @Test(expected = BadRequestException.class)
    public void testEliminarLikeXIdReferenced() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        Like like = new Like();
        when(likeRepository.findById(id)).thenReturn(Optional.of(like));
        doThrow(new RuntimeException()).when(likeRepository).deleteById(id);

        likeService.eliminarLikeXId(id);

        verify(likeRepository, times(1)).findById(id);
        verify(likeRepository, times(1)).deleteById(id);
    }

    @Test
    public void testListaNoVacia() throws ResourceNotFoundException {
        List<Like> lista = new ArrayList<>();
        lista.add(new Like());

        List<Like> result = likeService.listaNoVacia(lista);

        assertEquals(lista, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testListaNoVaciaEmpty() throws ResourceNotFoundException {
        List<Like> lista = new ArrayList<>();

        likeService.listaNoVacia(lista);
    }

    @Test
    public void testListarLikes() throws ResourceNotFoundException {
        List<Like> lista = new ArrayList<>();
        lista.add(new Like());
        when(likeRepository.findAll()).thenReturn(lista);

        List<Like> result = likeService.listarLikes();

        assertEquals(lista, result);
        verify(likeRepository, times(1)).findAll();
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testListarLikesEmpty() throws ResourceNotFoundException {
        List<Like> lista = new ArrayList<>();
        when(likeRepository.findAll()).thenReturn(lista);

        likeService.listarLikes();

        verify(likeRepository, times(1)).findAll();
    }

    @Test
    public void testBuscarLikeXId() throws ResourceNotFoundException {
        Long id = 1L;
        Like like = new Like();
        when(likeRepository.findById(id)).thenReturn(Optional.of(like));

        Like result = likeService.buscarLikeXId(id);

        assertEquals(like, result);
        verify(likeRepository, times(1)).findById(id);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testBuscarLikeXIdNotFound() throws ResourceNotFoundException {
        Long id = 1L;
        when(likeRepository.findById(id)).thenReturn(Optional.empty());

        likeService.buscarLikeXId(id);

        verify(likeRepository, times(1)).findById(id);
    }

    @Test
    public void testCrearLike() throws ResourceNotFoundException, BadRequestException {
        Long productoId = 1L;
        Long usuarioId = 2L;
        Producto producto = new Producto();
        producto.setId(productoId);
        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);
        when(productoService.buscarProductoXId(productoId)).thenReturn(producto);
        when(usuarioService.buscarUsuarioXId(usuarioId)).thenReturn(usuario);
        when(likeRepository.save(any(Like.class))).thenAnswer(i -> i.getArgument(0));
        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setProducto(productoId);
        likeDTO.setUsuario(usuarioId);

        Like result = likeService.registrarLike(likeDTO);

        assertNotNull(result);
        assertEquals(producto, result.getProducto());
        assertEquals(usuario, result.getUsuario());
        verify(productoService, times(1)).buscarProductoXId(productoId);
        verify(usuarioService, times(1)).buscarUsuarioXId(usuarioId);
        verify(likeRepository, times(1)).save(any(Like.class));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testCrearLikeProductoNotFound() throws ResourceNotFoundException, BadRequestException {
        Long productoId = 1L;
        Long usuarioId = 2L;
        when(productoService.buscarProductoXId(productoId)).thenThrow(new ResourceNotFoundException("Producto no encontrado"));

        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setProducto(productoId);
        likeDTO.setUsuario(usuarioId);

        likeService.registrarLike(likeDTO);

        verify(productoService, times(1)).buscarProductoXId(productoId);
        verify(usuarioService, never()).buscarUsuarioXId(usuarioId);
        verify(likeRepository, never()).save(any(Like.class));
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testCrearLikeUsuarioNotFound() throws ResourceNotFoundException, BadRequestException {
        Long productoId = 1L;
        Long usuarioId = 2L;
        Producto producto = new Producto();
        producto.setId(productoId);
        when(productoService.buscarProductoXId(productoId)).thenReturn(producto);
        when(usuarioService.buscarUsuarioXId(usuarioId)).thenThrow(new ResourceNotFoundException("Usuario no encontrado"));

        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setProducto(productoId);
        likeDTO.setUsuario(usuarioId);

        likeService.registrarLike(likeDTO);

        verify(productoService, times(1)).buscarProductoXId(productoId);
        verify(usuarioService, times(1)).buscarUsuarioXId(usuarioId);
        verify(likeRepository, never()).save(any(Like.class));
    }


}


