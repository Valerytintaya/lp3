package app;

import model.*;
import cancellation.*;
import notification.*;
import pricing.*;
import services.*;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // ==== Servicios ====
        HabitacionService habitacionService = new HabitacionService();

        // Notificador (podrías usar SMS también)
        NotificadorReserva notificador = new NotificadorReserva(new EnviadorCorreo());

        // Promociones
        List<Promocion> promociones = new ArrayList<>();
        promociones.add(new PromocionClienteFrecuente());
        promociones.add(new PromocionTemporadaAlta());
        CalculadoraPrecio calculadora = new CalculadoraPrecio(promociones);

        // Servicios principales
        ReservaService reservaService = new ReservaService(notificador, calculadora);
        CheckInOutService checkInOutService = new CheckInOutService(reservaService.listarReservas(), notificador);
        LimpiezaService limpiezaService = new LimpiezaService();
        ReporteService reporteService = new ReporteService();

        // ==== Datos de ejemplo ====
        habitacionService.crearHabitacion("101", "estandar", 100);
        habitacionService.crearHabitacion("102", "suite", 200);

        Cliente cliente = new Cliente("Juan", "juan@mail.com");

        System.out.println("=== Sistema de Reservas Hotel ===");
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Listar habitaciones");
            System.out.println("2. Crear reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Check-in");
            System.out.println("5. Check-out");
            System.out.println("6. Registrar empleado limpieza");
            System.out.println("7. Asignar limpieza");
            System.out.println("8. Reporte ocupación");
            System.out.println("9. Listar reservas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int op = sc.nextInt();
            sc.nextLine();

            try {
                switch (op) {
                    case 1 -> {
                        System.out.println("Habitaciones:");
                        for (Habitacion h : habitacionService.listarHabitaciones()) {
                            System.out.println(h);
                        }
                    }
                    case 2 -> {
                        System.out.print("Número de habitación: ");
                        String num = sc.nextLine();
                        Habitacion h = habitacionService.listarHabitaciones().stream()
                                .filter(x -> x.getNumero().equals(num))
                                .findFirst().orElse(null);
                        if (h == null) {
                            System.out.println("No existe la habitación.");
                            break;
                        }
                        System.out.print("Desde (YYYY-MM-DD): ");
                        LocalDate desde = LocalDate.parse(sc.nextLine());
                        System.out.print("Hasta (YYYY-MM-DD): ");
                        LocalDate hasta = LocalDate.parse(sc.nextLine());

                        PoliticaCancelacion politica = new PoliticaFlexible();
                        String id = reservaService.crearReserva(cliente, h, desde, hasta, politica);
                        System.out.println("Reserva creada con ID: " + id);
                    }
                    case 3 -> {
                        System.out.print("ID reserva: ");
                        String id = sc.nextLine();
                        reservaService.cancelarReserva(id, LocalDate.now());
                    }
                    case 4 -> {
                        System.out.print("ID reserva: ");
                        String id = sc.nextLine();
                        checkInOutService.checkIn(id, LocalDate.now());
                    }
                    case 5 -> {
                        System.out.print("ID reserva: ");
                        String id = sc.nextLine();
                        checkInOutService.checkOut(id);
                    }
                    case 6 -> {
                        System.out.print("Nombre empleado: ");
                        String nombre = sc.nextLine();
                        EmpleadoLimpieza e = limpiezaService.registrarEmpleado(nombre);
                        System.out.println("Empleado registrado: " + e);
                    }
                    case 7 -> {
                        System.out.print("Número habitación: ");
                        String num = sc.nextLine();
                        Habitacion h = habitacionService.listarHabitaciones().stream()
                                .filter(x -> x.getNumero().equals(num))
                                .findFirst().orElse(null);
                        if (h == null) {
                            System.out.println("Habitación no existe");
                            break;
                        }
                        if (limpiezaService.listarEmpleados().isEmpty()) {
                            System.out.println("No hay empleados registrados");
                            break;
                        }
                        EmpleadoLimpieza e = limpiezaService.listarEmpleados().get(0); // simple
                        limpiezaService.asignarHabitacion(h, e);
                        System.out.println("Habitación asignada a: " + e.getNombre());
                    }
                    case 8 -> {
                        double porc = reporteService.ocupacion(
                                habitacionService.listarHabitaciones(),
                                reservaService.listarReservas(),
                                LocalDate.now().minusDays(1),
                                LocalDate.now().plusDays(30)
                        );
                        System.out.println("Ocupación: " + porc + "%");
                    }
                    case 9 -> {
                        System.out.println("Reservas:");
                        for (Reserva r : reservaService.listarReservas()) {
                            System.out.println(r);
                        }
                    }
                    case 0 -> salir = true;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
