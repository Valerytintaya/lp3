package model;
import java.io.*;
import java.util.*;

public class EmpleadoRepositorioArchivo implements IEmpleadoRepositorio {

    private final String rutaArchivo = "empleados.txt";

    @Override
    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int numero = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double sueldo = Double.parseDouble(partes[2]);
                empleados.add(new Empleado(numero, nombre, sueldo));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado. Se creará uno nuevo al agregar empleados.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer empleados: " + e.getMessage());
        }
        return empleados;
    }

    @Override
    public void agregarEmpleado(Empleado empleado) {
        try (FileWriter fw = new FileWriter(rutaArchivo, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(empleado.getNumero() + ";" + empleado.getNombre() + ";" + empleado.getSueldo());
            bw.newLine();
            System.out.println("Empleado agregado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al agregar empleado: " + e.getMessage());
        }
    }

    @Override
    public Empleado buscarEmpleado(int numero) {
        for (Empleado e : leerEmpleados()) {
            if (e.getNumero() == numero)
                return e;
        }
        return null;
    }

    @Override
    public boolean eliminarEmpleado(int numero) {
        List<Empleado> empleados = leerEmpleados();
        boolean eliminado = empleados.removeIf(e -> e.getNumero() == numero);

        if (eliminado) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo))) {
                for (Empleado e : empleados) {
                    bw.write(e.getNumero() + ";" + e.getNombre() + ";" + e.getSueldo());
                    bw.newLine();
                }
                System.out.println("Empleado eliminado correctamente.");
            } catch (IOException e) {
                System.out.println("Error al eliminar empleado: " + e.getMessage());
            }
        }
        return eliminado;
    }
}
