package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.ExistException;
import com.dh.digital_booking_back.model.DTO.UsuarioDTO;
import com.dh.digital_booking_back.model.DTO.UsuarioDTOedit;
import com.dh.digital_booking_back.model.DTO.UsuarioDTOeditCiudad;
import com.dh.digital_booking_back.model.Usuario;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IUsuarioRepository {

    void eliminarUsuarioXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Usuario> listarUsuarios() throws ResourceNotFoundException;

    Usuario buscarUsuarioXId(Long id) throws ResourceNotFoundException;

    Usuario buscarUsuarioXemail(String email) throws ResourceNotFoundException;

    Usuario registrarUsuario(UsuarioDTO usuarioDTO) throws BadRequestException, ResourceNotFoundException, ExistException, MessagingException, UnsupportedEncodingException;

    void editarUsuario(UsuarioDTOedit usuarioDTO) throws ResourceNotFoundException, BadRequestException;

    void editarCiudadUsuario(UsuarioDTOeditCiudad usuarioDTO) throws ResourceNotFoundException, BadRequestException;

    Usuario DTO2usuario(UsuarioDTO usuarioDTO) throws ResourceNotFoundException, BadRequestException;

    Usuario DTO2usuario(UsuarioDTOedit usuarioDTO) throws ResourceNotFoundException, BadRequestException;

}
