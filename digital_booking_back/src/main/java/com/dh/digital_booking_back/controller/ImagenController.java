package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.DTO.ImagenDTO;
import com.dh.digital_booking_back.model.DTO.ImagenDTOedit;
import com.dh.digital_booking_back.model.Imagen;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.service.ImagenService;
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
import java.util.List;

@RestController
@RequestMapping("/api/imagenes")
@Tag(name = "Imagen",
        description = "Operaciones de imágenes")
public class ImagenController {

    @Autowired
    ImagenService imagenService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar imagen por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Imagen eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Imagen no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarImagen(@Parameter(description = "Id de imagen a eliminar") @PathVariable Long id) throws ResourceNotFoundException, BadRequestException {
        imagenService.eliminarImagenXId(id);
        return ResponseEntity.ok("Se eliminó la imagen con id: " + id);
    }

    @Operation(summary = "Listar todas las imágenes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de imágenes encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Imagen.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de imágenes no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Imagen>> listarImagenes() throws ResourceNotFoundException {
        return ResponseEntity.ok(imagenService.listarImagenes());
    }

    @Operation(summary = "Buscar imagen por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Imagen encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Imagen.class))}),
            @ApiResponse(responseCode = "404", description = "Imagen no fue encontrada.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Imagen> buscarImagen(@Parameter(description = "Id de imagen a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(imagenService.buscarImagenXId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nueva imagen [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Imagen agregada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Imagen.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Imagen> agregarImagen(@RequestBody ImagenDTO imagenDTO) throws ResourceNotFoundException, BadRequestException {
        return new ResponseEntity<>(imagenService.registrarImagen(imagenDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar imagen [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Imagen editada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Imagen no fue encontrada y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarImagen(@RequestBody ImagenDTOedit imagenDTO) throws ResourceNotFoundException, BadRequestException {
        imagenService.editarImagen(imagenDTO);
        return ResponseEntity.noContent().build();
    }

}
