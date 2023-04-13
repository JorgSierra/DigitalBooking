package com.dh.digital_booking_back.repository;

import com.dh.digital_booking_back.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findAllByProductoId(Long id);

    List<Like> findAllByUsuarioId(Long id);

    @Query("SELECT l FROM Like l WHERE id_producto = :producto AND id_usuario = :usuario")
    Optional<Like> findProductoAndUsuarioLike(Long producto, Long usuario);

}
