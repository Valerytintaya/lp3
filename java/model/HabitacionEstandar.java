package model;

public class HabitacionEstandar extends Habitacion {
    public HabitacionEstandar(String numero, double precioBase) { super(numero, precioBase); }
    @Override public double tipoMultiplicador() { return 1.0; }
}
