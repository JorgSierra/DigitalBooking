package com.dh.digital_booking_back.repository.Implementacion;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.DTO.ReservaDTO;
import com.dh.digital_booking_back.model.DTO.ReservaDTOedit;
import com.dh.digital_booking_back.model.Reserva;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IReservaRepository {

    void eliminarReservaXId(Long id) throws ResourceNotFoundException, BadRequestException;

    List<Reserva> listarReservas() throws ResourceNotFoundException;

    List<Reserva> listarReservasXProductoId(Long id) throws ResourceNotFoundException;

    Reserva buscarReservaXId(Long id) throws ResourceNotFoundException;

    Reserva registrarReserva(ReservaDTO reservaDTO) throws BadRequestException, ResourceNotFoundException, MessagingException, UnsupportedEncodingException;

    void editarReserva(ReservaDTOedit reservaDTO) throws BadRequestException, ResourceNotFoundException;

    Reserva DTO2reserva(ReservaDTO reservaDTO) throws BadRequestException, ResourceNotFoundException;

    Reserva DTO2reserva(ReservaDTOedit reservaDTO) throws BadRequestException, ResourceNotFoundException;
}
