
import java.time.LocalDate;
import java.util.Scanner;
public class zMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int num;

        do {
            System.out.println("\n--- MENU UNIVERSIDAD ---");
            System.out.println("1. Registrar Estudiante");
            System.out.println("2. Registrar Profesor");
            System.out.println("3. Registrar Asignatura");
            System.out.println("4. Matricular Estudiante");
            System.out.println("5. Registrar Nota para el Estudiante");
            System.out.println("6. Registrar Asistencia para el Estudiante");
            System.out.println("7. Mostrar Estudiantes");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Numero de estudiantes a agregar: ");
                    num = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < num; i++) {
                        System.out.println("========ESTUDIANTE " +(i+1) +" ========");
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Direccion: ");
                        String d = sc.nextLine();
                        SistemaGestion.agregarEstudiante(n,d);
                        System.out.println(" ");
                    }
                    break;
                case 2:
                    System.out.print("Numero de profesores a agregar: ");
                    num = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < num; i++) {
                        System.out.println("========PROFESOR " +(i+1) +" ========");
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Direccion: ");
                        String d = sc.nextLine();
                        System.out.print("Telefono: ");
                        String t = sc.nextLine();
                        SistemaGestion.agregarProfesor(n, d, t);
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    if (SistemaGestion.VerificarProfesores()) {
                        System.out.println("Primero registre profesores");
                        break;
                    }
                    System.out.print("Numero de asignaturas a agregar: ");
                    num = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < num; i++) {
                        System.out.println("========ASIGNATURA " +(i+1) +" ========");
                        System.out.print("Codigo: ");
                        String c = sc.nextLine();
                        System.out.print("Nombre: ");
                        String n = sc.nextLine();
                        System.out.print("Descripcion: ");
                        String d = sc.nextLine();

                        SistemaGestion.MostrarProfesores();
                        System.out.print("Profesor (indice): ");
                        int ind = sc.nextInt();
                        sc.nextLine();
                        
                        Profesor p = SistemaGestion.getP(ind - 1);
                        Asignatura asig = new Asignatura(c, n, d, p);
                        SistemaGestion.agregarAsignatura(asig, p);
                    }
                    break;
                case 4:
                    if ( SistemaGestion.VerificarAsignatura()|| SistemaGestion.VerificarEstudiantes()) {
                        System.out.println("Primero registre estudiantes / asignaturas");
                        break;
                    }
                    SistemaGestion.MostrarEstudiantes();
                    System.out.print("Estudiante (indice): ");
                    int est = sc.nextInt();
                    sc.nextLine();

                    SistemaGestion.MostrarAsignaturas();
                    System.out.print("Asignatura (indice): ");
                    int asig = sc.nextInt();
                    sc.nextLine();
                    SistemaGestion.getE(est - 1).agregarAsignatura(SistemaGestion.getA(asig - 1));
                    break;
                    
                case 5:
                    if ( SistemaGestion.VerificarEstudiantes()) {
                        System.out.println("Primero matricule algún estudiante...");
                        break;
                    }
                    SistemaGestion.MostrarEstudiantes();
                    System.out.print("Estudiante (indice): ");
                    est = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\n===ASIGNATURAS===");
                    SistemaGestion.getE(est - 1).MostrarAsig();
                    System.out.print("Asignatura (indice): ");
                    asig = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nota: ");
                    float nota = sc.nextFloat();
                    Asignatura a = SistemaGestion.getE(est - 1).asigs.get(asig - 1);
                    SistemaGestion.getE(est - 1).agregarNota(new Nota(nota, a));
                    break;
                case 6:
                    if ( SistemaGestion.VerificarEstudiantes()) {
                        System.out.println("Primero matricule algún estudiante...");
                        break;
                    }
                    SistemaGestion.MostrarEstudiantes();
                    System.out.print("Estudiante (indice): ");
                    est = sc.nextInt();
                    sc.nextLine();

                    System.out.println("\n===ASIGNATURAS===");
                    SistemaGestion.getE(est - 1).MostrarAsig();
                    System.out.print("Asignatura (indice): ");
                    asig = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha (yyyy-MM-dd): ");
                    String fecha = sc.nextLine();
                    LocalDate fechat = LocalDate.parse(fecha); 
                    System.out.print("Presente (s/n): ");
                    char pres = sc.next().charAt(0);
                    a = SistemaGestion.getE(est - 1).asigs.get(asig - 1);
                    SistemaGestion.getE(est - 1).agregarAsistencia(new Asistencia(fechat, pres == 's', a));
                    break;
                case 7:
                    for (Estudiante e : SistemaGestion.getEstudiantes()) {
                        e.MostrarInfo();
                        System.out.println();
                    }
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }
}
