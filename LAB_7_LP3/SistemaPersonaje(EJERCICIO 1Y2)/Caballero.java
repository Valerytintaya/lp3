public class Caballero extends Personaje {
    public Caballero(String nombre,int vida, int ataque, int defensa, int alcance) {
        super(nombre,vida, ataque, defensa, alcance);
    }

    @Override
    public String getTipo() {
        return "Caballero";
    }
}
