package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.ProductoDTO;
import com.dh.digital_booking_back.model.DTO.ProductoDTOedit;
import com.dh.digital_booking_back.model.Producto;
import java.util.List;

public interface IProductoRepository {

    void eliminarProductoXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Producto> listaNoVacia(List<Producto> lista) throws ResourceNotFoundException;

    List<Producto> listarProductos() throws ResourceNotFoundException;

    Producto buscarProductoXId(Long id) throws ResourceNotFoundException;

    List<Producto> listarProductosXCategoria(Long id) throws ResourceNotFoundException;

    List<Producto> listarProductosLikedXUsuarioId(Long id) throws ResourceNotFoundException;

    List<Producto> listarProductosXUbicacion(Long id) throws ResourceNotFoundException;

    List<Producto> listarProductosRand() throws ResourceNotFoundException;

    List<Producto> listarProductosXStringCiudad(String ciudad) throws ResourceNotFoundException;

    List<Producto> listarProductosSinReservaEntreDosFechas(String fechaInicioString, String fechaFinString) throws ResourceNotFoundException , BadRequestException;

    List<Producto> listarProductosSinReservaEntreDosFechasYCiudad(String fechaInicioString, String fechaFinString, String ciudad) throws ResourceNotFoundException , BadRequestException;

    Producto registrarProducto(ProductoDTO productoDTO) throws BadRequestException, ResourceNotFoundException;

    void editarProducto(ProductoDTOedit productoDTO) throws BadRequestException, ResourceNotFoundException;

    Producto DTO2producto(ProductoDTO productoDTO) throws BadRequestException, ResourceNotFoundException;

    Producto DTO2producto(ProductoDTOedit productoDTO) throws BadRequestException, ResourceNotFoundException;

}
