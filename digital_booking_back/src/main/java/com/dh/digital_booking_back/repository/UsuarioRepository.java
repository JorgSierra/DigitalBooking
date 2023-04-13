package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByEncriptadoFalse();

    @Query("SELECT u FROM Usuario u WHERE u.codigoVerificacion = :code")
    Usuario findByVerificationCode(String code);

}
