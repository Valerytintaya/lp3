package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneradorID {
    private static int contador = 1;

    public static synchronized String generarIDReserva() {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return "RES-" + fecha + "-" + (contador++);
    }

    public static synchronized String generarIDHabitacion() {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return "HAB-" + fecha + "-" + (contador++);
    }

    public static synchronized String generarIDCliente() {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return "CLI-" + fecha + "-" + (contador++);
    }

    public static String generarIDEmpleado() {
        String fecha = new SimpleDateFormat("yyyyMMdd").format(new Date());
        return "EMP-" + fecha + "-" + (contador++);
    }
}
