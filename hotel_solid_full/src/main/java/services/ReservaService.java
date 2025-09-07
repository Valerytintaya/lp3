package services;

import availability.GestorDisponibilidad;
import cancellation.PoliticaCancelacion;
import java.time.LocalDate;
import java.util.*;
import model.*;
import notification.NotificadorReserva;
import pricing.CalculadoraPrecio;

public class ReservaService {
    private final Vector<Reserva> reservas = new Vector<>();
    private final GestorDisponibilidad gestor;
    private final NotificadorReserva notificador;
    private final CalculadoraPrecio calculadora;

    public ReservaService(NotificadorReserva notificador, CalculadoraPrecio calculadora) {
        this.notificador = notificador;
        this.calculadora = calculadora;
        this.gestor = new GestorDisponibilidad(reservas);
    }

    public String crearReserva(Cliente cliente, Habitacion habitacion, LocalDate desde, LocalDate hasta, PoliticaCancelacion politica) {
        if (!gestor.estaDisponible(habitacion, desde, hasta)) throw new IllegalStateException("No disponible");
        Reserva r = new ReservaNormal(cliente, habitacion, desde, hasta, politica);
        reservas.add(r);
        notificador.notificar("Reserva creada: " + r.getId());
        return r.getId();
    }

    public boolean cancelarReserva(String reservaId, LocalDate fechaSolicitud) {
        for (Reserva r : reservas) {
            if (r.getId().equals(reservaId)) {
                double factor = r.getPolitica().penalizacion(r, fechaSolicitud);
                r.marcarCancelada();
                notificador.notificar("Reserva " + reservaId + " cancelada. Penalización: " + (factor*100) + "%.");
                return true;
            }
        }
        return false;
    }

    public List<Reserva> listarReservas() { return reservas; }
}
