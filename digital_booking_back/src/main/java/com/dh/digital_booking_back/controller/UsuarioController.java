package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.UnauthorizedException;
import com.dh.digital_booking_back.exception.ExistException;
import com.dh.digital_booking_back.model.DTO.*;
import com.dh.digital_booking_back.model.Usuario;
import com.dh.digital_booking_back.security.jwt.JwtUtil;
import com.dh.digital_booking_back.service.UsuarioService;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@Tag(name = "Usuario",
        description = "Operaciones de usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Value("${siteURL}")
    String siteURL;

    @Autowired
    JwtUtil jwtUtil;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar usuario por ID [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario eliminado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no fue encontrado y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER eliminando usuario diferente.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarUsuario (@Parameter(description = "Id de usuario a eliminar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws BadRequestException, ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(id)){
            throw new UnauthorizedException("Intento de eliminar un usuario diferente.");
        }
        usuarioService.eliminarUsuarioXId(id);
        return ResponseEntity.ok("Se eliminó el usuario con id: " + id);

    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar todos los usuarios [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de usuarios encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de usuarios no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> listarUsuarios() throws ResourceNotFoundException {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Buscar usuario por ID [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario encontrado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "404", description = "Usuario no fue encontrado.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER buscando usuario diferente.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarUsuarioXId (@Parameter(description = "Id de usuario a buscar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(id)){
            throw new UnauthorizedException("Intento de buscar un usuario diferente.");
        }

        return ResponseEntity.ok(usuarioService.buscarUsuarioXId(id));
    }

    @Operation(summary = "Agregar nuevo usuario con rol usuario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario agregado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "409", description = "El usuario que intentó registrar tiene un correo ya registrado.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Usuario> agregarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws ResourceNotFoundException, BadRequestException, ExistException, MessagingException, UnsupportedEncodingException {
        usuarioDTO.setRol(2L);
        return new ResponseEntity<>(usuarioService.registrarUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Agregar nuevo usuario [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Usuario agregado con éxito.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Usuario.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "409", description = "El usuario que intentó registrar tiene un correo ya registrado.", content = @Content)
    })
    @PostMapping("/admin")
    public ResponseEntity<Usuario> agregarAdmin(@RequestBody UsuarioDTO usuarioDTO) throws ResourceNotFoundException, BadRequestException, ExistException, MessagingException, UnsupportedEncodingException {
        return new ResponseEntity<>(usuarioService.registrarUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Verificar correo de nuevo usuario")
    @GetMapping("/verificar/{codigo}")
    public RedirectView verificarUsuarioEmail (@Parameter(description = "Codigo de verificación") @PathVariable String codigo){
        if (usuarioService.verificacionEmail(codigo)){
            return new RedirectView(siteURL + "/verificacion_exitosa.html");
        }
        else {
            return new RedirectView(siteURL + "/verificacion_fallida.html");
        }
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar usuario [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuario editado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no fue encontrado y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER modificando usuario diferente.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarUsuario(@RequestBody UsuarioDTOedit usuarioDTO, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, BadRequestException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(usuarioDTO.getId())){
            throw new UnauthorizedException("Intento de modificar un usuario diferente.");
        }

        usuarioService.editarUsuario(usuarioDTO);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar ciudad usuario [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Usuario editado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Usuario no fue encontrado y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER modificando usuario diferente.", content = @Content)
    })
    @PutMapping("/ciudad")
    public ResponseEntity<?> editarCiudadUsuario(@RequestBody UsuarioDTOeditCiudad usuarioDTO, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, BadRequestException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(usuarioDTO.getId())){
            throw new UnauthorizedException("Intento de modificar un usuario diferente.");
        }

        usuarioService.editarCiudadUsuario(usuarioDTO);
        return ResponseEntity.noContent().build();
    }

}
