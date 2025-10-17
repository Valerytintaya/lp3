import java.io.*;
import java.util.*;

public class Gestor {
    private Vector<Personaje> personajes = new Vector<>();
    private File archivo;
    private Random random = new Random();

    public Gestor(String rutaArchivo) {
        archivo = new File(rutaArchivo);
        if (archivo.exists()) {
            leerArchivo();
        } else {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.out.println("No se pudo crear el archivo.");
            }
        }
    }

    // ======================= FUNCIONES BÁSICAS =======================
    public boolean agregarPersonaje(Personaje p) {
        if (buscarPorNombre(p.getNombre()) != null) {
            System.out.println("El personaje ya existe.");
            return false;
        }
        personajes.add(p);
        guardarArchivo();
        return true;
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        for (Personaje p : personajes) {
            System.out.println(p);
        }
    }

    private Personaje buscarPorNombre(String nombre) {
        for (Personaje p : personajes) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p;
            }
        }
        return null;
    }

    public boolean modificarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        Personaje p = buscarPorNombre(nombre);
        if (p == null) {
            System.out.println("Personaje no encontrado.");
            return false;
        }
        try {
            p.setVida(vida);
            p.setAtaque(ataque);
            p.setDefensa(defensa);
            p.setAlcance(alcance);
            guardarArchivo();
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Error al modificar: " + e.getMessage());
            return false;
        }
    }

    public boolean borrarPersonaje(String nombre) {
        Personaje p = buscarPorNombre(nombre);
        if (p == null) {
            System.out.println("Personaje no encontrado.");
            return false;
        }
        personajes.remove(p);
        guardarArchivo();
        return true;
    }

    private void guardarArchivo() {
        try (FileWriter fw = new FileWriter(archivo)) {
            for (Personaje p : personajes) {
                fw.write(p.toString() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar archivo.");
        }
    }

    private void leerArchivo() {
        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine().trim();
                if (linea.isEmpty()) continue;

                String[] partes = linea.split(",");
                if (partes.length < 6) continue;

                String nombre = partes[0];
                int vida = Integer.parseInt(partes[1]);
                int ataque = Integer.parseInt(partes[2]);
                int defensa = Integer.parseInt(partes[3]);
                int alcance = Integer.parseInt(partes[4]);
                String tipo = partes[5];

                Personaje p;
                switch (tipo.toLowerCase()) {
                    case "caballero":
                        p = new Caballero(nombre, vida, ataque, defensa, alcance);
                        break;
                    case "arquero":
                        p = new Arquero(nombre, vida, ataque, defensa, alcance);
                        break;
                    case "guerrero":
                        p = new Guerrero(nombre, vida, ataque, defensa, alcance);
                        break;
                    default:
                        p = new Personaje(nombre, vida, ataque, defensa, alcance) {
                            @Override
                            public String getTipo() {
                                return "Desconocido";
                            }
                        };
                }
                personajes.add(p);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado.");
        }
    }

    // Filtrar personajes por atributo
    public void filtrarPorAtributo(String atributo) {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }

        Comparator<Personaje> comparador;

        switch (atributo.toLowerCase()) {
            case "vida":
                comparador = Comparator.comparingInt(Personaje::getVida);
                break;
            case "ataque":
                comparador = Comparator.comparingInt(Personaje::getAtaque);
                break;
            case "defensa":
                comparador = Comparator.comparingInt(Personaje::getDefensa);
                break;
            case "alcance":
                comparador = Comparator.comparingInt(Personaje::getAlcance);
                break;
            default:
                System.out.println("Atributo no válido. Use: vida, ataque, defensa o alcance.");
                return;
        }

        personajes.stream()
                .sorted(comparador.reversed())
                .forEach(System.out::println);
    }

    // Mostrar estadísticas generales
    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }

        double promedioVida = personajes.stream().mapToInt(Personaje::getVida).average().orElse(0);
        double promedioAtaque = personajes.stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double promedioDefensa = personajes.stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double promedioAlcance = personajes.stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println("\n===== ESTADÍSTICAS GENERALES =====");
        System.out.println("Total de personajes: " + personajes.size());
        System.out.printf("Promedio de Vida: %.2f%n", promedioVida);
        System.out.printf("Promedio de Ataque: %.2f%n", promedioAtaque);
        System.out.printf("Promedio de Defensa: %.2f%n", promedioDefensa);
        System.out.printf("Promedio de Alcance: %.2f%n", promedioAlcance);
    }

    // Actualizar atributo individual
    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        Personaje p = buscarPorNombre(nombre);
        if (p == null) {
            System.out.println("Personaje no encontrado.");
            return;
        }

        switch (atributo.toLowerCase()) {
            case "vida":
                p.setVida(nuevoValor);
                break;
            case "ataque":
                p.setAtaque(nuevoValor);
                break;
            case "defensa":
                p.setDefensa(nuevoValor);
                break;
            case "alcance":
                p.setAlcance(nuevoValor);
                break;
            default:
                System.out.println("Atributo no válido.");
                return;
        }
        guardarArchivo();
        System.out.println("Atributo actualizado correctamente.");
    }

    // Cargar personajes aleatorios
    public void cargarAleatorios(int cantidad) {
        String[] tipos = {"Caballero", "Arquero", "Guerrero"};
        for (int i = 0; i < cantidad; i++) {
            String tipo = tipos[random.nextInt(tipos.length)];
            String nombre = tipo + "_Random" + (i + 1);
            int vida = random.nextInt(50) + 80;
            int ataque = random.nextInt(30) + 20;
            int defensa = random.nextInt(20) + 10;
            int alcance = random.nextInt(15) + 5;

            switch (tipo) {
                case "Caballero":
                    personajes.add(new Caballero(nombre, vida, ataque, defensa, alcance));
                    break;
                case "Arquero":
                    personajes.add(new Arquero(nombre, vida, ataque, defensa, alcance));
                    break;
                case "Guerrero":
                    personajes.add(new Guerrero(nombre, vida, ataque, defensa, alcance));
                    break;
            }
        }
        guardarArchivo();
        System.out.println(cantidad + " personajes aleatorios cargados correctamente.");
    }

    // Mejorar atributos con niveles
    public void subirNivel(String nombre, int niveles) {
        Personaje p = buscarPorNombre(nombre);
        if (p == null) {
            System.out.println("Personaje no encontrado.");
            return;
        }
        p.setVida(p.getVida() + niveles * 10);
        p.setAtaque(p.getAtaque() + niveles * 5);
        p.setDefensa(p.getDefensa() + niveles * 3);
        p.setAlcance(p.getAlcance() + niveles * 2);
        guardarArchivo();
        System.out.println(p.getNombre() + " ha subido " + niveles + " nivel(es). Atributos mejorados.");
    }

    // Importar personajes desde archivo externo
    public void importarDesdeArchivo(String ruta) {
        File archivoImport = new File(ruta);
        if (!archivoImport.exists()) {
            System.out.println("El archivo de importación no existe.");
            return;
        }
        try (Scanner sc = new Scanner(archivoImport)) {
            while (sc.hasNextLine()) {
                String[] datos = sc.nextLine().split(",");
                if (datos.length < 6) continue;

                String nombre = datos[0];
                int vida = Integer.parseInt(datos[1]);
                int ataque = Integer.parseInt(datos[2]);
                int defensa = Integer.parseInt(datos[3]);
                int alcance = Integer.parseInt(datos[4]);
                String tipo = datos[5];

                Personaje p;
                switch (tipo.toLowerCase()) {
                    case "caballero":
                        p = new Caballero(nombre, vida, ataque, defensa, alcance);
                        break;
                    case "arquero":
                        p = new Arquero(nombre, vida, ataque, defensa, alcance);
                        break;
                    case "guerrero":
                        p = new Guerrero(nombre, vida, ataque, defensa, alcance);
                        break;
                    default:
                        p = new Personaje(nombre, vida, ataque, defensa, alcance) {
                            @Override
                            public String getTipo() {
                                return "Desconocido";
                            }
                        };
                }
                agregarPersonaje(p);
            }
            System.out.println("Personajes importados exitosamente desde " + ruta);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo externo.");
        }
    }
}
