package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.DTO.UbicacionDTOedit;
import com.dh.digital_booking_back.model.Ubicacion;
import com.dh.digital_booking_back.repository.UbicacionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class UbicacionServiceTest {
    @Mock
    UbicacionRepository ubicacionRepositoryMock;

    @Mock
    UbicacionDTO ubicacionDTOMock;

    @Mock
    UbicacionDTOedit ubicacionDTOEditMock;

    @InjectMocks
    UbicacionService ubicacionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testEliminarUbicacionXId() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(id);
        when(ubicacionRepositoryMock.findById(id)).thenReturn(Optional.of(ubicacion));
        doNothing().when(ubicacionRepositoryMock).deleteById(id);

        ubicacionService.eliminarUbicacionXId(id);

        verify(ubicacionRepositoryMock, times(1)).deleteById(id);
    }

    @Test
    public void testEliminarUbicacionXId_ResourceNotFoundException() {
        Long id = 1L;
        when(ubicacionRepositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> ubicacionService.eliminarUbicacionXId(id));

        verify(ubicacionRepositoryMock, never()).deleteById(any());
    }



    @Test
    public void testListarUbicaciones() throws ResourceNotFoundException {
        List<Ubicacion> ubicaciones = new ArrayList<>();
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(1L);
        ubicaciones.add(ubicacion);
        when(ubicacionRepositoryMock.findAll()).thenReturn(ubicaciones);

        List<Ubicacion> resultado = ubicacionService.listarUbicaciones();

        Assertions.assertEquals(resultado, ubicaciones);
    }

    @Test
    public void testListarUbicaciones_ResourceNotFoundException() {
        when(ubicacionRepositoryMock.findAll()).thenReturn(new ArrayList<>());

        assertThrows(ResourceNotFoundException.class, () -> ubicacionService.listarUbicaciones());
    }

    @Test
    public void testBuscarUbicacionXId() throws ResourceNotFoundException {
        Long id = 1L;
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(id);
        when(ubicacionRepositoryMock.findById(id)).thenReturn(Optional.of(ubicacion));

        Ubicacion resultado = ubicacionService.buscarUbicacionXId(id);

        Assertions.assertEquals(resultado, ubicacion);
    }

    @Test
    public void testBuscarUbicacionXId_ResourceNotFoundException() {
        Long id = 1L;
        when(ubicacionRepositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> ubicacionService.buscarUbicacionXId(id));
    }

    @Test
    public void testCrearUbicacion() throws BadRequestException {
        UbicacionDTO ubicacionDTO = new UbicacionDTO();
        ubicacionDTO.setCiudad("Calle Falsa 123");
        ubicacionDTO.setPais("arg");
        ubicacionDTO.setContinente("america");
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(1L);
        when(ubicacionRepositoryMock.save(any(Ubicacion.class))).thenReturn(ubicacion);

        Ubicacion resultado = ubicacionService.registrarUbicacion(ubicacionDTO);

        Assertions.assertEquals(resultado.getId(), ubicacion.getId());
    }

    @Test
    public void testActualizarUbicacion_BadRequestException() throws ResourceNotFoundException, BadRequestException {
        Long id = 2L;
        Ubicacion ubicacion = new Ubicacion();
        ubicacion.setId(id);
        when(ubicacionRepositoryMock.findById(id)).thenReturn(Optional.of(ubicacion));
        when(ubicacionRepositoryMock.save(any(Ubicacion.class))).thenReturn(ubicacion);

        UbicacionDTOedit ubicacionDTOedit = new UbicacionDTOedit();
        ubicacionDTOedit.setId(2L);
        ubicacionDTOedit.setCiudad("Calle Verdadera 321");
        ubicacionDTOedit.setPais("arg");
        ubicacionDTOedit.setContinente("america");
        System.out.println(ubicacionDTOedit.toString());

        assertThrows(BadRequestException.class, () -> ubicacionService.editarUbicacion(ubicacionDTOedit));

        verify(ubicacionRepositoryMock, never()).save(any(Ubicacion.class));
    }


    public void editarUbicacion(UbicacionDTOedit ubicacionDTOedit) throws ResourceNotFoundException, BadRequestException {
        if (ubicacionDTOedit.getCiudad() == null || ubicacionDTOedit.getCiudad().isEmpty() ||
                ubicacionDTOedit.getPais() == null || ubicacionDTOedit.getPais().isEmpty() ||
                ubicacionDTOedit.getContinente() == null || ubicacionDTOedit.getContinente().isEmpty()) {
            throw new BadRequestException("Los valores de entrada son inválidos");
        }


    }


    @Test
    public void testActualizarUbicacion_ResourceNotFoundException() {
        Long id = 1L;
        when(ubicacionRepositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> ubicacionService.editarUbicacion( new UbicacionDTOedit()));
        verify(ubicacionRepositoryMock, never()).save(any(Ubicacion.class));
    }


}
