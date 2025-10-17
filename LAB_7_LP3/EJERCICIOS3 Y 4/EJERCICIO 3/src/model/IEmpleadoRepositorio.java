package model;

import java.util.List;

public interface IEmpleadoRepositorio {
    List<Empleado> leerEmpleados();
    void agregarEmpleado(Empleado empleado);
    Empleado buscarEmpleado(int numero);
    boolean eliminarEmpleado(int numero);
}
