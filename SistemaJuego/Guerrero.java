class Guerrero extends Personaje implements IAtaqueFisico {
    protected int cantFuerza;
    public static final String tipo = "Guerrero";

    public Guerrero(String nombre, int nivel, int ataque, int cantFuerza) {
        super(nombre, nivel, ataque);
        this.cantFuerza = cantFuerza;
    }

    @Override
    public void atacar(Personaje n) {
        System.out.println(nombre + " atacó a: " + n.getNombre());
        n.recibir(ataque + cantFuerza);
    }

    @Override
    public void mostrar() {
        mostrarInfo();
        System.out.println("Fuerza: " + cantFuerza);
    }

    @Override
    public String getNombre() { return nombre; }
    @Override
    public String getTipo() { return tipo; }
    @Override
    public double getVida() { return vida; }

    @Override
    public void golpeCritico(Personaje enemigo) {
        int danio = ataque * 2;
        enemigo.recibir(danio);
        System.out.println(nombre + " lanzó un GOLPE CRÍTICO a " + enemigo.getNombre());
    }
}
