package com.dh.digital_booking_back.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CaracteristicaTest {

    @InjectMocks
    private Caracteristica caracteristica;

    @Mock
    private Producto producto;

    @Test
    void getNombreTest() {
        String nombre = "Característica 1";
        caracteristica.setNombre(nombre);
        Set<Producto> productos = new HashSet<>();
        productos.add(producto);
        caracteristica.setProductos(productos);
        lenient(). when(producto.getNombre()).thenReturn("Producto 1");
        String result = caracteristica.getNombre();
        assertEquals(nombre, result);
    }
}
