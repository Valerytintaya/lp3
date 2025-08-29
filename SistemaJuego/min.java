import java.util.Scanner;
import java.util.Vector;

class min {
    static Vector<Personaje> personajes = new Vector<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        do {
            System.out.println("\n=== MENU DEL JUEGO ===");
            System.out.println("1. Crear Guerrero");
            System.out.println("2. Crear Mago");
            System.out.println("3. Mostrar Personajes");
            System.out.println("4. Agregar Objeto a un Personaje");
            System.out.println("5. Enseñar Habilidad a un Personaje");
            System.out.println("6. Atacar entre Personajes");
            System.out.println("7. Ver Inventario de un Personaje");
            System.out.println("8. Salir");
            System.out.print("Opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1 -> crearGuerrero();
                case 2 -> crearMago();
                case 3 -> mostrarPersonajes();
                case 4 -> agregarObjeto();
                case 5 -> enseniarHabilidad();
                case 6 -> pelear();
                case 7 -> mostrarInventario();
                case 8 -> System.out.println("Saliendo del juego...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 8);
    }

    // === OPCIONES ===
    public static void crearGuerrero() {
        sc.nextLine(); // limpiar buffer
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        System.out.print("Nivel: ");
        int nivel = sc.nextInt();
        System.out.print("Ataque: ");
        int atk = sc.nextInt();
        System.out.print("Fuerza: ");
        int fuerza = sc.nextInt();
        personajes.add(new Guerrero(n, nivel, atk, fuerza));
        System.out.println("Guerrero creado!");
    }

    public static void crearMago() {
        sc.nextLine();
        System.out.print("Nombre: ");
        String n = sc.nextLine();
        System.out.print("Nivel: ");
        int nivel = sc.nextInt();
        System.out.print("Ataque: ");
        int atk = sc.nextInt();
        System.out.print("Maná: ");
        int mana = sc.nextInt();
        personajes.add(new Mago(n, nivel, atk, mana));
        System.out.println("Mago creado!");
    }

    public static void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes creados.");
            return;
        }
        System.out.println("\n=== PERSONAJES ===");
        for (int i = 0; i < personajes.size(); i++) {
            System.out.print((i + 1) + ". ");
            personajes.get(i).mostrar();
        }
    }

    public static void agregarObjeto() {
        if (personajes.isEmpty()) { System.out.println("No hay personajes."); return; }
        mostrarPersonajes();
        System.out.print("Seleccione personaje: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        System.out.print("Nombre objeto: ");
        String nom = sc.nextLine();
        System.out.print("Tipo objeto: ");
        String tipo = sc.nextLine();
        System.out.print("Valor: ");
        int valor = sc.nextInt();
        personajes.get(idx).getInventario().agregarObjeto(new Objeto(nom, tipo, valor));
    }

    public static void enseniarHabilidad() {
        if (personajes.isEmpty()) { System.out.println("No hay personajes."); return; }
        mostrarPersonajes();
        System.out.print("Seleccione personaje: ");
        int idx = sc.nextInt() - 1;
        sc.nextLine();
        System.out.print("Nombre habilidad: ");
        String nom = sc.nextLine();
        System.out.print("Poder: ");
        int poder = sc.nextInt();
        personajes.get(idx).aprenderHabilidad(new Habilidad(nom, poder));
    }

    public static void pelear() {
        if (personajes.size() < 2) { System.out.println("Se necesitan al menos 2 personajes."); return; }
        mostrarPersonajes();
        System.out.print("Atacante: ");
        int a = sc.nextInt() - 1;
        System.out.print("Objetivo: ");
        int b = sc.nextInt() - 1;
        Personaje atacante = personajes.get(a);
        Personaje objetivo = personajes.get(b);

        if (atacante instanceof Guerrero g) {
            System.out.println("1. Ataque normal  2. Golpe Crítico");
            int tipo = sc.nextInt();
            if (tipo == 1) g.atacar(objetivo);
            else g.golpeCritico(objetivo);
        } else if (atacante instanceof Mago m) {
            System.out.println("1. Ataque normal  2. Hechizo Poderoso  3. Curar");
            int tipo = sc.nextInt();
            if (tipo == 1) m.atacar(objetivo);
            else if (tipo == 2) m.lanzarHechizo(objetivo);
            else {
                System.out.print("Cantidad a curar: ");
                int cant = sc.nextInt();
                m.curar(cant);
            }
        }
    }

    public static void mostrarInventario() {
        if (personajes.isEmpty()) { System.out.println("No hay personajes."); return; }
        mostrarPersonajes();
        System.out.print("Seleccione personaje: ");
        int idx = sc.nextInt() - 1;
        personajes.get(idx).getInventario().mostrarObjetos();
    }
}
