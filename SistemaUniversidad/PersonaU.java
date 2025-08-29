abstract class PersonaU {
    protected String nombre, direc; 
    public PersonaU(String n, String d){
        this.nombre=n;
        this.direc=d;
    }

    public abstract String getNombre();
    public abstract String getdirec();
    public abstract void agregarAsignatura(Asignatura n);
    public abstract void MostrarInfo();
    public abstract void MostrarAsig();
}
