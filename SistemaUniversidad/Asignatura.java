
class Asignatura {
    private String codigo;
    private String nombre;
    private String descrip;
    private Profesor profesor;
    
    public Asignatura(String c, String n, String m, Profesor p) {
        codigo = c;
        nombre = n;
        descrip = m;
        profesor = p;
    }

    public void mostrarInfo() {
        System.out.println("Codigo: " + codigo + ", Nombre: " + nombre + " - " 
        + descrip + ", Profesor: " + profesor.getNombre());
    }
    // Getters y setters (opcional, para encapsulamiento)
    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getDescrip() { return descrip; }
    public Profesor getProfesor() { return profesor; }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }
}
