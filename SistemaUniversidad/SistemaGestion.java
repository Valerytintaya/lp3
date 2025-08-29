import java.util.Vector;

public class SistemaGestion {
    static Vector<Estudiante> estudiantes = new Vector<>();
    static Vector<Profesor> profesores = new Vector<>();
    static Vector<Asignatura> asignaturas = new Vector<>();

    public  static Vector<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public  static Vector<Profesor> getProfesores() {
        return profesores;
    }

    public static Vector<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    //ESTUDAINTES 
    public static void agregarEstudiante(String n, String d){
        estudiantes.add(new Estudiante(n, d));
        System.out.println("Estudiante agregado exitosamente...");
    }
    public static boolean VerificarEstudiantes(){ return estudiantes.isEmpty();}
    public static Estudiante getE(int indice){ return estudiantes.get(indice);}
    public static void MostrarEstudiantes(){ 
        System.out.println("\n===ESTUDIANTES===");
            for (int i = 0; i < estudiantes.size(); i++) {
                System.out.println(i + 1 + " | " + estudiantes.get(i).getNombre());
            }
    }


    //PROFESOR 
    public static void agregarProfesor(String n, String d, String t){
        profesores.add(new Profesor(n, d, t));
        System.out.println("Profesor agregado exitosamente...");
    }
    public static Profesor getP(int indice){ return profesores.get(indice);}
    public static boolean VerificarProfesores(){ return profesores.isEmpty();}
    public static void MostrarProfesores(){ 
        System.out.println("===PROFESORES===");
            for (int j = 0; j < profesores.size(); j++) {
                System.out.print((j + 1) + " | ");
                profesores.get(j).MostrarInfo();
            }
    }

    //ASIGNATURA
    public static void agregarAsignatura(Asignatura a, Profesor p){
        asignaturas.add(a);
        p.agregarAsignatura(a);
        System.out.println("Asignatura agregada exitosamente...");
    }
    public static boolean VerificarAsignatura(){ return asignaturas.isEmpty();}
    public static Asignatura getA(int indice){ return asignaturas.get(indice);}
    public static void MostrarAsignaturas(){ 
        System.out.println("\n===ASIGNATURAS===");
        for (int i = 0; i < asignaturas.size(); i++) {
            System.out.print(i + 1 + " | ");
            asignaturas.get(i).mostrarInfo();
        }
    }
}
