package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.RolDTO;
import com.dh.digital_booking_back.model.DTO.RolDTOedit;
import com.dh.digital_booking_back.model.Rol;
import com.dh.digital_booking_back.service.RolService;
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
@RequestMapping("/api/roles")
@Tag(name = "Rol",
        description = "Operaciones de roles")
public class RolController {

    @Autowired
    RolService rolService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar rol por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol eliminado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Rol no fue encontrado y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarRol(@Parameter(description = "Id del rol a eliminar") @PathVariable Long id) throws ResourceNotFoundException, BadRequestException {
        rolService.eliminarRolXId(id);
        return ResponseEntity.ok("Se eliminó el rol con id: " + id);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar todos los roles [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de roles encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Rol.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de roles no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Rol>> listarRoles() throws ResourceNotFoundException {
        return ResponseEntity.ok(rolService.listarRoles());
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Buscar rol por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Rol encontrado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Rol.class))}),
            @ApiResponse(responseCode = "404", description = "Rol no fue encontrado.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Rol> buscarRolXId (@Parameter(description = "Id del rol a buscar") @PathVariable Long id) throws ResourceNotFoundException{
        return ResponseEntity.ok(rolService.buscarRolXId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nuevo rol [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Rol agregado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Rol.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Rol> agregarRol(@RequestBody RolDTO rolDTO) throws BadRequestException {
        return new ResponseEntity<>(rolService.registrarRol(rolDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar rol [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Rol editado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Rol no fue encontrado y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarRol(@RequestBody RolDTOedit rolDTO) throws ResourceNotFoundException, BadRequestException {
        rolService.editarRol(rolDTO);
        return ResponseEntity.noContent().build();
    }
}
