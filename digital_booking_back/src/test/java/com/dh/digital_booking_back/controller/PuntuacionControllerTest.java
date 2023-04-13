package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.controller.PuntuacionController;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.UnauthorizedException;
import com.dh.digital_booking_back.model.Puntuacion;
import com.dh.digital_booking_back.service.PuntuacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PuntuacionControllerTest {

    @InjectMocks
    PuntuacionController puntuacionController;

    @Mock
    PuntuacionService puntuacionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void eliminarPuntuacionXId_success() throws ResourceNotFoundException, BadRequestException, UnauthorizedException {
        Long id = 1L;

        ResponseEntity<String> response = puntuacionController.eliminarImagen(id, "asdf");

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Se eliminó la puntuación con id: " + id, response.getBody());
    }




}
