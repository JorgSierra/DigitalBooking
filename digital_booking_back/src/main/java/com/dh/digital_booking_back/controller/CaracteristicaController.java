package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.Caracteristica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTO;
import com.dh.digital_booking_back.model.DTO.CaracteristicaDTOedit;
import com.dh.digital_booking_back.service.CaracteristicaService;
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
@RequestMapping("/api/caracteristicas")
@Tag(name = "Característica",
        description = "Operaciones de características")
public class CaracteristicaController {

    @Autowired
    CaracteristicaService caracteristicaService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar característica por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Característica eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Característica no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarCaracteristica (@Parameter(description = "Id de característica a eliminar") @PathVariable Long id) throws ResourceNotFoundException, BadRequestException {
        caracteristicaService.eliminarCaracteristicaXId(id);
        return ResponseEntity.ok("Se eliminó el característica con id: " + id);
    }

    @Operation(summary = "Listar todas las característica")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de características encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Caracteristica.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de características no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Caracteristica>> listarCaracteristicas() throws ResourceNotFoundException{
        return ResponseEntity.ok(caracteristicaService.listarCaracteristicas());
    }

    @Operation(summary = "Buscar característica por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Característica encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Caracteristica.class))}),
            @ApiResponse(responseCode = "404", description = "Característica no fue encontrada.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Caracteristica> buscarCaracteristicaXId (@Parameter(description = "Id de característica a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(caracteristicaService.buscarCaracteristicaXId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nueva característica [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Característica agregada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Caracteristica.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity <Caracteristica> agregarCaracteristica(@RequestBody CaracteristicaDTO caracteristicaDTO) throws ResourceNotFoundException, BadRequestException {
        return new ResponseEntity<>(caracteristicaService.registrarCaracteristica(caracteristicaDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar característica [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Característica editada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Característica no fue encontrada y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarCaracteristica(@RequestBody CaracteristicaDTOedit caracteristicaDTO) throws ResourceNotFoundException, BadRequestException {
        caracteristicaService.editarCaracteristica(caracteristicaDTO);
        return ResponseEntity.noContent().build();
    }



}
