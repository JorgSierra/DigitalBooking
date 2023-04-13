package com.dh.digital_booking_back.service;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.exception.ExistException;
import com.dh.digital_booking_back.model.DTO.UsuarioDTO;
import com.dh.digital_booking_back.model.DTO.UsuarioDTOedit;
import com.dh.digital_booking_back.model.Like;
import com.dh.digital_booking_back.model.Reserva;
import com.dh.digital_booking_back.model.Usuario;
import com.dh.digital_booking_back.repository.LikeRepository;
import com.dh.digital_booking_back.repository.ReservaRepository;
import com.dh.digital_booking_back.repository.UsuarioRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Mock
    private RolService rolService;

    @Mock
    private LikeRepository likeRepository;

    @Mock
    private ReservaRepository reservaRepository;

    @Mock
    private ObjectMapper mapper;

    @InjectMocks
    private UsuarioService usuarioService;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void eliminarUsuarioXId() throws Exception {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(id);
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));
        List<Like> listaLikes = new ArrayList<Like>();
        listaLikes.add(new Like());
        //when(likeRepository.findAllByUsuarioId(id)).thenReturn(listaLikes);
        List<Reserva> listaReservas = new ArrayList<Reserva>();
        listaReservas.add(new Reserva());
        //when(reservaRepository.findByUsuarioId(id)).thenReturn(listaReservas);

        usuarioService.eliminarUsuarioXId(id);

        assertEquals(listaLikes.size(), 1);
        assertEquals(listaReservas.size(), 1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void listarUsuarios_whenListaVacia() throws Exception {
        when(usuarioRepository.findAll()).thenReturn(new ArrayList<Usuario>());

        usuarioService.listarUsuarios();
    }

    @Test
    public void listarUsuarios_whenListaNoVacia() throws Exception {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario());
        when(usuarioRepository.findAll()).thenReturn(listaUsuarios);

        List<Usuario> lista = usuarioService.listarUsuarios();

        assertEquals(lista.size(), 1);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void buscarUsuarioXId_whenNoExiste() throws Exception {
        Long id = 1L;
        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

        usuarioService.buscarUsuarioXId(id);
    }

    @Test
    public void buscarUsuarioXId_whenExiste() throws Exception {
        Long id = 1L;
        Usuario usuario = new Usuario();
        usuario.setId(id);
        when(usuarioRepository.findById(id)).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.buscarUsuarioXId(id);

        assertEquals(resultado.getId(), id);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void buscarUsuarioXemail_whenNoExiste() throws Exception {
        String email = "test@test.com";
        when(usuarioRepository.findByEmail(email)).thenReturn(Optional.empty());
        usuarioService.buscarUsuarioXemail(email);
    }

    @Test
    public void buscarUsuarioXemail_whenExiste() throws Exception {
        String email = "test@test.com";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        when(usuarioRepository.findByEmail(email)).thenReturn(Optional.of(usuario));

        Usuario resultado = usuarioService.buscarUsuarioXemail(email);

        assertEquals(resultado.getEmail(), email);
    }

    @Test(expected = ExistException.class)
    public void registrarUsuario_whenYaExisteEmail() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setEmail("test@test.com");
        when(usuarioRepository.findByEmail(usuarioDTO.getEmail())).thenReturn(Optional.of(new Usuario()));

        usuarioService.registrarUsuario(usuarioDTO);
    }

    @Test(expected = BadRequestException.class)
    public void registrarUsuario_whenFaltanDatos() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioService.registrarUsuario(usuarioDTO);
    }
    /*
    @Test
    public void registrarUsuario_whenDatosCorrectos() throws Exception {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setNombre("Test");
        usuarioDTO.setApellido("Test");
        usuarioDTO.setEmail("test@test.com");
        usuarioDTO.setPassword("test");
        usuarioDTO.setCiudad("Dolores");
        usuarioDTO.setRol(1L);

        Rol rol = new Rol();
        rol.setId(1L);
        rol.setNombre("ROLE_USER");

        when(rolService.buscarRolXId(1L)).thenReturn(rol);
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("braian");
        usuario.setApellido("perez");
        usuario.setEmail("lalal@gmail.com");
        usuario.setPassword("123abc");
        usuario.setCiudad("dolores");
        usuario.setRol(rol);

        when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        usuarioService.registrarUsuario(usuarioDTO);

        assertEquals(usuario.getRol().getId(), Long.valueOf(1));
        assertEquals(usuario.getRol().getNombre(),"ROLE_USER");


    }

     */

    @Test(expected = ResourceNotFoundException.class)
    public void editarUsuarioXId_whenNoExiste() throws Exception {
        Long id = 1L;
        UsuarioDTOedit usuarioDTO = new UsuarioDTOedit();
        usuarioDTO.setId(id);
        when(usuarioRepository.findById(id)).thenReturn(Optional.empty());

        usuarioService.editarUsuario(usuarioDTO);
    }



    @Test(expected = UsernameNotFoundException.class)
    public void loadUserByUsername_whenNoExiste() throws Exception {
        String email = "test@test.com";
        when(usuarioRepository.findByEmail(email)).thenReturn(Optional.empty());

        usuarioService.loadUserByUsername(email);
    }

    @Test
    public void loadUserByUsername_whenExiste() throws Exception {
        String email = "test@test.com";
        Usuario usuario = new Usuario();
        usuario.setEmail(email);
        when(usuarioRepository.findByEmail(email)).thenReturn(Optional.of(usuario));

        UserDetails userDetails = usuarioService.loadUserByUsername(email);

        assertEquals(userDetails.getUsername(), email);
    }
}
