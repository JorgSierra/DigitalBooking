package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.LikeDTO;
import com.dh.digital_booking_back.model.Like;

import java.util.List;

public interface ILikeRepository {

    void eliminarLikeXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Like> listaNoVacia(List<Like> lista) throws ResourceNotFoundException;

    List<Like> listarLikes() throws ResourceNotFoundException;

    Like buscarLikeXId(Long id) throws ResourceNotFoundException;

    List<Like> listarLikesXProducto(Long id) throws ResourceNotFoundException;

    List<Like> listarLikesXUsuario(Long id) throws ResourceNotFoundException;

    Like registrarLike(LikeDTO likeDTO) throws BadRequestException, ResourceNotFoundException;

    Like alternarLike(Long idProducto, Long idRequest) throws ResourceNotFoundException;

    Like DTO2like(LikeDTO likeDTO) throws BadRequestException, ResourceNotFoundException;

}
