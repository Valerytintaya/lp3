public abstract class Personaje {
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (vida <= 0 || ataque <= 0 || defensa <= 0 || alcance <= 0) {
            throw new IllegalArgumentException("Todos los atributos deben ser mayores a 0.");
        }
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.alcance = alcance;
    }

    public abstract String getTipo();
    
    public String getNombre(){return nombre;}
    
    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida <= 0) throw new IllegalArgumentException("Vida debe ser mayor a 0.");
        this.vida = vida;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque <= 0) throw new IllegalArgumentException("Ataque debe ser mayor a 0.");
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        if (defensa <= 0) throw new IllegalArgumentException("Defensa debe ser mayor a 0.");
        this.defensa = defensa;
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        if (alcance <= 0) throw new IllegalArgumentException("Alcance debe ser mayor a 0.");
        this.alcance = alcance;
    }

    @Override
    public String toString() {
        return getNombre() + "," + getVida() + "," + getAtaque() + "," + getDefensa() + "," + getAlcance() + "," + getTipo();
    } 
}




