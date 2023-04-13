package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.UnauthorizedException;
import com.dh.digital_booking_back.model.DTO.LikeDTO;
import com.dh.digital_booking_back.model.Like;
import com.dh.digital_booking_back.security.jwt.JwtUtil;
import com.dh.digital_booking_back.service.LikeService;
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
@RequestMapping("/api/likes")
@Tag(name = "Like",
        description = "Operaciones de likes")
public class LikeController {

    @Autowired
    LikeService likeService;

    @Autowired
    JwtUtil jwtUtil;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar like por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like eliminado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Like no fue encontrado y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarLike(@Parameter(description = "Id de like a eliminar") @PathVariable Long id) throws BadRequestException, ResourceNotFoundException {
        likeService.eliminarLikeXId(id);
        return ResponseEntity.ok("Se eliminó el like con id: " + id);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar todos los likes [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de likes encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Like.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de likes no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Like>> listarLikes() throws ResourceNotFoundException {
        return ResponseEntity.ok(likeService.listarLikes());
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Buscar like por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Like encontrado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Like.class))}),
            @ApiResponse(responseCode = "404", description = "Like no fue encontrado.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Like> buscarLikeXId(@Parameter(description = "Id de like a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(likeService.buscarLikeXId(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar likes por producto ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de likes encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Like.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de likes no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @GetMapping("/producto/{id}")
    public ResponseEntity<List<Like>> listarLikesXProducto(@Parameter(description = "Id de producto a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(likeService.listarLikesXProducto(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar likes por usuario ID [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de likes encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Like.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de likes no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER buscando likes de usuario diferente.", content = @Content)
    })
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<Like>> listarLikesXUsuario(@Parameter(description = "Id de usuario a buscar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(id)){
            throw new UnauthorizedException("Intento de buscar likes de usuario diferente.");
        }

        return ResponseEntity.ok(likeService.listarLikesXUsuario(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nuevo like [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Like agregado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Like.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Like> agregarLike(@RequestBody LikeDTO likeDTO) throws ResourceNotFoundException, BadRequestException {
        return new ResponseEntity<>(likeService.registrarLike(likeDTO), HttpStatus.CREATED);
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Alternar likes de un usuario [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Like creado con éxito.", content = @Content),
            @ApiResponse(responseCode = "204", description = "Like eliminado con éxito.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping("/toggle/{idProducto}")
    public ResponseEntity<?> alternarLike(@Parameter(description = "Id de producto para alternar like") @PathVariable Long idProducto, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        Long idRequest = Long.parseLong(claims.get("id").toString());

        ResponseEntity<?> response;
        Like like = likeService.alternarLike(idProducto, idRequest);
        if (like == null){
            response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else{
            response = new ResponseEntity<>(like, HttpStatus.OK);
        }

        return response;

    }

}
