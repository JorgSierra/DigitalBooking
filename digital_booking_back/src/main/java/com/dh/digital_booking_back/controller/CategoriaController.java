package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.Categoria;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.CategoriaDTO;
import com.dh.digital_booking_back.model.DTO.CategoriaDTOedit;
import com.dh.digital_booking_back.service.CategoriaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@Tag(name = "Categoría",
        description = "Operaciones de categorías")
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar categoría por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoría eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoría no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarCategoria (@Parameter(description = "Id de categoría a eliminar") @PathVariable Long id) throws BadRequestException, ResourceNotFoundException {
        categoriaService.eliminarCategoriaXId(id);
        return ResponseEntity.ok("Se eliminó la categoría con id: " + id);
    }

    @Operation(summary = "Listar todas las categorías")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de categorías encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de categorías no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() throws ResourceNotFoundException {
        return ResponseEntity.ok(categoriaService.listarCategorias());
    }

    @Operation(summary = "Buscar categoría por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Categoría encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))}),
            @ApiResponse(responseCode = "404", description = "Categoría no fue encontrada.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaXId (@Parameter(description = "Id de categoría a buscar") @PathVariable Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(categoriaService.buscarCategoriaXId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nueva categoría [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Categoría agregada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Categoria.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Categoria> agregarCategoria(@RequestBody CategoriaDTO categoriaDTO) throws  BadRequestException {
        return new ResponseEntity<>(categoriaService.registrarCategoria(categoriaDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar categoría [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Categoría editada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Categoría no fue encontrada y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarCategoria(@RequestBody CategoriaDTOedit categoriaDTO) throws ResourceNotFoundException, BadRequestException {
        categoriaService.editarCategoria(categoriaDTO);
        return ResponseEntity.noContent().build();
    }
}
