package model;

import cancellation.PoliticaCancelacion;
import java.time.LocalDate;

public class ReservaNormal extends Reserva {
    public ReservaNormal(Cliente cliente, Habitacion habitacion, LocalDate desde, LocalDate hasta, PoliticaCancelacion politica) {
        super(cliente, habitacion, desde, hasta, politica);
    }

     @Override
    public void marcarCheckIn() {
        this.checkedIn = true;
        habitacion.asignar();
    }

    @Override
    public void marcarCheckOut() {
        this.checkedIn = false;
        habitacion.liberar();
    }
}
