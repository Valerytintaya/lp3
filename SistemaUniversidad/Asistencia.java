import java.time.LocalDate;

class Asistencia {
    private LocalDate fecha;
    private boolean presente;
    private Asignatura asig;

    public Asistencia(LocalDate f, boolean p, Asignatura a) {
        this.fecha = f;
        this.presente = p;
        this.asig = a;
    }

    public void mostrar() {
        System.out.println("Fecha: " + fecha + 
                           " - Asignatura: " + asig.getNombre() + 
                           " - " + (presente ? "Presente" : "Ausente"));
    }

    // Getters y setters
    public LocalDate getFecha() { return fecha; }
    public boolean isPresente() { return presente; }
    public Asignatura getAsig() { return asig; }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }

    public void setAsig(Asignatura asig) {
        this.asig = asig;
    }
}
