package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.ImagenDTO;
import com.dh.digital_booking_back.model.DTO.ImagenDTOedit;
import com.dh.digital_booking_back.model.Imagen;

import java.util.List;

public interface IImagenRepository {

    void eliminarImagenXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Imagen> listarImagenes() throws ResourceNotFoundException;

    Imagen buscarImagenXId(Long id) throws ResourceNotFoundException;

    Imagen registrarImagen(ImagenDTO imagenDTO) throws BadRequestException, ResourceNotFoundException;

    void editarImagen(ImagenDTOedit imagenDTO) throws ResourceNotFoundException, BadRequestException;

    Imagen DTO2imagen(ImagenDTO imagenDTO) throws ResourceNotFoundException, BadRequestException;

    Imagen DTO2imagen(ImagenDTOedit imagenDTO) throws ResourceNotFoundException, BadRequestException;
}
