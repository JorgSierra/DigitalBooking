package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.LikeDTO;
import com.dh.digital_booking_back.repository.Implementacion.ILikeRepository;
import com.dh.digital_booking_back.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeService implements ILikeRepository {

    @Autowired
    LikeRepository likeRepository;

    @Autowired
    ProductoService productoService;

    @Autowired
    UsuarioService usuarioService;

    @Override
    public void eliminarLikeXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarLikeXId(id);
        try {
            likeRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("El like a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Like> listaNoVacia(List<Like> lista) throws ResourceNotFoundException {
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de likes.");
        }
        else {
            return lista;
        }
    }

    @Override
    public List<Like> listarLikes() throws ResourceNotFoundException {
        List<Like> lista = likeRepository.findAll();
        return listaNoVacia(lista);
    }

    @Override
    public Like buscarLikeXId(Long id) throws ResourceNotFoundException {
        Optional<Like> buscado = likeRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe like con id: " + id + ".");
        }
    }

    @Override
    public List<Like> listarLikesXProducto(Long id) throws ResourceNotFoundException {
        List<Like> lista =  likeRepository.findAllByProductoId(id);
        return listaNoVacia(lista);
    }

    @Override
    public List<Like> listarLikesXUsuario(Long id) throws ResourceNotFoundException {
        List<Like> lista =  likeRepository.findAllByUsuarioId(id);
        return listaNoVacia(lista);
    }

    @Override
    public Like registrarLike(LikeDTO likeDTO) throws BadRequestException, ResourceNotFoundException {
        Like likeAguardar = DTO2like(likeDTO);
        Like likeGuardado;
        try {
            likeGuardado = likeRepository.save(likeAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        return likeGuardado;
    }

    @Override
    public Like alternarLike(Long idProducto, Long idRequest) throws ResourceNotFoundException {

        Optional<Like> likeOptional = likeRepository.findProductoAndUsuarioLike(idProducto, idRequest);
        Like like = new Like();

        if (likeOptional.isPresent()){
            likeRepository.deleteById(likeOptional.get().getId());
            like = null;
        }
        else {
            like.setProducto(productoService.buscarProductoXId(idProducto));
            like.setUsuario(usuarioService.buscarUsuarioXId(idRequest));
            like = likeRepository.save(like);
        }

        return like;
    }

    @Override
    public Like DTO2like(LikeDTO likeDTO) throws BadRequestException, ResourceNotFoundException {

        if (likeDTO.getProducto() == null || likeDTO.getUsuario() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }

        Like like = new Like();
        Optional<Like> likeOptional = likeRepository.findProductoAndUsuarioLike(likeDTO.getProducto(), likeDTO.getUsuario());

        if (likeOptional.isPresent()){
            throw new BadRequestException("Like ya existe.");
        }
        else {
            Producto producto = productoService.buscarProductoXId(likeDTO.getProducto());
            like.setProducto(producto);

            Usuario usuario = usuarioService.buscarUsuarioXId(likeDTO.getUsuario());
            like.setUsuario(usuario);
        }

        return like;
    }
}