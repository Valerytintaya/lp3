public class Arquero extends Personaje {
    public Arquero(String nombre,int vida, int ataque, int defensa, int alcance) {
        super(nombre,vida, ataque, defensa, alcance);
    }

    @Override
    public String getTipo() {
        return "Arquero";
    }
}
