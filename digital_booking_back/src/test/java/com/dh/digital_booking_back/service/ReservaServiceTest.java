package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.ReservaDTO;
import com.dh.digital_booking_back.model.DTO.ReservaDTOedit;
import com.dh.digital_booking_back.repository.Implementacion.IReservaRepository;
import com.dh.digital_booking_back.repository.ReservaRepository;
import com.dh.digital_booking_back.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static java.util.Calendar.PM;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class ReservaServiceTest {

    @Mock
    private ReservaRepository reservaRepository;
    @Mock
    private ProductoService productoService;
    @Mock
    private UsuarioService usuarioService;
    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private ReservaService reservaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldListAllReservas() throws ResourceNotFoundException {
        // Arrange
        List<Reserva> reservas = new ArrayList<>();
        Reserva reserva1 = new Reserva();
        Reserva reserva2 = new Reserva();
        reservas.add(reserva1);
        reservas.add(reserva2);

        when(reservaRepository.findAll()).thenReturn(reservas);

        // Act
        List<Reserva> result = reservaService.listarReservas();

        // Assert
        verify(reservaRepository).findAll();
        assertEquals(reservas, result);
    }

    @Test
    void shouldThrowExceptionWhenNoReservasFound() {
        // Arrange
        when(reservaRepository.findAll()).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> reservaService.listarReservas());
    }

    @Test
    void shouldFindReservaById() throws ResourceNotFoundException {
        // Arrange
        Long id = 1L;
        Reserva reserva = new Reserva();
        reserva.setId(id);

        when(reservaRepository.findById(id)).thenReturn(Optional.of(reserva));

        // Act
        Reserva result = reservaService.buscarReservaXId(id);

        // Assert
        verify(reservaRepository).findById(id);
        assertEquals(reserva, result);
    }

    @Test
    void shouldThrowExceptionWhenReservaNotFound() {
        // Arrange
        Long id = 1L;
        when(reservaRepository.findById(id)).thenReturn(Optional.empty());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> reservaService.buscarReservaXId(id));
    }

    @Test
    void shouldListReservasByProductoId() throws ResourceNotFoundException {
        // Arrange
        Long id = 1L;
        List<Reserva> reservas = new ArrayList<>();
        Reserva reserva1 = new Reserva();
        Reserva reserva2 = new Reserva();
        reservas.add(reserva1);
        reservas.add(reserva2);

        when(reservaRepository.findByProducto(id)).thenReturn(reservas);

        // Act
        List<Reserva> result = reservaService.listarReservasXProductoId(id);

        // Assert
        verify(reservaRepository).findByProducto(id);
        assertEquals(reservas, result);
    }

    @Test
    void shouldThrowExceptionWhenNoReservasFoundForProductoId() {
        // Arrange
        Long id = 1L;
        when(reservaRepository.findByProducto(id)).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> reservaService.listarReservasXProductoId(id));
    }
    /*
    @Test
    void shouldCreateReserva() throws BadRequestException, ResourceNotFoundException {
        // Arrange
        Long productoId = 1L;
        Long usuarioId = 2L;

        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setHoraInicio("01:30");
        reservaDTO.setFechaInicio("2024-03-03");
        reservaDTO.setFechaFin("2024-04-03");
        reservaDTO.setDatosVendedor("braian");
        reservaDTO.setVacunaCovid(true);
        reservaDTO.setProducto(productoId);
        reservaDTO.setUsuario(usuarioId);

        Producto producto = new Producto();
        producto.setId(productoId);

        Usuario usuario = new Usuario();
        usuario.setId(usuarioId);



        LocalTime horainicio = LocalTime.parse(reservaDTO.getHoraInicio());
        LocalDate fechaInicio = LocalDate.parse(reservaDTO.getFechaInicio());
        LocalDate fechaFinal= LocalDate.parse(reservaDTO.getFechaFin());

        Reserva reserva = new Reserva();
        reserva.setHoraInicio(horainicio);
        reserva.setFechaInicio(fechaInicio);
        reserva.setFechaFin(fechaFinal);
        reserva.setDatosVendedor("Braian");
        reserva.setVacunaCovid(true);
        reserva.setProducto(producto);
        reserva.setUsuario(usuario);

        when(productoService.buscarProductoXId(productoId)).thenReturn(producto);
        when(usuarioService.buscarUsuarioXId(usuarioId)).thenReturn(usuario);
        when(reservaRepository.save(any(Reserva.class))).thenReturn(reserva);

        // Act
        System.out.println(reservaDTO.toString());
        Reserva result = reservaService.registrarReserva(reservaDTO);

        // Assert
        verify(productoService).buscarProductoXId(productoId);
        verify(usuarioService).buscarUsuarioXId(usuarioId);
        verify(reservaRepository).save(any(Reserva.class));
        assertEquals(reserva, result);
    }

     */


    @Test
    void shouldThrowExceptionWhenProductoNotFoundWhileCreatingReserva() throws ResourceNotFoundException {
        Long productoId = 1L;
        Long usuarioId = 2L;

        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setHoraInicio("01:30");
        reservaDTO.setFechaInicio("2024-03-03");
        reservaDTO.setFechaFin("2024-04-03");
        reservaDTO.setDatosVendedor("braian");
        reservaDTO.setVacunaCovid(true);
        reservaDTO.setProducto(productoId);
        reservaDTO.setUsuario(usuarioId);

        when(productoService.buscarProductoXId(productoId)).thenThrow(ResourceNotFoundException.class);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> reservaService.registrarReserva(reservaDTO));
    }

    @Test
    void shouldThrowExceptionWhenNoReservasFoundForProducto() {
        // Arrange
        Long id = 1L;
        when(reservaRepository.findByProducto(id)).thenReturn(new ArrayList<>());

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> reservaService.listarReservasXProductoId(id));
    }




    @Test
    void shouldThrowExceptionWhenProductoNotFoundForReserva() throws ResourceNotFoundException {
        // Arrange
        Long productoId = 1L;
        Long usuarioId = 2L;

        ReservaDTO reservaDTO = new ReservaDTO();
        reservaDTO.setHoraInicio("01:30");
        reservaDTO.setFechaInicio("2024-03-03");
        reservaDTO.setFechaFin("2024-04-03");
        reservaDTO.setDatosVendedor("braian");
        reservaDTO.setVacunaCovid(true);
        reservaDTO.setProducto(productoId);
        reservaDTO.setUsuario(usuarioId);

        when(productoService.buscarProductoXId(productoId)).thenThrow(ResourceNotFoundException.class);

        // Act & Assert
        assertThrows(ResourceNotFoundException.class, () -> reservaService.registrarReserva(reservaDTO));
    }





}

