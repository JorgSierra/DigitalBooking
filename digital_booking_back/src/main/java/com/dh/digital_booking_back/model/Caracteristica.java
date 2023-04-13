package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Entity @Table(name = "caracteristicas")
public class Caracteristica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    @NotNull @Size(min = 1, max = 100)
    private String nombre;

    @Column @NotNull @Size(min = 1,max = 250)
    private String icono;

    @JsonIgnore
    @ManyToMany(mappedBy = "caracteristicas", cascade = CascadeType.MERGE)
    private Set<Producto> productos = new HashSet<>();

}
