package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.DTO.UbicacionDTO;
import com.dh.digital_booking_back.model.DTO.UbicacionDTOedit;
import com.dh.digital_booking_back.model.Ubicacion;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.service.UbicacionService;
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
@RequestMapping("/api/ubicaciones")
@Tag(name = "Ubicación",
        description = "Operaciones de ubicaciones")
public class UbicacionController {

    @Autowired
    UbicacionService ubicacionService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar ubicación por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ubicación eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Ubicación no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarUbicacion (@Parameter(description = "Id de ubicación a eliminar") @PathVariable Long id) throws BadRequestException, ResourceNotFoundException {
        ubicacionService.eliminarUbicacionXId(id);
        return ResponseEntity.ok("Se eliminó la ubicación con id: " + id);
    }

    @Operation(summary = "Listar todas las ubicaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ubicaciones encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Ubicacion.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de ubicaciones no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Ubicacion>> listarUbicaciones() throws ResourceNotFoundException {
        return ResponseEntity.ok(ubicacionService.listarUbicaciones());
    }

    @Operation(summary = "Buscar ubicación por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ubicación encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Ubicacion.class))}),
            @ApiResponse(responseCode = "404", description = "Ubicación no fue encontrada.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Ubicacion> buscarUbicacionXId (@Parameter(description = "Id de ubicación a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(ubicacionService.buscarUbicacionXId(id));
    }

    @Operation(summary = "Listar ubicaciones por ciudad que contenga string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de ubicaciones encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Ubicacion.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de ubicaciones no fue encontrada.", content = @Content)
    })
    @GetMapping("/ciudad/{string}")
    public ResponseEntity<List<Ubicacion>> listarUbicacionesQueContenganString(@Parameter(description = "String de ciudad a buscar") @PathVariable String string) throws ResourceNotFoundException {
        return ResponseEntity.ok(ubicacionService.listarCiudadesQueContenganString(string));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nueva ubicación [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ubicación agregada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Ubicacion.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Ubicacion> agregarUbicacion(@RequestBody UbicacionDTO ubicacionDTO) throws BadRequestException {
        return new ResponseEntity<>(ubicacionService.registrarUbicacion(ubicacionDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar ubicación [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Ubicación editada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Ubicación no fue encontrada y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarUbicacion(@RequestBody UbicacionDTOedit ubicacionDTO) throws ResourceNotFoundException, BadRequestException {
        ubicacionService.editarUbicacion(ubicacionDTO);
        return ResponseEntity.noContent().build();
    }
}
