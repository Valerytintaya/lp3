package availability;

import model.Reserva;
import model.Habitacion;

import java.time.LocalDate;
import java.util.Vector;

public class GestorDisponibilidad {
    private final Vector<Reserva> reservas;

    public GestorDisponibilidad(Vector<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean estaDisponible(Habitacion h, LocalDate desde, LocalDate hasta) {
        if (h.isOcupada()) return false;
        if (desde == null || hasta == null || !desde.isBefore(hasta)) return false;

        for (Reserva r : reservas) {
            if (r.isCancelada()) continue;
            if (!r.getHabitacion().getId().equals(h.getId())) continue;
            if (solapan(r.getDesde(), r.getHasta(), desde, hasta)) return false;
        }
        return true;
    }

    private boolean solapan(LocalDate a1, LocalDate a2, LocalDate b1, LocalDate b2) {
        return a1.isBefore(b2) && b1.isBefore(a2);
    }

    public Vector<Reserva> getReservas(){ return reservas; }
}
