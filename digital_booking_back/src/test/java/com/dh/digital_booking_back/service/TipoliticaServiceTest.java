package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTOedit;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.repository.TipoliticaRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class TipoliticaServiceTest {

    @Mock
    private TipoliticaRepository tipoliticaRepository;

    @InjectMocks
    private TipoliticaService tipoliticaService;

    @Test
    public void listarTipoliticas_TipoliticaRepositoryReturnsNonEmptyList_ReturnsSameList() throws ResourceNotFoundException {
        List<Tipolitica> tipoliticas = new ArrayList<>();
        tipoliticas.add(new Tipolitica());
        Mockito.when(tipoliticaRepository.findAll()).thenReturn(tipoliticas);

        List<Tipolitica> result = tipoliticaService.listarTipoliticas();

        Assert.assertEquals(tipoliticas, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void listarTipoliticas_TipoliticaRepositoryReturnsEmptyList_ThrowsResourceNotFoundException() throws ResourceNotFoundException {
        List<Tipolitica> tipoliticas = new ArrayList<>();
        Mockito.when(tipoliticaRepository.findAll()).thenReturn(tipoliticas);

        tipoliticaService.listarTipoliticas();
    }

    @Test
    public void buscarTipoliticaXId_TipoliticaExists_ReturnsTipolitica() throws ResourceNotFoundException {
        Long id = 1L;
        Tipolitica tipolitica = new Tipolitica();
        tipolitica.setId(id);
        Mockito.when(tipoliticaRepository.findById(id)).thenReturn(Optional.of(tipolitica));

        Tipolitica result = tipoliticaService.buscarTipoliticaXId(id);

        Assert.assertEquals(tipolitica, result);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void buscarTipoliticaXId_TipoliticaDoesNotExist_ThrowsResourceNotFoundException() throws ResourceNotFoundException {
        Long id = 1L;
        Mockito.when(tipoliticaRepository.findById(id)).thenReturn(Optional.empty());

        tipoliticaService.buscarTipoliticaXId(id);
    }

    @Test
    public void registrarTipolitica_ValidTipoliticaDTO_ReturnsSavedTipolitica() throws BadRequestException {
        TipoliticaDTO tipoliticaDTO = new TipoliticaDTO();
        tipoliticaDTO.setNombre("test");
        Tipolitica tipolitica = new Tipolitica();
        tipolitica.setNombre("test");
        Mockito.when(tipoliticaRepository.save(Mockito.any(Tipolitica.class))).thenReturn(tipolitica);

        Tipolitica result = tipoliticaService.registrarTipolitica(tipoliticaDTO);

        Assert.assertEquals(tipolitica, result);
    }

    @Test(expected = BadRequestException.class)
    public void registrarTipolitica_InvalidTipoliticaDTO_ThrowsBadRequestException() throws BadRequestException {
        TipoliticaDTO tipoliticaDTO = new TipoliticaDTO();

        tipoliticaService.registrarTipolitica(tipoliticaDTO);
    }



    @Test(expected = ResourceNotFoundException.class)
    public void editarTipolitica_TipoliticaDoesNotExist_ThrowsResourceNotFoundException() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        TipoliticaDTOedit tipoliticaDTOedit = new TipoliticaDTOedit();
        tipoliticaDTOedit.setId(id);
        tipoliticaDTOedit.setNombre("test edit");
        Mockito.when(tipoliticaRepository.findById(id)).thenReturn(Optional.empty());

        tipoliticaService.editarTipolitica(tipoliticaDTOedit);
    }




    @Test(expected = ResourceNotFoundException.class)
    public void eliminarTipolitica_TipoliticaDoesNotExist_ThrowsResourceNotFoundException() throws ResourceNotFoundException, BadRequestException {
        Long id = 1L;
        Mockito.when(tipoliticaRepository.findById(id)).thenReturn(Optional.empty());

        tipoliticaService.eliminarTipoliticaXId(id);
    }
}
