package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.model.DTO.PoliticaDTO;
import com.dh.digital_booking_back.model.DTO.PoliticaDTOedit;
import com.dh.digital_booking_back.model.Politica;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.service.PoliticaService;
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
@RequestMapping("/api/politicas")
@Tag(name = "Política",
        description = "Operaciones de políticas")
public class PoliticaController {

    @Autowired
    PoliticaService politicaService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar política por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Política eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Política no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPolitica(@Parameter(description = "Id de política a eliminar") @PathVariable Long id ) throws ResourceNotFoundException, BadRequestException {
        politicaService.eliminarPoliticaXId(id);
        return ResponseEntity.ok("Se eliminó la política con id: " + id);
    }

    @Operation(summary = "Listar todas las políticas")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de políticas encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Politica.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de políticas no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Politica>> listarPoliticas() throws ResourceNotFoundException {
        return ResponseEntity.ok(politicaService.listarPoliticas());
    }

    @Operation(summary = "Buscar política por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Política encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Politica.class))}),
            @ApiResponse(responseCode = "404", description = "Política no fue encontrada.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Politica> buscarPolitica(@Parameter(description = "Id de política a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(politicaService.buscarPoliticaXId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nueva política [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Política agregada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Politica.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Politica> agregarPolitica(@RequestBody PoliticaDTO politicaDTO) throws ResourceNotFoundException, BadRequestException{
        return new ResponseEntity<>(politicaService.registrarPolitica(politicaDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar política [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Política editada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Política no fue encontrada y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarPolitica(@RequestBody PoliticaDTOedit politicaDTO) throws ResourceNotFoundException, BadRequestException {
        politicaService.editarPolitica(politicaDTO);
        return ResponseEntity.noContent().build();
    }



}
