package controlador;
import model.*;
import java.util.List;

public class EmpleadoControlador {

    private IEmpleadoRepositorio repositorio;

    public EmpleadoControlador(IEmpleadoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void listarEmpleados() {
        List<Empleado> empleados = repositorio.leerEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            empleados.forEach(System.out::println);
        }
    }

    public void agregarEmpleado(Empleado empleado) {
        repositorio.agregarEmpleado(empleado);
    }

    public void buscarEmpleado(int numero) {
        Empleado e = repositorio.buscarEmpleado(numero);
        if (e != null)
            System.out.println("Empleado encontrado: " + e);
        else
            System.out.println("Empleado no encontrado.");
    }

    public void eliminarEmpleado(int numero) {
        boolean eliminado = repositorio.eliminarEmpleado(numero);
        if (!eliminado)
            System.out.println("No se encontró ningún empleado con ese número.");
    }
}
