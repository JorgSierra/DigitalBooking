package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @NotNull
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "nombre")
    @Size(min = 1, max = 60)
    private String nombre;

    @NotNull
    @Column(name = "apellido")
    @Size(min = 1, max = 60)
    private String apellido;

    @NotNull
    @Column(name = "email")
    @Size(min = 1, max = 255)
    private String email;

    @JsonIgnore
    @NotNull
    @Column(name = "password")
    @Size(min = 1, max = 255)
    private String password;

    @JsonIgnore
    @NotNull
    @Column(name = "encriptado")
    private Boolean encriptado;

    @JsonIgnore
    @Column(name = "codigo_verificacion", length = 64)
    private String codigoVerificacion;

    @JsonIgnore
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;

    @NotNull
    @Column(name = "ciudad")
    @Size(min = 1, max = 60)
    private String ciudad;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol", referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateEagerInitializer", "handler", "usuarios"})
    private Rol rol;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Reserva> reservas;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Like> likes;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Set<Puntuacion> puntuaciones;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(rol.getNombre());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    @JsonIgnore
    public String getUsername() {
        return email;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public String toString() {
        return ("ID: " + id +
                "\nEmail: " + email +
                "\nRol: " + rol.getNombre() + "\n ");
    }
}


