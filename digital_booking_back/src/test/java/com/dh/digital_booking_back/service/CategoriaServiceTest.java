package com.dh.digital_booking_back.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.model.DTO.CategoriaDTOedit;
import com.dh.digital_booking_back.repository.CategoriaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategoriaServiceTest {

    private CategoriaRepository categoriaRepository;
    private ObjectMapper objectMapper;
    private CategoriaService categoriaService;

    @BeforeEach
    public void setUp() {
        categoriaRepository = mock(CategoriaRepository.class);
        objectMapper = mock(ObjectMapper.class);
        categoriaService = new CategoriaService();
        categoriaService.categoriaRepository = categoriaRepository;
        categoriaService.mapper = objectMapper;
    }

    @Test
    @DisplayName("Prueba listarCategorias - Lista vacía")
    public void listarCategorias_listaVacia()  {
        // Configurar comportamiento del mock
        List<Categoria> categorias = new ArrayList<>();
        when(categoriaRepository.findAll()).thenReturn(categorias);

        // Ejecutar el método a probar
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            categoriaService.listarCategorias();
        });

        // Verificar resultado
        assertEquals("No existe listado de categorías.", exception.getMessage());
    }

    @Test
    @DisplayName("Prueba listarCategorias - Lista con elementos")
    public void listarCategorias_listaConElementos() throws ResourceNotFoundException {
        // Configurar comportamiento del mock
        List<Categoria> categorias = new ArrayList<>();
        Categoria categoria1 = new Categoria();
        categoria1.setId(1L);
        categoria1.setTitulo("Categoria 1");
        categoria1.setDescripcion("Descripcion 1");
        categoria1.setUrlImagen("url1.jpg");
        categorias.add(categoria1);
        Categoria categoria2 = new Categoria();
        categoria2.setId(2L);
        categoria2.setTitulo("Categoria 2");
        categoria2.setDescripcion("Descripcion 2");
        categoria2.setUrlImagen("url2.jpg");
        categorias.add(categoria2);
        when(categoriaRepository.findAll()).thenReturn(categorias);

        // Ejecutar el método a probar
        List<Categoria> result = categoriaService.listarCategorias();

        // Verificar resultado
        assertEquals(categorias, result);
    }

    @Test
    @DisplayName("Prueba buscarCategoriaXId - Categoría encontrada")
    public void buscarCategoriaXId_categoriaEncontrada() throws ResourceNotFoundException {
        // Configurar comportamiento del mock
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setTitulo("Categoria 1");
        categoria.setDescripcion("Descripcion 1");
        categoria.setUrlImagen("url1.jpg");
        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));

        // Ejecutar el método a probar
        Categoria result = categoriaService.buscarCategoriaXId(1L);

        // Verificar resultado
        assertEquals(categoria, result);
    }

    @Test
    @DisplayName("Prueba buscarCategoriaXIdCategoría no encontrada")
    public void buscarCategoriaXId_categoriaNoEncontrada() {
// Configurar comportamiento del mock
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

// Ejecutar el método a probar
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            categoriaService.buscarCategoriaXId(1L);
        });

// Verificar resultado
        assertEquals("No existe categoría con id: 1.", exception.getMessage());
    }

    @Test
    @DisplayName("Prueba crearCategoria - Categoría creada correctamente")
    public void crearCategoria_categoriaCreadaCorrectamente() throws BadRequestException {
// Configurar comportamiento del mock
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setTitulo("Categoria 1");
        categoriaDTO.setDescripcion("Descripcion 1");
        categoriaDTO.setUrlImagen("url1.jpg");
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setTitulo("Categoria 1");
        categoria.setDescripcion("Descripcion 1");
        categoria.setUrlImagen("url1.jpg");
        when(categoriaRepository.save(any(Categoria.class))).thenReturn(categoria);
        when(objectMapper.convertValue((Object) any(CategoriaDTO.class), (Class<Object>) any())).thenReturn(categoria);

// Ejecutar el método a probar
        Categoria result = categoriaService.registrarCategoria(categoriaDTO);

// Verificar resultado
        assertEquals(categoria, result);
    }


    @Test
    @DisplayName("Prueba actualizarCategoria - Categoría no encontrada")
    public void actualizarCategoria_categoriaNoEncontradaa(){
// Configurar comportamiento del mock
        CategoriaDTOedit categoriaDTOedit = new CategoriaDTOedit();
        categoriaDTOedit.setTitulo("Categoria 1 actualizada");
        categoriaDTOedit.setDescripcion("Descripcion 1 actualizada");
        categoriaDTOedit.setUrlImagen("url1-actualizada.jpg");
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

// Ejecutar el método a probar
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            categoriaService.editarCategoria( categoriaDTOedit);
        });
    }


    @Test
    @DisplayName("Prueba actualizarCategoria - Categoría no encontrada")
    public void actualizarCategoria_categoriaNoEncontrada(){
        // Configurar comportamiento del mock
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());        ;
        CategoriaDTOedit categoriaDTOedit = new CategoriaDTOedit();
        categoriaDTOedit.setId(1L);
        categoriaDTOedit.setTitulo("Categoria 1 Editada");
        categoriaDTOedit.setDescripcion("Descripcion 1 Editada");
        categoriaDTOedit.setUrlImagen("url1Editada.jpg");

        // Ejecutar el método a probar
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            categoriaService.editarCategoria( categoriaDTOedit);
        });

        // Verificar resultado
        assertEquals("No existe categoría con id: 1.", exception.getMessage());
    }

    @Test
    @DisplayName("Prueba eliminarCategoria - NO se puede eliminar categoria por estar asociada a un producto")
    public void eliminarCategoria_categoriaEliminadaCorrectamente() throws BadRequestException, ResourceNotFoundException {
        // Configurar comportamiento del mock
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setTitulo("Categoria 1");
        categoria.setDescripcion("Descripcion 1");
        categoria.setUrlImagen("url1.jpg");

        when(categoriaRepository.findById(1L)).thenReturn(Optional.of(categoria));
        doNothing().when(categoriaRepository).deleteById(anyLong());


        // Ejecutar el método a probar
        categoriaService.eliminarCategoriaXId(1L);



        // Verificar resultado
        assertFalse(categoriaRepository.findById(1L).isEmpty());

    }

    @Test
    @DisplayName("Prueba eliminarCategoria - Categoría no encontrada")
    public void eliminarCategoria_categoriaNoEncontrada()  {
        // Configurar comportamiento del mock
        when(categoriaRepository.findById(1L)).thenReturn(Optional.empty());

        // Ejecutar el método a probar
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            categoriaService.eliminarCategoriaXId(1L);
        });

        // Verificar resultado
        assertEquals("No existe categoría con id: 1.", exception.getMessage());
    }

}
