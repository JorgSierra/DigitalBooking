package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "imagenes")
public class Imagen {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    @Column(name = "id")
    private Long id;

    @NotNull @Size(min = 1, max = 250)
    @Column(name = "titulo")
    private String titulo;

    @NotNull @Size (min = 1, max = 250)
    @Column(name = "url_img")
    private String urlImg;

    @NotNull
    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Producto producto;

}

