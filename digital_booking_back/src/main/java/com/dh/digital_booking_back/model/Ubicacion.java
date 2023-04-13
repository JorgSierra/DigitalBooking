package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "ubicaciones")
public class Ubicacion {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "ciudad")
    @NotNull @Size(min = 1, max = 250)
    private String ciudad;

    @Column(name = "pais")
    @NotNull @Size(min = 1, max = 250)
    private String pais;

    @Column(name = "continente")
    @NotNull @Size(min = 1, max = 250)
    private String continente;

    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "ubicacion", cascade = CascadeType.MERGE)
    private Set<Producto> productos = new HashSet<>();

}

