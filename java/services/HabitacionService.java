package services;

import java.util.*;
import model.Habitacion;
import model.HabitacionEstandar;
import model.Suite;

public class HabitacionService {
    private final List<Habitacion> habitaciones = new ArrayList<>();

    public Habitacion crearHabitacion(String numero, String tipo, double precioBase) {
        Habitacion h;
        if ("suite".equalsIgnoreCase(tipo)) h = new Suite(numero, precioBase);
        else h = new HabitacionEstandar(numero, precioBase);
        habitaciones.add(h);
        return h;
    }

    public Habitacion buscarHabitacion(String id) {
        return habitaciones.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst().orElse(null);
    }
    public List<Habitacion> listarHabitaciones() { return habitaciones; }
}
