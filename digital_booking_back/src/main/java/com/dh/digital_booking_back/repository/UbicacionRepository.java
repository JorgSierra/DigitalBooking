package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Long> {

    @Query("SELECT u FROM Ubicacion u WHERE LOWER(u.ciudad) LIKE LOWER(CONCAT(:ciudad, '%'))")
    List<Ubicacion> findUbicacionByCiudadContaining(String ciudad);

}
