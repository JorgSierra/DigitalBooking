package com.dh.digital_booking_back.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String nombre;

    private String apellido;

    private String email;

    private String password;

    private String ciudad;

    private Long rol;

}
