package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "politicas")
public class Politica {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "titulo")
    @NotNull @Size (min = 1, max = 250)
    private String titulo;

    @Column(name = "descripcion")
    @NotNull @Size(min = 1)
    private String descripcion;

    @JsonIgnore
    @ManyToMany(mappedBy = "politicas", cascade = CascadeType.MERGE)
    private Set<Producto> productos = new HashSet<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipolitica", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "politicas"})
    private Tipolitica tipolitica;

}
