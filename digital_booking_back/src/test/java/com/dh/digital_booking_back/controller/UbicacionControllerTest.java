package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.Ubicacion;
import com.dh.digital_booking_back.service.UbicacionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class UbicacionControllerTest {

    @Mock
    private UbicacionService ubicacionService;

    @InjectMocks
    private UbicacionController ubicacionController;

    private UbicacionDTO ubicacionDTO;
    private Ubicacion ubicacion;
    private Long id;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        id = 1L;
        ubicacionDTO = new UbicacionDTO("Dolores","arg","america");
        ubicacion = new Ubicacion(1l,"dolores","arg","america",null);
    }

    @Test
    public void eliminarUbicacionTest() throws ResourceNotFoundException, BadRequestException {
        ResponseEntity<String> responseEntity = ubicacionController.eliminarUbicacion(id);
        Mockito.verify(ubicacionService, Mockito.times(1)).eliminarUbicacionXId(id);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
    @Test
    public void listarUbicaciones_deberiaRetornarLista() throws ResourceNotFoundException {
        // Arrange
        Ubicacion ubicacion1 = new Ubicacion();
        ubicacion1.setId(1L);
        ubicacion1.setCiudad("Ubicacion 1");
        Ubicacion ubicacion2 = new Ubicacion();
        ubicacion2.setId(2L);
        ubicacion2.setCiudad("Ubicacion 2");
        List<Ubicacion> ubicaciones = Arrays.asList(ubicacion1, ubicacion2);
        when(ubicacionService.listarUbicaciones()).thenReturn(ubicaciones);

        // Act
        ResponseEntity<List<Ubicacion>> response = ubicacionController.listarUbicaciones();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(ubicaciones, response.getBody());
    }

    @Test
    public void listarUbicaciones_deberiaLanzarResourceNotFoundException() throws ResourceNotFoundException {
        // Arrange
        when(ubicacionService.listarUbicaciones()).thenThrow(ResourceNotFoundException.class);

        // Act
        Throwable exception = assertThrows(ResourceNotFoundException.class, () -> {
            ubicacionController.listarUbicaciones();
        });

        // Assert
        assertEquals(null, exception.getMessage());
    }

    @Test
    public void agregarUbicacionTest() throws ResourceNotFoundException, BadRequestException {
        when(ubicacionService.registrarUbicacion(ubicacionDTO)).thenReturn(ubicacion);
        ResponseEntity<Ubicacion> responseEntity = ubicacionController.agregarUbicacion(ubicacionDTO);
        Mockito.verify(ubicacionService, Mockito.times(1)).registrarUbicacion(ubicacionDTO);
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(ubicacion, responseEntity.getBody());
    }
}
