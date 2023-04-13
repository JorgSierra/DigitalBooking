package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.model.DTO.CategoriaDTOedit;
import java.util.List;


public interface ICategoriaRepository {

    void eliminarCategoriaXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Categoria> listarCategorias() throws ResourceNotFoundException;

    Categoria buscarCategoriaXId(Long id) throws ResourceNotFoundException;

    Categoria registrarCategoria(CategoriaDTO categoriaDTO) throws BadRequestException;

    void editarCategoria(CategoriaDTOedit categoriaDTO) throws ResourceNotFoundException, BadRequestException;

    Categoria DTO2categoria(CategoriaDTO categoriaDTO) throws BadRequestException;

    Categoria DTO2categoria(CategoriaDTOedit categoriaDTO) throws BadRequestException;

}
