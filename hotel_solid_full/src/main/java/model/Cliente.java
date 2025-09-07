package model;

public class Cliente {
    private final String id;
    private final String nombre;
    private final String contacto;

    public Cliente(String nombre, String contacto) {
        this.id = util.GeneradorID.generarIDCliente();
        this.nombre = nombre;
        this.contacto = contacto;
    }

    public String getId(){ return id; }
    public String getNombre(){ return nombre; }
    public String getContacto(){ return contacto; }

    @Override public String toString(){ return nombre + "("+id+")"; }
}
