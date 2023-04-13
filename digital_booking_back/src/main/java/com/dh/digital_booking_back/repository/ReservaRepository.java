package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    @Query("SELECT r FROM Reserva r JOIN r.producto p WHERE p.id = :id")
    List<Reserva> findByProducto(Long id);

    List<Reserva> findByUsuarioId(Long id);
}
