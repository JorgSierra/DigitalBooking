package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.service.ProductoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductoControllerTest {

    @Mock
    private ProductoService productoService;

    @InjectMocks
    private ProductoController productoController;

    @Test
    public void eliminarProducto_thenReturn200() throws BadRequestException, ResourceNotFoundException {
        Long idProducto = 1L;
        ResponseEntity<String> response = productoController.eliminarProducto(idProducto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void listarProductos_thenReturnList() throws ResourceNotFoundException {
        Producto producto = new Producto();
        List<Producto> listaProductos = Collections.singletonList(producto);
        Mockito.when(productoService.listarProductos()).thenReturn(listaProductos);
        ResponseEntity<List<Producto>> response = productoController.listarProductos();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaProductos, response.getBody());
    }

    @Test
    public void buscarProductoXId_thenReturnProducto() throws ResourceNotFoundException {
        Long idProducto = 1L;
        Producto producto = new Producto();
        Mockito.when(productoService.buscarProductoXId(idProducto)).thenReturn(producto);
        ResponseEntity<Producto> response = productoController.buscarProductoXId(idProducto);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(producto, response.getBody());
    }

    @Test
    public void buscarProductosXCategoria_thenReturnList() throws ResourceNotFoundException {
        Long idCategoria = 1L;
        Producto producto = new Producto();
        List<Producto> listaProductos = Collections.singletonList(producto);
        Mockito.when(productoService.listarProductosXCategoria(idCategoria)).thenReturn(listaProductos);
        ResponseEntity<List<Producto>> response = productoController.buscarProductosXCategoria(idCategoria);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaProductos, response.getBody());
    }

    @Test
    public void buscarProductoXCiudad_thenReturnList() throws ResourceNotFoundException {
        Long idCiudad = 1L;
        Producto producto = new Producto();
        List<Producto> listaProductos = Collections.singletonList(producto);
        Mockito.when(productoService.listarProductosXUbicacion(idCiudad)).thenReturn(listaProductos);
        ResponseEntity<List<Producto>> response = productoController.buscarProductoXCiudad(idCiudad);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaProductos, response.getBody());
    }

    @Test
    public void listarProductosAleatorio_thenReturnList() throws ResourceNotFoundException {
        Producto producto = new Producto();
        List<Producto> listaProductos = Collections.singletonList(producto);
        Mockito.when(productoService.listarProductosRand()).thenReturn(listaProductos);
        ResponseEntity<List<Producto>> response = productoController.listarProductosAleatorio();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(listaProductos, response.getBody());
    }
}
