package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PuntuacionRepository extends JpaRepository <Puntuacion,Long> {
    List<Puntuacion> findAllByProductoId(Long id);

    List<Puntuacion> findAllByUsuarioId(Long id);

    @Query("SELECT p FROM Puntuacion p WHERE id_producto = :producto AND id_usuario = :usuario")
    Optional<Puntuacion> findProductoAndUsuarioPuntuacion(Long producto, Long usuario);
}
