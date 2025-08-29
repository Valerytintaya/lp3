// Clase Persona
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private Cuenta cuenta;  // Composición

    // Constructor
    public Persona(int id, String nombre, String apellido, int numeroCuenta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        // Relación de composición: una Persona siempre tiene una Cuenta
        this.cuenta = new Cuenta(numeroCuenta);
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    // Método toString
    @Override
    public String toString() {
        return "Persona [ID=" + id + ", Nombre=" + nombre + " " 
        + apellido + ", " + cuenta.toString() + "]";
    }
}

