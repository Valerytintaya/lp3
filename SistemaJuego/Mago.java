class Mago extends Personaje implements IAtaqueMagico {
    protected int mana;
    protected int curacionExtra;
    public static final String tipo = "Mago";

    public Mago(String nombre, int nivel, int ataque, int mana) {
        super(nombre, nivel, ataque);
        this.mana = mana;
        this.curacionExtra = 10;
    }

    @Override
    public void atacar(Personaje n) {
        System.out.println(nombre + " lanzó un hechizo sobre: " + n.getNombre());
        n.recibir(ataque + mana);
    }

    @Override
    public void mostrar() {
        mostrarInfo();
        System.out.println("Maná: " + mana + " | Curación extra: " + curacionExtra);
    }

    @Override
    public String getNombre() { return nombre; }
    @Override
    public String getTipo() { return tipo; }
    @Override
    public double getVida() { return vida; }

    @Override
    public void lanzarHechizo(Personaje enemigo) {
        int danio = ataque + mana * 2;
        enemigo.recibir(danio);
        System.out.println(nombre + " lanzó un HECHIZO PODEROSO sobre " + enemigo.getNombre());
    }

    @Override
    public void curar(double cantidad) {
        double total = cantidad + curacionExtra;
        super.curar(total);
    }
}
