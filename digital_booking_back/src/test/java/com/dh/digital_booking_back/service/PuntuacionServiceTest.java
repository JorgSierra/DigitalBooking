package com.dh.digital_booking_back.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dh.digital_booking_back.model.DTO.PuntuacionDTOedit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.PuntuacionDTO;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.model.Puntuacion;
import com.dh.digital_booking_back.repository.PuntuacionRepository;

@ExtendWith(MockitoExtension.class)
public class PuntuacionServiceTest {

    @Mock
    private PuntuacionRepository puntuacionRepository;

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private PuntuacionService puntuacionService;

    @Test
    public void listarPuntuacionesTest() throws ResourceNotFoundException {
        List<Puntuacion> puntuaciones = new ArrayList<>();
        Puntuacion puntuacion1 = new Puntuacion();
        Puntuacion puntuacion2 = new Puntuacion();
        puntuacion1.setId(1L);
        puntuacion2.setId(2L);
        puntuaciones.add(puntuacion1);
        puntuaciones.add(puntuacion2);
        when(puntuacionRepository.findAll()).thenReturn(puntuaciones);
        List<Puntuacion> result = puntuacionService.listarPuntuaciones();
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void listarPuntuacionXProductoIdTest() throws ResourceNotFoundException {
        List<Puntuacion> puntuaciones = new ArrayList<>();
        Puntuacion puntuacion1 = new Puntuacion();
        Puntuacion puntuacion2 = new Puntuacion();
        puntuacion1.setId(1L);
        puntuacion2.setId(2L);
        puntuaciones.add(puntuacion1);
        puntuaciones.add(puntuacion2);
        when(puntuacionRepository.findAllByProductoId(any(Long.class))).thenReturn(puntuaciones);
        List<Puntuacion> result = puntuacionService.listarPuntuacionXProductoId(1L);
        assertEquals(2, result.size());
        assertEquals(1L, result.get(0).getId());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void buscarPuntuacionXIdTest() throws ResourceNotFoundException {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.setId(1L);
        Optional<Puntuacion> optionalPuntuacion = Optional.of(puntuacion);
        when(puntuacionRepository.findById(any(Long.class))).thenReturn(optionalPuntuacion);
        Puntuacion result = puntuacionService.buscarPuntuacionXId(1L);
        assertEquals(1L, result.getId());
    }
    /*
    @Test
    public void registrarPuntuacionTest() throws BadRequestException, ResourceNotFoundException {
        PuntuacionDTO puntuacionDTO = new PuntuacionDTO();
        puntuacionDTO.setValor(4.0);
        puntuacionDTO.setProducto(1L);
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.setId(1L);
        puntuacion.setValor(4.0);
        Producto producto = new Producto();
        producto.setId(1L);
        when(productoService.buscarProductoXId(any(Long.class))).thenReturn(producto);
        when(puntuacionRepository.save(any(Puntuacion.class))).thenReturn(puntuacion);
        Puntuacion result = puntuacionService.registrarPuntuacion(puntuacionDTO);
        assertEquals(1L, result.getId());
        assertEquals(4, result.getValor());
        assertEquals(1L, puntuacion.getId());
    }

     */



    @Test
    public void eliminarPuntuacionTest() throws ResourceNotFoundException, BadRequestException {
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.setId(1L);
        Optional<Puntuacion> optionalPuntuacion = Optional.of(puntuacion);
        when(puntuacionRepository.findById(any(Long.class))).thenReturn(optionalPuntuacion);
        puntuacionService.eliminarPuntuacionXId(1L);
    }
}
