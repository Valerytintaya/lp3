package services;

import java.time.LocalDate;
import java.util.List;
import model.Habitacion;
import model.Reserva;

public class ReporteService {

    public double ocupacion(List<Habitacion> habitaciones, List<Reserva> reservas, LocalDate desde, LocalDate hasta) {
        long total = habitaciones.size();
        long ocupadas = reservas.stream()
                .filter(r -> !r.isCancelada() && r.getDesde().isBefore(hasta) && r.getHasta().isAfter(desde))
                .map(r -> r.getHabitacion().getId())
                .distinct().count();
        return (ocupadas * 100.0) / total;
    }
}


