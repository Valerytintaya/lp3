package model;

import java.time.LocalDate;

public class Reserva {
    private final String id;
    private final Cliente cliente;
    private final Habitacion habitacion;
    private final LocalDate desde; // inclusive
    private final LocalDate hasta; // exclusive
    private boolean cancelada = false;
    private boolean checkedIn = false;
    private cancellation.PoliticaCancelacion politica;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate desde, LocalDate hasta, cancellation.PoliticaCancelacion politica) {
        this.id = util.GeneradorID.generarIDReserva();
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.desde = desde;
        this.hasta = hasta;
        this.politica = politica;
    }

    public String getId(){ return id; }
    public Cliente getCliente(){ return cliente; }
    public Habitacion getHabitacion(){ return habitacion; }
    public LocalDate getDesde(){ return desde; }
    public LocalDate getHasta(){ return hasta; }
    public boolean isCancelada(){ return cancelada; }
    public boolean isCheckedIn(){ return checkedIn; }
    public void marcarCancelada(){ this.cancelada = true; }
    public void marcarCheckIn(){ this.checkedIn = true; habitacion.asignar(); }
    public void marcarCheckOut(){ this.checkedIn = false; habitacion.liberar(); }
    public cancellation.PoliticaCancelacion getPolitica(){ return politica; }

    @Override public String toString() {
        return "Reserva{"+id+" cliente="+cliente+" hab="+habitacion.getNumero()+" desde="+desde+" hasta="+hasta+" cancelada="+cancelada+"}";
    }
}
