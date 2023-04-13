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
@Entity @Table(name = "roles")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    @NotNull @Size(min = 1, max = 60)
    private String nombre;

    @JsonIdentityReference(alwaysAsId = true)
    @OneToMany(mappedBy = "rol", cascade = CascadeType.ALL)
    private Set<Usuario> usuarios = new HashSet<>();

    @Override
    public String toString() {
        return ("ID: " + id +
                "\nNombre: " + nombre +
                "\nUsuarios: " + usuarios);
    }

}
