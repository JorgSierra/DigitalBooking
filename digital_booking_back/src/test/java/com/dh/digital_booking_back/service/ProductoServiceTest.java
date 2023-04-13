package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.ProductoDTO;
import com.dh.digital_booking_back.model.DTO.ProductoDTOedit;
import com.dh.digital_booking_back.repository.Implementacion.IProductoRepository;
import com.dh.digital_booking_back.repository.ProductoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductoServiceTest {

    @Mock
    ProductoRepository productoRepository;

    @Mock
    CaracteristicaService caracteristicaService;

    @Mock
    CategoriaService categoriaService;

    @Mock
    PoliticaService politicaService;

    @Mock
    UbicacionService ubicacionService;

    @Mock
    ObjectMapper mapper;

    @InjectMocks
    ProductoService productoService;

    private Producto producto1;
    private Producto producto2;
    private Categoria categoria;
    private Ubicacion ubicacion;

    private Caracteristica caracteristica;

    /*
    @BeforeEach
    void setUp() {
        Set<Caracteristica> caracteristicas = new HashSet<>();
        Caracteristica caracteristica1 = new Caracteristica();
        caracteristicas.add(caracteristica1);
        Caracteristica caracteristica2 = new Caracteristica();
        caracteristicas.add(caracteristica2);
        Set<Imagen> imagenes = new HashSet<>();
        imagenes.add(new Imagen());
        imagenes.add(new Imagen());
        Set<Politica> politicas = new HashSet<>();
        politicas.add(new Politica());
        politicas.add(new Politica());
        Set<Puntuacion> puntuaciones = new HashSet<>();
        puntuaciones.add(new Puntuacion());
        puntuaciones.add(new Puntuacion());
        Set<Reserva> reservas= new HashSet<>();
        reservas.add(new Reserva());
        reservas.add(new Reserva());
        Set<Like> likes = new HashSet<>();
        likes.add(new Like());
        likes.add(new Like());


        caracteristica=new Caracteristica(1L,"nombre","icono",null);
        categoria = new Categoria(1L,"titulo","descripcion","urlimg",null);
        ubicacion = new Ubicacion(1L, "Ciudad1", "Direccion1", "america", null);
        producto1 = new Producto(1L,"nombre","titulo","descripcion",12.2,1.2,3.56,"direccion",caracteristicas,categoria,imagenes,politicas,puntuaciones,reservas,ubicacion,likes);
        producto2 = new Producto(2L,"nombre2","titulo2","descripcion2",12.2,1.2,3.56,"direccion",caracteristicas,categoria,imagenes,politicas,puntuaciones,reservas,ubicacion,likes);
    }

     */

    @Test
    void listarProductos_debeRetornarListaDeProductos() throws ResourceNotFoundException {
        List<Producto> listaProductos = new ArrayList<>();
        listaProductos.add(producto1);
        listaProductos.add(producto2);
        when(productoRepository.findAll()).thenReturn(listaProductos);
        List<Producto> resultado = productoService.listarProductos();
        Assertions.assertEquals(listaProductos, resultado);
    }

    @Test
    void listarProductos_debeLanzarExcepcionResourceNotFoundException() {
        when(productoRepository.findAll()).thenReturn(new ArrayList<>());
        Assertions.assertThrows(ResourceNotFoundException.class, () -> productoService.listarProductos());
    }
    /*
    @Test
    void buscarProductoXId_debeRetornarProducto() throws ResourceNotFoundException {
        Optional<Producto> productoOptional = Optional.of(producto1);
        when(productoRepository.findById(anyLong())).thenReturn(productoOptional);
        Producto resultado = productoService.buscarProductoXId(1L);
        Assertions.assertEquals(producto1, resultado);
    }

     */

    @Test
    void buscarProductoXId_debeLanzarExcepcionResourceNotFoundException() {
        Optional<Producto> productoOptional = Optional.empty();
        when(productoRepository.findById(anyLong())).thenReturn(productoOptional);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> productoService.buscarProductoXId(1L));
    }

    @Test
    void crearProducto_debeRetornarProductoCreado() throws BadRequestException, ResourceNotFoundException {
        Set<Long> caracteristicas = new HashSet<>();
        caracteristicas.add(1L);
        caracteristicas.add(2L);
        Set<Long> politicas =new HashSet<>();
        politicas.add(1l);
        politicas.add(2l);

        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setNombre("Producto3");
        productoDTO.setTitulo("titulo");
        productoDTO.setDescripcion("descripcion");
        productoDTO.setPrecio(300.0);
        productoDTO.setLatitud(12.2);
        productoDTO.setLongitud(12.2);
        productoDTO.setDireccion("rico514");
        productoDTO.setCaracteristicas(caracteristicas);
        productoDTO.setCategoria(1L);
        productoDTO.setPoliticas(politicas);
        productoDTO.setUbicacion(1L);

        Categoria categoria = new Categoria(1L,"titulo","descripciton","url",null);
        Ubicacion ubicacion = new Ubicacion(1L, "Ciudad1", "Direccion1", "america", null);

        when(categoriaService.buscarCategoriaXId(anyLong())).thenReturn(categoria);
        when(ubicacionService.buscarUbicacionXId(anyLong())).thenReturn(ubicacion);
        when(productoRepository.save(any(Producto.class))).thenReturn(producto1);

        Producto resultado = productoService.registrarProducto(productoDTO);

        Assertions.assertEquals(producto1, resultado);
    }







    @Test
    void eliminarProducto_debeLanzarExcepcionResourceNotFoundException() {
        Optional<Producto> productoOptional = Optional.empty();
        when(productoRepository.findById(anyLong())).thenReturn(productoOptional);
        Assertions.assertThrows(ResourceNotFoundException.class, () -> productoService.eliminarProductoXId(1L));
    }
}
