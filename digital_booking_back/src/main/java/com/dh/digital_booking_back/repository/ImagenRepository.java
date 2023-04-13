package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagenRepository extends JpaRepository<Imagen, Long> {

    List<Imagen> findAllByProductoId(Long id);

}
