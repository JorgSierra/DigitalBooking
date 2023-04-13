package com.dh.digital_booking_back.controller;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.UnauthorizedException;
import com.dh.digital_booking_back.model.DTO.FechasDTO;
import com.dh.digital_booking_back.model.DTO.FechasYCiudadDTO;
import com.dh.digital_booking_back.model.DTO.ProductoDTO;
import com.dh.digital_booking_back.model.DTO.ProductoDTOedit;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.security.jwt.JwtUtil;
import com.dh.digital_booking_back.service.ProductoService;
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
@RequestMapping("/api/productos")
@Tag(name = "Producto",
        description = "Operaciones de productos")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @Autowired
    JwtUtil jwtUtil;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Eliminar producto por ID [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no fue encontrado y no se eliminó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarProducto (@Parameter(description = "Id de producto a eliminar") @PathVariable Long id) throws BadRequestException, ResourceNotFoundException {
        productoService.eliminarProductoXId(id);
        return ResponseEntity.ok("Se eliminó el producto con id: " + id);
    }

    @Operation(summary = "Listar todos los productos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos() throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    @Operation(summary = "Buscar producto por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Producto no fue encontrado.", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<Producto> buscarProductoXId(@Parameter(description = "Id de producto a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.buscarProductoXId(id));
    }

    @Operation(summary = "Listar productos por categoría ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content)
    })
    @GetMapping("/categoria/{id}")
    public ResponseEntity <List<Producto>> buscarProductosXCategoria(@Parameter(description = "Id de categoría a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.listarProductosXCategoria(id));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Listar productos liked por usuario ID [ADMIN, USER: del user que hace el request]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content),
            @ApiResponse(responseCode = "401", description = "USER buscando likes de usuario diferente.", content = @Content)
    })
    @GetMapping("/usuario/{id}")
    public ResponseEntity <List<Producto>> buscarProductosLikedXUsuarioId(@Parameter(description = "Id de usuario a buscar") @PathVariable Long id, @Parameter(hidden = true) @RequestHeader (name="Authorization") String token) throws ResourceNotFoundException, UnauthorizedException {

        token = token.replace("Bearer ","");
        Claims claims = jwtUtil.extractAllClaims(token);
        String rolRequest = claims.get("role").toString();
        Long idRequest = Long.parseLong(claims.get("id").toString());

        if (rolRequest.equals("ROLE_USER") && !idRequest.equals(id)){
            throw new UnauthorizedException("Intento de buscar un usuario diferente.");
        }

        return ResponseEntity.ok(productoService.listarProductosLikedXUsuarioId(id));

    }

    @Operation(summary = "Listar productos por ubicación ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content)
    })
    @GetMapping("/ubicacion/{id}")
    public ResponseEntity <List<Producto>> buscarProductoXCiudad(@Parameter(description = "Id de ubicación a buscar") @PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.listarProductosXUbicacion(id));
    }

    @Operation(summary = "Listar 8 productos aleatoriamente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content)
    })
    @GetMapping("/rand")
    public ResponseEntity <List<Producto>> listarProductosAleatorio() throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.listarProductosRand());
    }

    @Operation(summary = "Listar productos por ciudad que contenga string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content)
    })
    @GetMapping("ubicacion/ciudad/{ciudad}")
    public ResponseEntity<List<Producto>> listarProductosXCiudad(@Parameter(description = "String de ciudad a buscar") @PathVariable String ciudad) throws ResourceNotFoundException {
        return ResponseEntity.ok(productoService.listarProductosXStringCiudad(ciudad));
    }

    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Agregar nuevo producto [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto agregado con éxito.",
                    content = {@Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PostMapping
    public ResponseEntity<Producto> agregarProducto(@RequestBody ProductoDTO productoDTO) throws ResourceNotFoundException, BadRequestException {
        return new ResponseEntity<>(productoService.registrarProducto(productoDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Listar productos sin reservas entre 2 fechas (yyyy-MM-dd)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content)
    })
    @PostMapping("/disponible")
    public ResponseEntity<List<Producto>> ListarProductosSinReservaEntreDosFechas (@RequestBody FechasDTO fechasDTO) throws ResourceNotFoundException, BadRequestException {
        return ResponseEntity.ok(productoService.listarProductosSinReservaEntreDosFechas(fechasDTO.getFechaInicio(), fechasDTO.getFechaFin()));
    }

    @Operation(summary = "Listar productos de una ciudad que contenga string y sin reservas entre 2 fechas (yyyy-MM-dd)")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos encontrada con éxito.",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class))}),
            @ApiResponse(responseCode = "404", description = "Lista de productos no fue encontrada.", content = @Content)
    })
    @PostMapping("/disponibleYCiudad")
    public ResponseEntity<List<Producto>> ListarProductosSinReservaEntreDosFechasYConCiudad (@RequestBody FechasYCiudadDTO fechasDTO) throws ResourceNotFoundException, BadRequestException {
        return ResponseEntity.ok(productoService.listarProductosSinReservaEntreDosFechasYCiudad(fechasDTO.getFechaInicio(), fechasDTO.getFechaFin(), fechasDTO.getCiudad()) );
    }

    @CrossOrigin(origins = "*", maxAge = 3600)
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(summary = "Editar producto [ADMIN]")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Producto editado con éxito.", content = @Content),
            @ApiResponse(responseCode = "400", description = "Error en request recibido.", content = @Content),
            @ApiResponse(responseCode = "404", description = "Producto no fue encontrado y no se modificó.", content = @Content),
            @ApiResponse(responseCode = "403", description = "No tiene permisos.", content = @Content)
    })
    @PutMapping
    public ResponseEntity<?> editarProducto(@RequestBody ProductoDTOedit productoDTO) throws ResourceNotFoundException, BadRequestException {
        productoService.editarProducto(productoDTO);
        return ResponseEntity.noContent().build();
    }
}
