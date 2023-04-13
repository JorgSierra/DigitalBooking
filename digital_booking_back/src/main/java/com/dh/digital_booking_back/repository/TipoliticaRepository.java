package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Tipolitica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoliticaRepository extends JpaRepository<Tipolitica, Long> {
}
