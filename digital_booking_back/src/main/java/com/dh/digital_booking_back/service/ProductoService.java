package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.ProductoDTO;
import com.dh.digital_booking_back.model.DTO.ProductoDTOedit;
import com.dh.digital_booking_back.repository.*;
import com.dh.digital_booking_back.repository.Implementacion.IProductoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoRepository {

    @Autowired
    ProductoRepository productoRepository;

    @Autowired
    CaracteristicaService caracteristicaService;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    PoliticaService politicaService;

    @Autowired
    UbicacionService ubicacionService;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void eliminarProductoXId(Long id) throws ResourceNotFoundException, BadRequestException {

        buscarProductoXId(id);

        try {
            productoRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("El producto a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Producto> listaNoVacia(List<Producto> lista) throws ResourceNotFoundException {
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de productos.");
        }
        else {
            return lista;
        }
    }

    @Override
    public List<Producto> listarProductos() throws ResourceNotFoundException {
        List<Producto> lista =  productoRepository.findAll();
        return listaNoVacia(lista);
    }

    @Override
    public Producto buscarProductoXId(Long id) throws ResourceNotFoundException {
        Optional<Producto> buscado = productoRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe producto con id: " + id + ".");
        }
    }

    @Override
    public List<Producto> listarProductosXCategoria(Long id) throws ResourceNotFoundException {
        List<Producto> lista =  productoRepository.findAllByCategoriaId(id);
        return listaNoVacia(lista);
    }

    @Override
    public List<Producto> listarProductosLikedXUsuarioId(Long id) throws ResourceNotFoundException {
        List<Producto> lista =  productoRepository.findByUsuarioId(id);
        return listaNoVacia(lista);
    }

    @Override
    public List<Producto> listarProductosXUbicacion(Long id) throws ResourceNotFoundException {
        List<Producto> lista =  productoRepository.findAllByUbicacionId(id);
        return listaNoVacia(lista);
    }

    @Override
    public List<Producto> listarProductosRand() throws ResourceNotFoundException {
        List<Producto> lista =  productoRepository.findRandProd();
        return listaNoVacia(lista);
    }

    @Override
    public List<Producto> listarProductosXStringCiudad(String ciudad) throws ResourceNotFoundException {
        List<Producto> lista =  productoRepository.findAllProductosByCiudadContainingIgnoreCase(ciudad);
        return listaNoVacia(lista);
    }

    @Override
    public List<Producto> listarProductosSinReservaEntreDosFechas(String fechaInicioString, String fechaFinString) throws ResourceNotFoundException, BadRequestException {
        try {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioString, DateTimeFormatter.ISO_DATE);
            LocalDate fechaFin = LocalDate.parse(fechaFinString, DateTimeFormatter.ISO_DATE);
            List<Producto> lista =  productoRepository.findAllProductosWithoutReservaBetweenDates(fechaInicio, fechaFin);
            return listaNoVacia(lista);
        }
        catch (Exception e) {
            if (e.getClass() == DateTimeParseException.class){
                throw new BadRequestException("Formato de fecha invalido, use el siguiente formato (yyyy-MM-dd).");
            }
            else if (e.getClass() == ResourceNotFoundException.class){
                throw new ResourceNotFoundException(e.getMessage());
            }
            else {
                throw new BadRequestException("El request recibido no tiene el formato correcto.");
            }
        }
    }

    @Override
    public List<Producto> listarProductosSinReservaEntreDosFechasYCiudad(String fechaInicioString, String fechaFinString, String ciudad) throws ResourceNotFoundException, BadRequestException {
        try {
            LocalDate fechaInicio = LocalDate.parse(fechaInicioString, DateTimeFormatter.ISO_DATE);
            LocalDate fechaFin = LocalDate.parse(fechaFinString, DateTimeFormatter.ISO_DATE);
            List<Producto> lista =  productoRepository.findAllProductosWithoutReservaBetweenDatesAndCiudadContaining(fechaInicio, fechaFin, ciudad);
            return listaNoVacia(lista);
        }
        catch (Exception e) {
            if (e.getClass() == DateTimeParseException.class){
                throw new BadRequestException("Formato de fecha invalido, use el siguiente formato (yyyy-MM-dd).");
            }
            else if (e.getClass() == ResourceNotFoundException.class){
                throw new ResourceNotFoundException(e.getMessage());
            }
            else {
                throw new BadRequestException("El request recibido no tiene el formato correcto.");
            }
        }
    }

    @Override
    public Producto registrarProducto(ProductoDTO productoDTO) throws BadRequestException, ResourceNotFoundException {
        Producto productoAguardar = DTO2producto(productoDTO);
        Producto productoGuardado;
        try {
            productoGuardado = productoRepository.save(productoAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return productoGuardado;
    }

    @Override
    public void editarProducto(ProductoDTOedit productoDTO) throws BadRequestException, ResourceNotFoundException {
        try {
            buscarProductoXId(productoDTO.getId());
            Producto producto = DTO2producto(productoDTO);
            productoRepository.save(producto);
        }
        catch (Exception e){
            if (e.getClass() == ResourceNotFoundException.class){
                throw new ResourceNotFoundException(e.getMessage());
            }
            else {
                throw new BadRequestException("El request recibido no tiene el formato correcto.");
            }
        }
    }

    @Override
    public Producto DTO2producto(ProductoDTO productoDTO) throws BadRequestException, ResourceNotFoundException {
        if (productoDTO.getNombre() == null || productoDTO.getTitulo() == null || productoDTO.getDescripcion() == null ||
            productoDTO.getPrecio() == null || productoDTO.getLatitud() == null || productoDTO.getLongitud() == null ||
            productoDTO.getDireccion() == null || productoDTO.getCaracteristicas() == null || productoDTO.getCategoria() == null ||
            productoDTO.getPoliticas() == null || productoDTO.getUbicacion() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setTitulo(productoDTO.getTitulo());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setLatitud(productoDTO.getLatitud());
        producto.setLongitud(productoDTO.getLongitud());
        producto.setDistancia(productoDTO.getDistancia());
        producto.setDireccion(productoDTO.getDireccion());

        for (Long caracteristica : productoDTO.getCaracteristicas()) {
            Caracteristica caracteristicaBuscado = caracteristicaService.buscarCaracteristicaXId(caracteristica);
            producto.getCaracteristicas().add(caracteristicaBuscado);
        }

        Categoria categoria = categoriaService.buscarCategoriaXId(productoDTO.getCategoria());
        producto.setCategoria(categoria);


        for (Long politica : productoDTO.getPoliticas()) {
            Politica politicaBuscado = politicaService.buscarPoliticaXId(politica);
            producto.getPoliticas().add(politicaBuscado);
        }

        Ubicacion ubicacion = ubicacionService.buscarUbicacionXId(productoDTO.getUbicacion());
        producto.setUbicacion(ubicacion);

        return producto;
    }

    @Override
    public Producto DTO2producto(ProductoDTOedit productoDTO) throws BadRequestException, ResourceNotFoundException {
        Producto producto = DTO2producto(mapper.convertValue(productoDTO, ProductoDTO.class));
        if (productoDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            producto.setId(productoDTO.getId());
        }
        return producto;
    }

}
