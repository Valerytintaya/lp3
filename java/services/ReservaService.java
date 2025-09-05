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

   
}

