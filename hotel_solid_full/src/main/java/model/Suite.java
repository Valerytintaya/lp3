package model;

public class Suite extends Habitacion {
    public Suite(String numero, double precioBase) { super(numero, precioBase); }
    @Override public double tipoMultiplicador() { return 1.5; }
}
