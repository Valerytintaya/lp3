package Main;

import controlador.EmpleadoControlador;
import model.EmpleadoRepositorioArchivo;
import vista.EmpleadoVista;

public class Main {
    public static void main(String[] args) {
        EmpleadoRepositorioArchivo repo = new EmpleadoRepositorioArchivo();
        EmpleadoControlador controlador = new EmpleadoControlador(repo);
        EmpleadoVista vista = new EmpleadoVista(controlador);

        vista.mostrarMenu();
    }
}
