package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findAllByCategoriaId(Long id);

    List<Producto> findAllByUbicacionId(Long id);

    @Query(value = "SELECT * FROM productos p ORDER BY RAND() LIMIT 8", nativeQuery = true)
    List<Producto> findRandProd();

    @Query("SELECT p FROM Producto p WHERE LOWER(p.ubicacion.ciudad) LIKE LOWER(CONCAT(:ciudad, '%'))")
    List<Producto> findAllProductosByCiudadContainingIgnoreCase(String ciudad);

    @Query("SELECT p FROM Producto p WHERE NOT EXISTS (SELECT r FROM p.reservas r WHERE r.fechaInicio <= :fechaFin AND r.fechaFin >= :fechaInicio)")
    List<Producto> findAllProductosWithoutReservaBetweenDates(LocalDate fechaInicio, LocalDate fechaFin);

    @Query("SELECT p FROM Producto p WHERE NOT EXISTS (SELECT r FROM p.reservas r WHERE r.fechaInicio <= :fechaFin AND r.fechaFin >= :fechaInicio) AND LOWER(p.ubicacion.ciudad) LIKE LOWER(CONCAT(:ciudad, '%'))")
    List<Producto> findAllProductosWithoutReservaBetweenDatesAndCiudadContaining(LocalDate fechaInicio, LocalDate fechaFin, String ciudad);

    @Query("SELECT p FROM Producto p JOIN p.likes l WHERE l.usuario.id = :usuarioId")
    List<Producto> findByUsuarioId(Long usuarioId);

}
