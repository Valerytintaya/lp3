package vista;

import controlador.EmpleadoControlador;
import model.Empleado;
import java.util.Scanner;

public class EmpleadoVista {

    private  Scanner scanner = new Scanner(System.in);
    private  EmpleadoControlador controlador;

    public EmpleadoVista(EmpleadoControlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- MENÚ DE EMPLEADOS ---");
            System.out.println("1. Listar empleados");
            System.out.println("2. Agregar empleado");
            System.out.println("3. Buscar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> controlador.listarEmpleados();
                case 2 -> agregarEmpleado();
                case 3 -> buscarEmpleado();
                case 4 -> eliminarEmpleado();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    private void agregarEmpleado() {
        System.out.print("Ingrese número del empleado: ");
        int numero = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese nombre del empleado: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese sueldo del empleado: ");
        double sueldo = scanner.nextDouble();

        controlador.agregarEmpleado(new Empleado(numero, nombre, sueldo));
    }

    private void buscarEmpleado() {
        System.out.print("Ingrese número del empleado: ");
        int numero = scanner.nextInt();
        controlador.buscarEmpleado(numero);
    }

    private void eliminarEmpleado() {
        System.out.print("Ingrese número del empleado a eliminar: ");
        int numero = scanner.nextInt();
        controlador.eliminarEmpleado(numero);
    }
}
