package com.dh.digital_booking_back.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ReservaDTOedit {

    private Long id;

    private String horaInicio;

    private String fechaInicio;

    private String fechaFin;

    private String datosVendedor;

    private Boolean vacunaCovid;

    private Long producto;

    private Long usuario;

}
