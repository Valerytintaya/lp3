package model;

public abstract class Habitacion {
    private final String id;
    private final String numero;
    private final double precioBase;
    private boolean ocupada = false;

    public Habitacion(String numero, double precioBase) {
        this.id = util.GeneradorID.generarIDHabitacion();
        this.numero = numero;
        this.precioBase = precioBase;
    }

    public String getId() { return id; }
    public String getNumero() { return numero; }
    public double getPrecioBase() { return precioBase; }

    public boolean isOcupada() { return ocupada; }
    public void asignar() { this.ocupada = true; }
    public void liberar() { this.ocupada = false; }

    // precio base por tipo - subclases respetan LSP
    public abstract double tipoMultiplicador();

    public double precioPorNoche() { return Math.round(precioBase * tipoMultiplicador() * 100.0) / 100.0; }

    @Override public String toString() {
        return getClass().getSimpleName() + "{" + "id=" + id + ", num=" + numero + ", precioBase=" + precioBase + ", ocupada=" + ocupada + '}';
    }
}
