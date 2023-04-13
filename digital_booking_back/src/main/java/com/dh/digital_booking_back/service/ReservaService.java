package com.dh.digital_booking_back.service;

import com.dh.digital_booking_back.exception.BadRequestException;
import com.dh.digital_booking_back.exception.ResourceNotFoundException;
import com.dh.digital_booking_back.model.*;
import com.dh.digital_booking_back.model.DTO.ReservaDTO;
import com.dh.digital_booking_back.model.DTO.ReservaDTOedit;
import com.dh.digital_booking_back.repository.Implementacion.IReservaRepository;
import com.dh.digital_booking_back.repository.ReservaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements IReservaRepository {

    @Autowired
    JavaMailSender mailSender;

    @Value("${digitalBookingEmail}")
    String digitalBookingEmail;

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ProductoService productoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void eliminarReservaXId(Long id) throws ResourceNotFoundException, BadRequestException {
        buscarReservaXId(id);
        try {
            reservaRepository.deleteById(id);
        }
        catch (Exception e){
            throw new BadRequestException("La reserva  a eliminar es referencia de otras entidades." +
                    "\nPara eliminar, primero eliminar entidades que utilicen esta referencia. ");
        }
    }

    @Override
    public List<Reserva> listarReservasXProductoId(Long id) throws ResourceNotFoundException {
        List<Reserva> lista =  reservaRepository.findByProducto(id);
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de reservas.");
        }
        else {
            return lista;
        }
    }

    public List<Reserva> listarReservasXUsuarioId(Long id) throws ResourceNotFoundException {
        List<Reserva> lista =  reservaRepository.findByUsuarioId(id);
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de reservas.");
        }
        else {
            return lista;
        }
    }

    @Override
    public List<Reserva> listarReservas() throws ResourceNotFoundException {
        List<Reserva> lista =  reservaRepository.findAll();
        if (lista.isEmpty()){
            throw new ResourceNotFoundException("No existe listado de reservas.");
        }
        else {
            return lista;
        }
    }

    @Override
    public Reserva buscarReservaXId(Long id) throws ResourceNotFoundException {
        Optional<Reserva> buscado = reservaRepository.findById(id);
        if (buscado.isPresent()){
            return buscado.get();
        }
        else {
            throw new ResourceNotFoundException("No existe reserva con id: " + id + ".");
        }
    }

    @Override
    public Reserva registrarReserva(ReservaDTO reservaDTO) throws BadRequestException, ResourceNotFoundException, MessagingException, UnsupportedEncodingException {
        Reserva reservaAguardar = DTO2reserva(reservaDTO);
        Reserva reservaGuardada;
        try {
            reservaGuardada = reservaRepository.save(reservaAguardar);
        }
        catch (Exception e){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        eviarEmailConfirmacion(reservaGuardada);
        return reservaGuardada;
    }

    @Override
    public void editarReserva(ReservaDTOedit reservaDTO) throws BadRequestException, ResourceNotFoundException {
        try {
            buscarReservaXId(reservaDTO.getId());
            Reserva reserva = DTO2reserva(reservaDTO);
            reservaRepository.save(reserva);
        }
        catch (Exception e){
            if (e.getClass() == ResourceNotFoundException.class){
                throw new ResourceNotFoundException(e.getMessage());
            }
            else {
                throw new BadRequestException("El request recibido no tiene el formato correcto.");
            }
        }
    }

    @Override
    public Reserva DTO2reserva(ReservaDTO reservaDTO) throws BadRequestException, ResourceNotFoundException {
        if (reservaDTO.getHoraInicio() == null || reservaDTO.getFechaInicio() == null || reservaDTO.getFechaFin() == null ||
            reservaDTO.getProducto() == null || reservaDTO.getUsuario() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }

        Reserva reserva = new Reserva();

        try {
            LocalTime horaInicio = LocalTime.parse(reservaDTO.getHoraInicio(), DateTimeFormatter.ISO_LOCAL_TIME);
            reserva.setHoraInicio(horaInicio);
            LocalDate fechaInicio = LocalDate.parse(reservaDTO.getFechaInicio(), DateTimeFormatter.ISO_DATE);
            reserva.setFechaInicio(fechaInicio);
            LocalDate fechaFin = LocalDate.parse(reservaDTO.getFechaFin(), DateTimeFormatter.ISO_DATE);
            reserva.setFechaFin(fechaFin);
        }
        catch (DateTimeParseException e){
            throw new BadRequestException("Formato invalido:" +
                    "\n  Fecha: (yyyy-MM-dd)." +
                    "\n  Hora: (KK:mm) 24 horas.");
        }

        reserva.setDatosVendedor(reservaDTO.getDatosVendedor());
        reserva.setVacunaCovid(reservaDTO.getVacunaCovid());

        Producto productoBuscado = productoService.buscarProductoXId(reservaDTO.getProducto());
        reserva.setProducto(productoBuscado);

        Usuario usuarioBuscado = usuarioService.buscarUsuarioXId(reservaDTO.getUsuario());
        reserva.setUsuario(usuarioBuscado);



        return reserva;
    }

    @Override
    public Reserva DTO2reserva(ReservaDTOedit reservaDTO) throws BadRequestException, ResourceNotFoundException {
        Reserva reserva = DTO2reserva(mapper.convertValue(reservaDTO, ReservaDTO.class));
        if (reservaDTO.getId() == null){
            throw new BadRequestException("El request recibido no tiene el formato correcto.");
        }
        else {
            reserva.setId(reservaDTO.getId());
        }
        return reserva;
    }

    public void eviarEmailConfirmacion(Reserva reserva) throws MessagingException, UnsupportedEncodingException {

        String toAddress = reserva.getUsuario().getEmail();
        String fromAddress = digitalBookingEmail;
        String senderName = "Digital Booking";
        String subject = "Confirmación de reserva en Digital Booking";
        String content = "Hola [[name]],<br><br>"
                + "Tu reserva ha sido realizada con éxito:<br><br>"
                + "Reserva en: [[tituloProducto]]<br>"
                + "Desde: [[fechaInicio]]<br>"
                + "Hasta: [[fechaFin]]<br><br>"
                + "Gracias,<br>"
                + "Digital Booking.";

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setFrom(fromAddress, senderName);
        helper.setTo(toAddress);
        helper.setSubject(subject);


        content = content.replace("[[name]]", reserva.getUsuario().getNombre() + " " + reserva.getUsuario().getApellido());
        content = content.replace("[[tituloProducto]]", reserva.getProducto().getNombre());
        content = content.replace("[[fechaInicio]]", reserva.getFechaInicio().format(DateTimeFormatter.ISO_DATE));
        content = content.replace("[[fechaFin]]", reserva.getFechaFin().format(DateTimeFormatter.ISO_DATE));


        helper.setText(content, true);

        mailSender.send(message);

    }

}
