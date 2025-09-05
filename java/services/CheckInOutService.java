package services;

import model.Reserva;
import notification.NotificadorReserva;

import java.time.LocalDate;
import java.util.List;

public class CheckInOutService {
    private final List<Reserva> reservas;
    private final NotificadorReserva notificador;

    public CheckInOutService(List<Reserva> reservas, NotificadorReserva notificador) {
        this.reservas = reservas;
        this.notificador = notificador;
    }

    public void checkIn(String reservaId, LocalDate fecha) {
        for (Reserva r : reservas) {
            if (r.getId().equals(reservaId)) {
                if (r.isCancelada()) throw new IllegalStateException("Reserva cancelada");
                if (r.isCheckedIn()) throw new IllegalStateException("Ya hizo check-in");
                r.marcarCheckIn();
                notificador.notificar("Check-in: " + reservaId);
                return;
            }
        }
        throw new IllegalArgumentException("Reserva no encontrada");
    }

    public void checkOut(String reservaId) {
        for (Reserva r : reservas) {
            if (r.getId().equals(reservaId)) {
                if (!r.isCheckedIn()) throw new IllegalStateException("No hay check-in activo");
                r.marcarCheckOut();
                notificador.notificar("Check-out: " + reservaId);
                return;
            }
        }
        throw new IllegalArgumentException("Reserva no encontrada");
    }
}
