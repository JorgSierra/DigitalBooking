package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTO;
import com.dh.digital_booking_back.model.DTO.TipoliticaDTOedit;
import com.dh.digital_booking_back.model.Tipolitica;
import com.dh.digital_booking_back.service.TipoliticaService;
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
@RequestMapping("/api/tipoliticas")
@Tag(name = "Tipo de política",
        description = "Operaciones de tipos de política")
public class TipoliticaController {

    @Autowired
    TipoliticaService tipoliticaService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar tipo de política por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de política eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Tipo de política no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarTipolitica (@Parameter(description = "Id de tipo de política a eliminar") @PathVariable Long id) throws BadRequestException, ResourceNotFoundException {
        tipoliticaService.eliminarTipoliticaXId(id);
        return ResponseEntity.ok("Se eliminó el tipo de política con id: " + id);
    }

    @Operation(summary = "Listar todas los tipos de política")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de tipos de política encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Tipolitica.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de tipos de política no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Tipolitica>> listarTipoliticas() throws ResourceNotFoundException {
        return ResponseEntity.ok(tipoliticaService.listarTipoliticas());
    }

    @Operation(summary = "Buscar tipo de política por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Tipo de política encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Tipolitica.class))}),
            @ApiResponse(responseCode = "404", description = "Tipo de política no fue encontrada.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Tipolitica> buscarCategoriaXId (@Parameter(description = "Id de tipo de política a buscar") @PathVariable Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(tipoliticaService.buscarTipoliticaXId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nuevo tipo de política [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Tipo de política agregado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Tipolitica.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Tipolitica> agregarTipolitica(@RequestBody TipoliticaDTO tipoliticaDTO) throws BadRequestException {
        return new ResponseEntity<>(tipoliticaService.registrarTipolitica(tipoliticaDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar tipo de política [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Tipo de política editado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Tipo de política no fue encontrado y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarTipolitica(@RequestBody TipoliticaDTOedit tipoliticaDTO) throws ResourceNotFoundException, BadRequestException {
        tipoliticaService.editarTipolitica(tipoliticaDTO);
        return ResponseEntity.noContent().build();
    }
}
