import java.util.Vector;

class Estudiante extends PersonaU {
    private String nombre, direc;
    public Vector<Asignatura> asigs;
    Vector<Nota> nota;
    Vector<Asistencia> asisten;
    int NumMatricula;
    private static int matricula=1000;

    public Estudiante(String n, String d) {
        super(n, d);
        nombre = n;
        direc = d;
        asigs = new Vector<>();
        nota = new Vector<>();
        asisten = new Vector<>();
        NumMatricula=matricula++;
    }
    
    public boolean verificarAsignatura(){
        return asigs.isEmpty();
    }
    @Override
    public void agregarAsignatura(Asignatura nueva) {
        asigs.add(nueva);
        System.out.println("Agregado exitosamente...");
    }
    
    public void EliminarAsig(int idx){
        if (idx >= 0 && idx < asigs.size()) {
            asigs.remove(idx);
            System.out.println("Asignatura eliminada exitosamente...");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void agregarNota(Nota n) {
        nota.add(n);
        System.out.println("Agregado exitosamente...");
    }

    public void agregarAsistencia(Asistencia asis) {
        asisten.add(asis);
        System.out.println("Agregado exitosamente...");
    }

    @Override
    public void MostrarInfo() {
        System.out.println("Estudiante: " + nombre + ", Matricula: " 
        + matricula+ ", Direccion: " + direc);
        System.out.println("Asignaturas:");
        for (Asignatura a : asigs) a.mostrarInfo();
        
        System.out.println("Notas:");
        
        for (Nota n : nota) n.mostrar();
        
        System.out.println("Asistencias:");
        for (Asistencia a : asisten) a.mostrar();
    }
    @Override
    public void MostrarAsig() {
        for (int i = 0; i < asigs.size(); i++) {
            System.out.print(i + 1 + " | ");
            asigs.get(i).mostrarInfo();
        }
    }

    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public String getdirec() {
        return direc;
    }
}
