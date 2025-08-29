import java.util.Vector;
class Profesor extends PersonaU {
    private String nombre;
    private String direc;
    private String telefono;
    Vector<Asignatura> asigs;

    public Profesor(String n, String d, String t) {
        super(n, d);
        nombre = n;
        direc = d;
        telefono = t;
        asigs = new Vector<>();
    }
    
    @Override
    public void agregarAsignatura(Asignatura nueva) {
        asigs.add(nueva);
        System.out.println("Agregado exitosamente...");
    }
    
    @Override
    public void MostrarAsig() {
        System.out.println("Asignaturas de " + nombre + ":");
        for (Asignatura a : asigs) {
            a.mostrarInfo();
        }
    }

    @Override
    public void MostrarInfo() {
        System.out.println(" - " + nombre + " - " + telefono+ " - " + direc);
    }

    @Override
    public String getNombre() { return nombre; }
    @Override
    public String getdirec() { return direc; }

    public String getTelefono() { return telefono; }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDirec(String direc) { this.direc = direc; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
