package modelo;
public class Cliente {
    private int clienteId;
    private String nombre;
    private String telefono;
    private String correo;

    public Cliente(int clienteId, String nombre, String telefono, String correo) {
        this.clienteId = clienteId;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }
    public Cliente(String nombre, String telefono, String correo) {
        this(0, nombre, telefono, correo);
    }
    // getters y setters
    public int getClienteId(){ return clienteId; }
    public void setClienteId(int id){ this.clienteId = id; }
    public String getNombre(){ return nombre; }
    public String getTelefono(){ return telefono; }
    public String getCorreo(){ return correo; }
    public void setNombre(String n){ this.nombre = n; }
    public void setTelefono(String t){ this.telefono = t; }
    public void setCorreo(String c){ this.correo = c; }
    @Override
    public String toString(){
        return String.format("Cliente[%d] %s | %s | %s", clienteId, nombre, telefono, correo);
    }
}

