package com.dh.digital_booking_back.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PuntuacionDTO {

    private Double valor;

    private Long producto;

    private Long usuario;

}
