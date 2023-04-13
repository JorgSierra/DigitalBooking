package com.dh.digital_booking_back.model.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductoDTOedit {

    private Long id;

    private String nombre;

    private String titulo;

    private String descripcion;

    private Double precio;

    private Double latitud;

    private Double longitud;

    private Double distancia;

    private String direccion;

    private Set<Long> caracteristicas;

    private Long categoria;

    private Set<Long> politicas;

    private Long ubicacion;

}
