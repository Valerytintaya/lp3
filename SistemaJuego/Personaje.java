import java.util.ArrayList;

abstract class Personaje {
    protected String nombre;
    protected int nivel;
    protected double vida;
    protected int ataque;

    protected Inventario inventario; // agregación
    protected ArrayList<Habilidad> habilidades; // composición

    public static int contador = 0;
    public static final int MAX_VIDA = 100;
    public static final String NOMBRE_MUNDO = "Eldoria";

    public Personaje(String nombre, int nivel, int ataque) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.ataque = ataque;
        this.vida = MAX_VIDA;
        this.inventario = new Inventario();
        this.habilidades = new ArrayList<>();
        contador++;
    }

    // Métodos abstractos
    public abstract void atacar(Personaje enemigo);
    public abstract void mostrar();
    public abstract String getNombre();
    public abstract String getTipo();
    public abstract double getVida();

    // Métodos de instancia
    protected void recibir(int danio) {
        this.vida -= danio;
        if (this.vida < 0) this.vida = 0;
        System.out.println(this.nombre + " ha recibido " + danio 
        + " de daño. Vida: " + this.vida);
    }

    protected void curar(double cantidad) {
        this.vida += cantidad;
        if (this.vida > MAX_VIDA) this.vida = MAX_VIDA;
        System.out.println(this.nombre + " se ha curado. Vida: " + this.vida);
    }

    void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " | Nivel: " + nivel + 
                           " | Vida: " + vida + " | Ataque: " + ataque);
    }

    // Sobrecarga de métodos
    public void usarHabilidad(Habilidad h) {
        System.out.println(nombre + " usó " + h.getNombre() + " al aire.");
    }

    public void usarHabilidad(Habilidad h, Personaje objetivo) {
        System.out.println(nombre + " usó " + h.getNombre() 
        + " sobre " + objetivo.getNombre());
        h.usar(objetivo);
    }

    public Inventario getInventario() { return inventario; }
    public void aprenderHabilidad(Habilidad h) {
        habilidades.add(h);
        System.out.println(nombre + " aprendió la habilidad " + h.getNombre());
    }
}