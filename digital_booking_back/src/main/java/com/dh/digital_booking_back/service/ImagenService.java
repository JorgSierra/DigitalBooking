package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.ImagenDTO;
import com.dh.digital_booking_back.model.DTO.ImagenDTOedit;
import com.dh.digital_booking_back.model.Imagen;
import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.repository.ImagenRepository;
import com.dh.digital_booking_back.repository.Implementacion.IImagenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImagenService implements IImagenRepository {

    @Autowired
    ImagenRepository imagenRepository;

    @Autowired
    ProductoService productoService;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void eliminarImagenXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarImagenXId(id);
        try {
            imagenRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La imagen a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Imagen> listarImagenes() throws ResourceNotFoundException {
        List<Imagen> lista =  imagenRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de imágenes.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Imagen buscarImagenXId(Long id) throws ResourceNotFoundException {
        Optional<Imagen> buscado = imagenRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe imagen con id: " + id + ".");
        }
    }

    @Override
    public Imagen registrarImagen(ImagenDTO imagenDTO) throws ResourceNotFoundException, BadRequestException {
        Imagen imagenAguardar = DTO2imagen(imagenDTO);
        Imagen imagenGuardada;
        try {
            imagenGuardada = imagenRepository.save(imagenAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return imagenGuardada;
    }

    @Override
    public void editarImagen(ImagenDTOedit imagenDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            buscarImagenXId(imagenDTO.getId());
            Imagen imagen = DTO2imagen(imagenDTO);
            imagenRepository.save(imagen);
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
    public Imagen DTO2imagen(ImagenDTO imagenDTO) throws ResourceNotFoundException, BadRequestException {
        if (imagenDTO.getTitulo() == null || imagenDTO.getUrlImg() == null || imagenDTO.getProducto() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        Imagen imagen = new Imagen();
        imagen.setTitulo(imagenDTO.getTitulo());
        imagen.setUrlImg(imagenDTO.getUrlImg());

        Producto productoBuscado = productoService.buscarProductoXId(imagenDTO.getProducto());
        imagen.setProducto(productoBuscado);

        return imagen;
    }

    public Imagen DTO2imagen(ImagenDTOedit imagenDTO) throws ResourceNotFoundException, BadRequestException {
        Imagen imagen = DTO2imagen(mapper.convertValue(imagenDTO, ImagenDTO.class));
        if (imagenDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            imagen.setId(imagenDTO.getId());
        }
        return imagen;
    }
}
