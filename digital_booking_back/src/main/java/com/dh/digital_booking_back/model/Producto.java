package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "productos")
public class Producto {

    @NotNull
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    @NotNull @Size(min = 1, max = 250)
    private String nombre;

    @Column(name = "titulo")
    @NotNull @Size(min = 1, max = 250)
    private String titulo;

    @Column(name = "descripcion")
    @NotNull @Size(min = 1)
    private String descripcion;

    @Column(name = "precio")
    @NotNull
    private Double precio;

    @Column @NotNull
    private Double latitud;

    @Column @NotNull
    private Double longitud;

    @Column(name = "distancia")
    private Double distancia;

    @Column @NotNull @Size(min = 1,max = 250)
    private String direccion;

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "productos_caracteristicas",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_caracteristica")
    )
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Set<Caracteristica> caracteristicas = new HashSet<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoria", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Categoria categoria;

    @JsonIgnoreProperties(value = {"producto"})
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Imagen> imagenes = new HashSet<>();

    @NotNull
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "productos_politicas",
            joinColumns = @JoinColumn(name = "id_producto"),
            inverseJoinColumns = @JoinColumn(name = "id_politica")
    )
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Set<Politica> politicas = new HashSet<>();

    @JsonIgnoreProperties(value = {"producto"})
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Puntuacion> puntuaciones = new HashSet<>();

    @JsonIgnoreProperties(value = {"producto"})
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Reserva> reservas = new HashSet<>();

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ubicacion", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "productos"})
    private Ubicacion ubicacion;

    @JsonIgnoreProperties(value = {"producto"})
    @OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
    private Set<Like> likes = new HashSet<>();

}

