package model;

public abstract class Empleado {
    private final String id;
    private final String nombre;

    public Empleado(String nombre) {
        this.id = util.GeneradorID.generarIDEmpleado();
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
