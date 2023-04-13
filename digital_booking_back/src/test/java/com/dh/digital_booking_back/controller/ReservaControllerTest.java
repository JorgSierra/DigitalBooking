package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.controller.ReservaController;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Reserva;
import com.dh.digital_booking_back.service.ReservaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ReservaControllerTest {


    @InjectMocks
    ReservaController reservaController;

    @Mock
    ReservaService reservaService;

    private static final Long ID = 1L;
    /*
    @Test
    public void eliminarReservaTest() throws BadRequestException, ResourceNotFoundException {
        ResponseEntity<String> response = reservaController.eliminarReserva(ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(reservaService, times(1)).eliminarReservaXId(ID);
    }

     */

    @Test
    public void listarReservasTest() throws ResourceNotFoundException {
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());
        reservas.add(new Reserva());
        when(reservaService.listarReservas()).thenReturn(reservas);

        ResponseEntity<List<Reserva>> response = reservaController.listarReservas();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservas, response.getBody());
        verify(reservaService, times(1)).listarReservas();
    }

    @Test
    public void listarReservasXProductoIdTest() throws ResourceNotFoundException {
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());
        reservas.add(new Reserva());
        when(reservaService.listarReservasXProductoId(ID)).thenReturn(reservas);

        ResponseEntity<List<Reserva>> response = reservaController.listarReservasXProductoId(ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservas, response.getBody());
        verify(reservaService, times(1)).listarReservasXProductoId(ID);
    }
    /*
    @Test
    public void listarReservasXUsuarioIdTest() throws ResourceNotFoundException {
        List<Reserva> reservas = new ArrayList<>();
        reservas.add(new Reserva());
        reservas.add(new Reserva());
        when(reservaService.listarReservasXUsuarioId(ID)).thenReturn(reservas);

        ResponseEntity<List<Reserva>> response = reservaController.listarReservasXUsuarioId(ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reservas, response.getBody());
        verify(reservaService, times(1)).listarReservasXUsuarioId(ID);
    }


    @Test
        public void buscarReservaXIdTest() throws ResourceNotFoundException {
        Reserva reserva = new Reserva();
        when(reservaService.buscarReservaXId(ID)).thenReturn(reserva);

        ResponseEntity<Reserva> response = reservaController.buscarReservaXId(ID);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(reserva, response.getBody());
        verify(reservaService, times(1)).buscarReservaXId(ID);
    }

     */

}
