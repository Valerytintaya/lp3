class App{
    public static void main(String[] args) {
    Gestor gestor = new Gestor("personajes.txt");

    System.out.println("\n===== CARGANDO PERSONAJES ALEATORIOS =====");
    gestor.cargarAleatorios(3); // Crea 3 personajes aleatorios y los guarda

    System.out.println("\n===== LISTA INICIAL DE PERSONAJES =====");
    gestor.mostrarPersonajes(); // Muestra todos los personajes cargados

    System.out.println("\n===== AGREGANDO NUEVOS PERSONAJES MANUALMENTE =====");
    gestor.agregarPersonaje(new Caballero("Caballero_Elite", 150, 60, 40, 8));
    gestor.agregarPersonaje(new Arquero("Arquero_Ligero", 90, 45, 20, 18));
    gestor.agregarPersonaje(new Guerrero("Guerrero_Fuerte", 180, 55, 45, 6));

    System.out.println("\n===== LISTA DESPUÉS DE AGREGAR =====");
    gestor.mostrarPersonajes();

    System.out.println("\n===== MODIFICANDO PERSONAJE EXISTENTE =====");
    gestor.modificarPersonaje("Arquero_Ligero", 95, 48, 22, 19);

    System.out.println("\n===== LISTA DESPUÉS DE MODIFICAR =====");
    gestor.mostrarPersonajes();

    System.out.println("\n===== FILTRANDO PERSONAJES POR ATAQUE =====");
    gestor.filtrarPorAtributo("ataque");

    System.out.println("\n===== ACTUALIZANDO ATRIBUTO INDIVIDUAL =====");
    gestor.actualizarAtributo("Caballero_Elite", "vida", 200);

    System.out.println("\n===== SUBIENDO NIVEL =====");
    gestor.subirNivel("Guerrero_Fuerte", 3); 

    System.out.println("\n===== MOSTRANDO ESTADÍSTICAS GENERALES =====");
    gestor.mostrarEstadisticas();

    System.out.println("\n===== IMPORTANDO PERSONAJES DESDE ARCHIVO EXTERNO =====");
    gestor.importarDesdeArchivo("importar.txt"); 

    System.out.println("\n===== LISTA FINAL DE PERSONAJES =====");
    gestor.mostrarPersonajes();

    System.out.println("\n===== BORRANDO UN PERSONAJE =====");
    gestor.borrarPersonaje("Arquero_Ligero");

    System.out.println("\n===== LISTA FINAL DESPUÉS DE BORRAR =====");
    gestor.mostrarPersonajes();

    gestor.filtrarPorAtributo("defensa");

    System.out.println("\n===== ESTADÍSTICAS FINALES =====");
    gestor.mostrarEstadisticas();
}
}