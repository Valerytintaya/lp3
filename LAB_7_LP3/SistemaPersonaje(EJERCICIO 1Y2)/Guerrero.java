public class Guerrero extends Personaje {
    public Guerrero(String nombre,int vida, int ataque, int defensa, int alcance) {
        super(nombre, vida, ataque, defensa, alcance);
    }

    @Override
    public String getTipo() {
        return "Guerrero";
    }
}