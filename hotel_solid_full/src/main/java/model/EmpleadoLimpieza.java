package model;

public class EmpleadoLimpieza extends Empleado {
    private int habitacionesAsignadas = 0;

    public EmpleadoLimpieza(String nombre) {
        super(nombre);
    }

    public void asignarHabitacion() { habitacionesAsignadas++; }
    public int getHabitacionesAsignadas() { return habitacionesAsignadas; }
}

