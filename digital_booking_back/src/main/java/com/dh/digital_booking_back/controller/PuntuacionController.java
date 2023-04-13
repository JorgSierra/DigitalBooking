package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ExistException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.UnauthorizedException;
import com.dh.digital_booking_back.model.DTO.PuntuacionDTO;
import com.dh.digital_booking_back.model.DTO.PuntuacionDTOedit;
import com.dh.digital_booking_back.model.Puntuacion;
import com.dh.digital_booking_back.security.jwt.JwtUtil;
import com.dh.digital_booking_back.service.PuntuacionService;
import io.jsonwebtoken.Claims;
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
@RequestMapping("/api/puntuaciones")
@Tag(name = "Puntuación",
        description = "Operaciones de puntuaciones")
public class PuntuacionController {

    @Autowired
    PuntuacionService puntuacionService;

    @Autowired
    JwtUtil jwtUtil;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar puntuación por ID [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Puntuación eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Puntuación no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER eliminando puntuación de usuario diferente.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarImagen(@Parameter(description = "Id de puntuación a eliminar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, BadRequestException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(id)){
            throw new UnauthorizedException("Intento de eliminar puntuación de un usuario diferente.");
        }

        puntuacionService.eliminarPuntuacionXId(id);
        return ResponseEntity.ok("Se eliminó la puntuación con id: " + id);
    }

    @Operation(summary = "Listar todas las puntuaciones")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de puntuaciones encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Puntuacion.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de puntuaciones no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Puntuacion>> listarCaracteristicas() throws ResourceNotFoundException{
        return ResponseEntity.ok(puntuacionService.listarPuntuaciones());
    }

    @Operation(summary = "Buscar puntuación por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Puntuación encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Puntuacion.class))}),
            @ApiResponse(responseCode = "404", description = "Puntuación no fue encontrada.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Puntuacion> buscarPuntuacion(@Parameter(description = "Id de puntuación a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(puntuacionService.buscarPuntuacionXId(id));
    }

    @Operation(summary = "Listar todas las puntuaciones de un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de puntuaciones encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Puntuacion.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de puntuaciones no fue encontrada.", content = @Content)
    })
    @GetMapping("/producto/{id}")
    public ResponseEntity <List<Puntuacion>> buscarPuntuacionXproducto(@Parameter(description = "Id de producto a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(puntuacionService.listarPuntuacionXProductoId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar todas las puntuaciones de un usuario [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de puntuaciones encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Puntuacion.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de puntuaciones no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER listando usuario diferente.", content = @Content)
    })
    @GetMapping("/usuario/{id}")
    public ResponseEntity <List<Puntuacion>> buscarPuntuacionXusuario(@Parameter(description = "Id de usuario a buscar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(id)){
            throw new UnauthorizedException("Intento de listar un usuario diferente.");
        }
        return ResponseEntity.ok(puntuacionService.listarPuntuacionXUsuarioId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar/Editar puntuación [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Puntuación agregada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Puntuacion.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER agregando/editando puntuación de usuario diferente.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Puntuacion> agregarEditarPuntuacion(@RequestBody PuntuacionDTO puntuacionDTO, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, BadRequestException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER")){
            puntuacionDTO.setUsuario(idRequest);
        }

        return new ResponseEntity<>(puntuacionService.registrarEditarPuntuacion(puntuacionDTO), HttpStatus.CREATED);
    }

}