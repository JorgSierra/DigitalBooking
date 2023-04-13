package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.UnauthorizedException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.ReservaDTO;
import com.dh.digital_booking_back.model.DTO.ReservaDTOedit;
import com.dh.digital_booking_back.security.jwt.JwtUtil;
import com.dh.digital_booking_back.service.ReservaService;
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

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("api/reservas")
@Tag(name = "Reserva",
        description = "Operaciones de reservas")
public class ReservaController {

    @Autowired
    ReservaService reservaService;

    @Autowired
    JwtUtil jwtUtil;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar reserva por ID [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva eliminada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reserva no fue encontrada y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER eliminando reserva de usuario diferente.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarReserva(@Parameter(description = "Id de reserva a eliminar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws BadRequestException, ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());
        Reserva reservaAEliminar = reservaService.buscarReservaXId(id);

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(reservaAEliminar.getUsuario().getId())){
            throw new UnauthorizedException("Intento de eliminar reserva de usuario diferente.");
        }

        reservaService.eliminarReservaXId(id);
        return ResponseEntity.ok("Se eliminó la reserva con id: " + id);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar todas las reservas [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reservas encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Reserva.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de reservas no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Reserva>> listarReservas() throws ResourceNotFoundException {
        return ResponseEntity.ok(reservaService.listarReservas());
    }

    @Operation(summary = "Listar todas las reservas de un producto")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reservas encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Reserva.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de reservas no fue encontrada.", content = @Content)
    })
    @GetMapping("/producto/{id}")
    public ResponseEntity<List<Reserva>> listarReservasXProductoId(@Parameter(description = "Id de producto a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(reservaService.listarReservasXProductoId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar todas las reservas de un usuario [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de reservas encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Reserva.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de reservas no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER buscando reservas de usuario diferente.", content = @Content)
    })
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Reserva>> listarReservasXUsuarioId(@Parameter(description = "Id de usuario a buscar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(id)){
            throw new UnauthorizedException("Intento de buscar reservas de usuario diferente.");
        }

        return ResponseEntity.ok(reservaService.listarReservasXUsuarioId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Buscar reserva por ID [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reserva encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Reserva.class))}),
            @ApiResponse(responseCode = "404", description = "Reserva no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER buscando reserva de usuario diferente.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> buscarReservaXId (@Parameter(description = "Id de reserva a buscar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());
        Reserva reservaABuscada = reservaService.buscarReservaXId(id);

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(reservaABuscada.getUsuario().getId())){
            throw new UnauthorizedException("Intento de buscar reserva de usuario diferente.");
        }

        return ResponseEntity.ok(reservaABuscada);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nueva reserva. Formato fecha: (yyyy-MM-dd). Formato Hora: (KK:mm) 24 horas. [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Reserva agregada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Reserva.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER agregando reserva de usuario diferente.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Reserva> agregarReserva(@RequestBody ReservaDTO reservaDTO, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, BadRequestException, UnauthorizedException, MessagingException, UnsupportedEncodingException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(reservaDTO.getUsuario())){
            throw new UnauthorizedException("Intento de agregar reserva de usuario diferente.");
        }

        return new ResponseEntity<>(reservaService.registrarReserva(reservaDTO), HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar reserva. Formato fecha: (yyyy-MM-dd). Formato Hora: (KK:mm) 24 horas. [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Reserva editada con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Reserva no fue encontrada y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER editando reserva de usuario diferente.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<Reserva> editarReserva(@RequestBody ReservaDTOedit reservaDTO, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, BadRequestException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(reservaDTO.getUsuario())){
            throw new UnauthorizedException("Intento de editar reserva de usuario diferente.");
        }

        reservaService.editarReserva(reservaDTO);
        return ResponseEntity.noContent().build();
    }


}
