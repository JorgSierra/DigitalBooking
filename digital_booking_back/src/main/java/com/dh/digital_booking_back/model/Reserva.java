package com.dh.digital_booking_back.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "reservas")
public class  Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @NotNull
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "hora_inicio")
    @JsonFormat(pattern = "KK:mm a")
    private LocalTime horaInicio;

    @NotNull
    @Column(name = "fecha_inicio")
    private LocalDate fechaInicio;

    @NotNull
    @Column(name = "fecha_fin")
    private LocalDate fechaFin;

    @Column(name = "datos_vendedor")
    @Size(min = 1, max = 255)
    private String datosVendedor;

    @Column(name = "vacuna_covid")
    private Boolean vacunaCovid;

    @JsonIdentityReference(alwaysAsId = true)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_producto",referencedColumnName = "id")
    @JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
    private Producto producto;

    @JsonIgnore
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario",referencedColumnName = "id")
    private Usuario usuario;
}
