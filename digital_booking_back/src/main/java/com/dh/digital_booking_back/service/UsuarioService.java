package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.ExistException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.UsuarioDTO;
import com.dh.digital_booking_back.model.DTO.UsuarioDTOedit;
import com.dh.digital_booking_back.model.DTO.UsuarioDTOeditCiudad;
import com.dh.digital_booking_back.repository.Implementacion.IUsuarioRepository;
import com.dh.digital_booking_back.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements IUsuarioRepository, UserDetailsService {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    JavaMailSender mailSender;

    @Value("${siteURL}")
    String siteURL;

    @Value("${digitalBookingEmail}")
    String digitalBookingEmail;

    @Autowired
    RolService rolService;

    @Autowired
    ObjectMapper mapper;


    @Override
    public void eliminarUsuarioXId(Long id) throws ResourceNotFoundException, BadRequestException {

        buscarUsuarioXId(id);
        try {
            usuarioRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("El usuario a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Usuario> listarUsuarios() throws ResourceNotFoundException {
        List<Usuario> lista =  usuarioRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de usuarios.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Usuario buscarUsuarioXId(Long id) throws ResourceNotFoundException {
        Optional<Usuario> buscado = usuarioRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe usuario con id: " + id + ".");
        }
    }

    @Override
    public Usuario buscarUsuarioXemail(String email) throws ResourceNotFoundException {
        Optional<Usuario> buscado = usuarioRepository.findByEmail(email);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe usuario con email: " + email + ".");
        }
    }

    @Override
    public Usuario registrarUsuario(UsuarioDTO usuarioDTO) throws BadRequestException, ResourceNotFoundException, ExistException, MessagingException, UnsupportedEncodingException {
        try {
            buscarUsuarioXemail(usuarioDTO.getEmail());
        }
        catch (ResourceNotFoundException e){
            Usuario usuarioAguardar = DTO2usuario(usuarioDTO);
            Usuario usuarioGuardado;
            try {
                usuarioGuardado = usuarioRepository.save(usuarioAguardar);
            }
            catch (Exception ex){
                throw new BadRequestException("El request recibido no tiene el formato correcto.");
            }
            eviarEmailVerificacion(usuarioGuardado);
            return usuarioGuardado;
        }
        throw new ExistException("El usuario con email " + usuarioDTO.getEmail() + " que intentó registrar ya existe.");
    }

    @Override
    public void editarUsuario(UsuarioDTOedit usuarioDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            buscarUsuarioXId(usuarioDTO.getId());
            Usuario usuario = DTO2usuario(usuarioDTO);
            usuarioRepository.save(usuario);
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
    public void editarCiudadUsuario(UsuarioDTOeditCiudad usuarioDTO) throws ResourceNotFoundException, BadRequestException {
        try {
            Usuario usuario = buscarUsuarioXId(usuarioDTO.getId());
            usuario.setCiudad(usuarioDTO.getCiudad());
            usuarioRepository.save(usuario);
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
    public Usuario DTO2usuario(UsuarioDTO usuarioDTO) throws ResourceNotFoundException, BadRequestException {
        if (usuarioDTO.getNombre() == null || usuarioDTO.getApellido() == null || usuarioDTO.getEmail() == null ||
            usuarioDTO.getPassword() == null || usuarioDTO.getCiudad() == null || usuarioDTO.getRol() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        Usuario usuario = new Usuario();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setApellido(usuarioDTO.getApellido());
        usuario.setEmail(usuarioDTO.getEmail());
        usuario.setPassword(bCryptPasswordEncoder.encode(usuarioDTO.getPassword()));
        usuario.setEncriptado(true);
        usuario.setCodigoVerificacion(RandomString.make(64));
        usuario.setEnabled(false);
        usuario.setCiudad(usuarioDTO.getCiudad());

        Rol rol = rolService.buscarRolXId(usuarioDTO.getRol());
        usuario.setRol(rol);

        return usuario;
    }

    @Override
    public Usuario DTO2usuario(UsuarioDTOedit usuarioDTO) throws ResourceNotFoundException, BadRequestException {
        Usuario usuario = DTO2usuario(mapper.convertValue(usuarioDTO, UsuarioDTO.class));
        if (usuarioDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            usuario.setId(usuarioDTO.getId());
        }
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return buscarUsuarioXemail(username);
        }
        catch (ResourceNotFoundException e){
            throw new UsernameNotFoundException("Nombre de usuario (email) no encontrado.");
        }

    }
    public void eviarEmailVerificacion(Usuario usuario) throws MessagingException, UnsupportedEncodingException {

        String toAddress = usuario.getEmail();
        String fromAddress = digitalBookingEmail;
        String senderName = "Digital Booking";
        String subject = "Verifica tu registro en Digital Booking";
        String content = "Hola [[name]],<br><br>"
                + "Por favor haz click en el link para verificar tu registro:<br>"
                + "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFICAR</a></h3>"
                + "Gracias,<br>"
                + "Digital Booking.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);

        content = content.replace("[[name]]", usuario.getNombre() + " " + usuario.getApellido());

        String verifyURL = siteURL + "/api/usuarios/verificar/" + usuario.getCodigoVerificacion();
        content = content.replace("[[URL]]", verifyURL);

        helper.setText(content, true);

        mailSender.send(message);

    }

    public boolean verificacionEmail(String codigo){

        Usuario usuario = usuarioRepository.findByVerificationCode(codigo);

        if (usuario == null || usuario.isEnabled()){
            return false;
        }
        else {
            usuario.setCodigoVerificacion(null);
            usuario.setEnabled(true);
            usuarioRepository.save(usuario);
            return true;
        }
    }

}
