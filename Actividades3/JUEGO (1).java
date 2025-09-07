package Actividad;

public class JUEGO {

	public static void main(String[] args) {
        Personaje jugador = new Personaje("Jugador", 200, 10, new EspadaFuego(50));
        Personaje enemigo = new Personaje("Orco", 180, 8, new Hacha(40));

        System.out.println("¡Comienza el combate!");

        while (jugador.estaVivo() && enemigo.estaVivo()) {
            jugador.atacar(enemigo);
            if (!enemigo.estaVivo()) break;
            enemigo.atacar(jugador);
        }

        if (jugador.estaVivo()) {
            System.out.println(jugador.getNombre() + " ha ganado!");
        } else {
            System.out.println(enemigo.getNombre() + " ha ganado!");
        }
    }
}
