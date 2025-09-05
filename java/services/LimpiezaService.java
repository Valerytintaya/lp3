package services;

import model.EmpleadoLimpieza;
import model.Habitacion;

import java.util.*;

public class LimpiezaService {
    private final List<EmpleadoLimpieza> empleados = new ArrayList<>();
    private final Map<String, String> asignaciones = new HashMap<>(); 
    // clave: idHabitacion, valor: idEmpleado

    public EmpleadoLimpieza registrarEmpleado(String nombre) {
        EmpleadoLimpieza e = new EmpleadoLimpieza(nombre);
        empleados.add(e);
        return e;
    }

    public boolean asignarHabitacion(Habitacion h, EmpleadoLimpieza e) {
        if (h.isOcupada()) return false; // no limpiar si está ocupada
        asignaciones.put(h.getId(), e.getId());
        e.asignarHabitacion();
        return true;
    }

    public List<EmpleadoLimpieza> listarEmpleados() { return empleados; }

    public int cargaTrabajo(String empleadoId) {
        return empleados.stream()
                .filter(e -> e.getId().equals(empleadoId))
                .mapToInt(EmpleadoLimpieza::getHabitacionesAsignadas)
                .findFirst().orElse(0);
    }

    public String consultarAsignacion(String habitacionId) {
        return asignaciones.getOrDefault(habitacionId, "No asignado");
    }
}

