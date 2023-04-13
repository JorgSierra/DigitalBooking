package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ExistException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.PuntuacionDTO;
import com.dh.digital_booking_back.model.DTO.PuntuacionDTOedit;
import com.dh.digital_booking_back.model.Like;
import com.dh.digital_booking_back.model.Producto;
import com.dh.digital_booking_back.model.Puntuacion;
import com.dh.digital_booking_back.model.Usuario;
import com.dh.digital_booking_back.repository.Implementacion.IPuntuacionRepository;
import com.dh.digital_booking_back.repository.PuntuacionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PuntuacionService implements IPuntuacionRepository {

    @Autowired
    PuntuacionRepository puntuacionRepository;
    @Autowired
    ProductoService productoService;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public void eliminarPuntuacionXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarPuntuacionXId(id);
        try {
            puntuacionRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La puntuación  a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Puntuacion> listarPuntuaciones() throws ResourceNotFoundException {
        List<Puntuacion> lista =  puntuacionRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de puntuaciones.");
        }
        else {
            return lista;
        }
    }

    @Override
    public List<Puntuacion> listarPuntuacionXProductoId(Long id) throws ResourceNotFoundException {
        List<Puntuacion> lista =  puntuacionRepository.findAllByProductoId(id);
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de puntuaciones.");
        }
        else {
            return lista;
        }
    }

    @Override
    public List<Puntuacion> listarPuntuacionXUsuarioId(Long id) throws ResourceNotFoundException {
        List<Puntuacion> lista =  puntuacionRepository.findAllByUsuarioId(id);
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de puntuaciones.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Puntuacion buscarPuntuacionXId(Long id) throws ResourceNotFoundException {
        Optional<Puntuacion> buscado = puntuacionRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe puntuación con id: " + id + ".");
        }
    }

    @Override
    public Puntuacion registrarEditarPuntuacion(PuntuacionDTO puntuacionDTO) throws BadRequestException, ResourceNotFoundException {

        Puntuacion puntuacionAguardar = DTO2puntuacion(puntuacionDTO);
        Optional<Puntuacion> puntuacionOptional = puntuacionRepository.findProductoAndUsuarioPuntuacion(puntuacionDTO.getProducto(),puntuacionDTO.getUsuario());
        puntuacionOptional.ifPresent(puntuacion -> puntuacionAguardar.setId(puntuacion.getId()));

        Puntuacion puntuacionGuardada;
        try {
            puntuacionGuardada = puntuacionRepository.save(puntuacionAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return puntuacionGuardada;
    }

    @Override
    public Puntuacion DTO2puntuacion(PuntuacionDTO puntuacionDTO) throws ResourceNotFoundException, BadRequestException {
        if (puntuacionDTO.getValor() == null || puntuacionDTO.getProducto() == null || puntuacionDTO.getUsuario() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        Puntuacion puntuacion = new Puntuacion();
        puntuacion.setValor(puntuacionDTO.getValor());

        Producto productoBuscado = productoService.buscarProductoXId(puntuacionDTO.getProducto());
        puntuacion.setProducto(productoBuscado);

        Usuario usuarioBuscado = usuarioService.buscarUsuarioXId(puntuacionDTO.getUsuario());
        puntuacion.setUsuario(usuarioBuscado);

        return puntuacion;
    }

}