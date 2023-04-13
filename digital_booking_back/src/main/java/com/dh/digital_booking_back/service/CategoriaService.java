package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.model.DTO.CategoriaDTOedit;
import com.dh.digital_booking_back.repository.CategoriaRepository;
import com.dh.digital_booking_back.repository.Implementacion.ICategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService implements ICategoriaRepository {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void eliminarCategoriaXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarCategoriaXId(id);
        try {
            categoriaRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La categoría a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Categoria> listarCategorias() throws ResourceNotFoundException {
        List<Categoria> lista =  categoriaRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de categorías.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Categoria buscarCategoriaXId(Long id) throws ResourceNotFoundException {
        Optional<Categoria> buscado = categoriaRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe categoría con id: " + id + ".");
        }
    }

    @Override
    public Categoria registrarCategoria(CategoriaDTO categoriaDTO) throws BadRequestException {
        Categoria categoriaAguardar = DTO2categoria(categoriaDTO);
        Categoria categoriaGuardada;
        try {
            categoriaGuardada = categoriaRepository.save(categoriaAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return categoriaGuardada;
    }

    @Override
    public void editarCategoria(CategoriaDTOedit categoriaDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            buscarCategoriaXId(categoriaDTO.getId());
            Categoria categoria = DTO2categoria(categoriaDTO);
            categoriaRepository.save(categoria);
        }
        catch (Exception e){
            if (e.getClass() == ResourceNotFoundException.class){
                throw new ResourceNotFoundException(e.getMessage());
            }
            else {
                throw new BadRequestException("El request recibido no tiene el formato correcto.");
            }
        }
    }

    @Override
    public Categoria DTO2categoria(CategoriaDTO categoriaDTO) throws BadRequestException {
        if (categoriaDTO.getTitulo() == null || categoriaDTO.getDescripcion() == null || categoriaDTO.getUrlImagen() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        Categoria categoria = new Categoria();
        categoria.setTitulo(categoriaDTO.getTitulo());
        categoria.setDescripcion(categoriaDTO.getDescripcion());
        categoria.setUrlImagen(categoriaDTO.getUrlImagen());

        return categoria;
    }

    @Override
    public Categoria DTO2categoria(CategoriaDTOedit categoriaDTO) throws BadRequestException {
        Categoria categoria = DTO2categoria(mapper.convertValue(categoriaDTO, CategoriaDTO.class));
        if (categoriaDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            categoria.setId(categoriaDTO.getId());
        }
        return categoria;
    }
}
