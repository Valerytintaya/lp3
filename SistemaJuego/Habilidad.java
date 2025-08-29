class Habilidad {
    private String nombre;
    private int poder;

    public Habilidad(String nombre, int poder) {
        this.nombre = nombre;
        this.poder = poder;
    }

    public String getNombre() { return nombre; }
    public int getPoder() { return poder; }

    public void usar(Personaje objetivo) {
        objetivo.recibir(poder);
        System.out.println("Se usó la habilidad " 
        + nombre + " causando " + poder + " de daño!");
    }
}
