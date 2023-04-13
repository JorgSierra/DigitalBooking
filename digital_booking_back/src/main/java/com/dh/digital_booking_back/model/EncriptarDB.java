package com.dh.digital_booking_back.model;

import com.dh.digital_booking_back.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class EncriptarDB implements ApplicationRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void run(ApplicationArguments args) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        List<Usuario> lista = usuarioRepository.findByEncriptadoFalse();
        for (Usuario usuario : lista) {
            usuario.setPassword(encoder.encode(usuario.getPassword()));
            usuario.setEncriptado(true);
            usuarioRepository.save(usuario);
        }
    }
}
