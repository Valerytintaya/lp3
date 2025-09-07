package model;

import cancellation.*;
import java.time.LocalDate;          
public abstract class Reserva {
    protected final String id;
    protected final Cliente cliente;
    protected final Habitacion habitacion;
    protected final LocalDate desde;
    protected final LocalDate hasta;
    protected boolean cancelada = false;
    protected boolean checkedIn = false;
    protected PoliticaCancelacion politica;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate desde, LocalDate hasta, PoliticaCancelacion politica) {
        this.id = util.GeneradorID.generarIDReserva();
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.desde = desde;
        this.hasta = hasta;
        this.politica = politica;
    }

    // Métodos comunes
    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public Habitacion getHabitacion() { return habitacion; }
    public LocalDate getDesde() { return desde; }
    public LocalDate getHasta() { return hasta; }
    public boolean isCancelada() { return cancelada; }
    public boolean isCheckedIn() { return checkedIn; }
    public PoliticaCancelacion getPolitica() { return politica; }

    // Operaciones básicas
    public void marcarCancelada() { this.cancelada = true; }

    // Se deja abstracto para que cada subclase defina su lógica concreta
    public abstract void marcarCheckIn();
    public abstract void marcarCheckOut();

    @Override
    public String toString() {
        return "Reserva{" +
                "id='" + id + '\'' +
                ", cliente=" + cliente +
                ", habitacion=" + habitacion +
                ", desde=" + desde +
                ", hasta=" + hasta +
                ", cancelada=" + cancelada +
                ", checkedIn=" + checkedIn +
                '}';
    }
}

